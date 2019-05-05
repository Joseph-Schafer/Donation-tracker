import java.util.*;
import java.io.*;
import org.json.simple.*;

public class FinanceQueue {
  private PriorityQueue<DonationChunk> queue;

  public FinanceQueue(List<FinancialEntry> list) throws IOException{
    this.queue = new PriorityQueue<DonationChunk>();
    for(FinancialEntry entry : list) {
      if( entry instanceof Donation ) {
        Donation donationEntry = (Donation) entry;
        List<DonationChunk> chunkList = donationEntry.SplitDonation();
        for(DonationChunk chunk : chunkList) {
          queue.add(chunk);
        }
      } else if (entry instanceof Expense) {
        this.remove((Expense) entry);
      }
    }
  }

  private void remove(Expense expense) throws IOException{
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
      writeToJson(chunk.getDonator(), chunkAmt, chunk.getTimestamp());
    }
  }


  private void writeToJson(String donor, int amt, Calendar time) throws IOException {

  }
}
