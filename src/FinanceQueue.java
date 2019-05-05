import java.util.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FinanceQueue {
  private PriorityQueue<DonationChunk> queue;

  public FinanceQueue(List<FinancialEntry> list) throws IOException, ParseException{
    this.queue = new PriorityQueue<DonationChunk>();
    for(FinancialEntry entry : list) {
      if( entry instanceof Donation ) {
        Donation donationEntry = (Donation) entry;
        List<DonationChunk> chunkList = donationEntry.SplitDonation();
        for(DonationChunk chunk : chunkList) {
          queue.add(chunk);
        }
        addDonationToJSON((Donation) entry);
      } else if (entry instanceof Expense) {
        this.remove((Expense) entry);
      }
    }
  }

  private void remove(Expense expense) throws IOException, ParseException{
    int totalExpense = expense.getAmount();

    while(totalExpense > 0) {
      DonationChunk chunk = queue.remove();
      int chunkAmt = chunk.getAmount();
      if (chunkAmt > totalExpense) {
        DonationChunk toAdd = new DonationChunk(chunk.getDonator(), chunk.getTimestamp(),
            chunkAmt - totalExpense);
        chunkAmt = totalExpense;
        totalExpense = 0;
        queue.add(toAdd);
      } else {
        totalExpense -= chunkAmt;
      }
      writeToJSON(chunk.getDonator(), chunkAmt, chunk.getTimestamp(), expense.getExpense());
    }
  }

  private void addDonationToJSON(Donation donation) throws IOException, ParseException {
    String donor = donation.getName();
    int amt = donation.getAmount();
    long timestamp = donation.getTimestamp().getTimeInMillis();

    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader("../web/src/donation-history.json");

    JSONArray donationList = (JSONArray) jsonParser.parse(reader);

    JSONObject usersObject = (JSONObject) donationList.get(0);
    JSONArray users = (JSONArray) usersObject.get("user");
    for(int i = 0; i < users.size(); i++) {

      JSONObject user = (JSONObject) users.get(i);
      String name = (String) user.get("user");
      if (name.equals(donor)) {
        JSONArray donations = (JSONArray) user.get("donations");
        JSONObject newDonation = new JSONObject();
        newDonation.put("amount", amt);
        newDonation.put("timestamp", timestamp);
        donations.add(newDonation);
        users.remove(i);
        users.add(i, user);
      }
    }
  }


  private void writeToJSON(String donor, int amt, Calendar time, ExpenseType expenseType) throws IOException,
      ParseException {
    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader("../web/src/donation-history.json");

    JSONArray donationList = (JSONArray) jsonParser.parse(reader);

    JSONObject usersObject = (JSONObject) donationList.get(0);
    JSONArray users = (JSONArray) usersObject.get("user");
    for(int i = 0; i < users.size(); i++) {

      JSONObject user = (JSONObject) users.get(i);
      String name = (String) user.get("user");
      if (name.equals(donor)) {

        JSONArray allocationsByUser = (JSONArray) user.get("allocations");

        JSONObject newAllocation = new JSONObject();
        newAllocation.put("amount", amt);
        newAllocation.put("cause", expenseType);
        newAllocation.put("timestamp", time.getTimeInMillis());
        allocationsByUser.add(newAllocation);

        JSONObject totalAllocByUser = (JSONObject) user.get("totalAllocations");
        if(expenseType.equals(ExpenseType.CLOTHING)) {
          totalAllocByUser.put("clothing", ((Integer) totalAllocByUser.get("clothing"))+amt);
        }else if(expenseType.equals(ExpenseType.EVENTS)) {
          totalAllocByUser.put("events", ((Integer) totalAllocByUser.get("events"))+amt);
        }else if(expenseType.equals(ExpenseType.FOOD)) {
          totalAllocByUser.put("food", ((Integer) totalAllocByUser.get("food"))+amt);
        }else if(expenseType.equals(ExpenseType.FUNDRAISING)) {
          totalAllocByUser.put("fundraising", ((Integer) totalAllocByUser.get("fundraising"))+amt);
        }else if(expenseType.equals(ExpenseType.MEDICAL_SUPPLIES)) {
          totalAllocByUser.put("medicalSupplies",
              ((Integer) totalAllocByUser.get("medicalSupplies"))+amt);
        }
      }
      users.remove(i);
      users.add(i, user);
    }

  }
}
