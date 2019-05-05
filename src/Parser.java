import java.util.*;
import java.io.*;
import java.text.*;

public class Parser {

    private List<FinancialEntry> entries;

    public Parser(File theData) throws FileNotFoundException{
        //File theFile = new File("./testfiles/TestFile_10.csv");
        Scanner scanFile = new Scanner(theData);
        entries = organize(scanFile);

        //Test
        //for (int i = 0; i < list.size(); i ++){
        //    System.out.println(list.get(i).getAmount());
        //}
    }

    private List<FinancialEntry> organize(Scanner theScanner){
        List<FinancialEntry> financialEntries = new ArrayList<>();
        theScanner.nextLine();
        while (theScanner.hasNextLine()){
            FinancialEntry thisObject = null;
            String thisLine = theScanner.nextLine();
            String[] thisAmount = thisLine.split(",", 4);
            if (Integer.parseInt(thisAmount[2]) > 0){
                thisObject = new Donation(thisAmount[3], Integer.parseInt(thisAmount[2]), convertToCal(thisAmount[1]));
            }
            else {
                ExpenseType theExpense = null;
                if (thisAmount[3].equals("FUNDRAISING")){
                    theExpense = ExpenseType.FUNDRAISING;
                }
                else if (thisAmount[3].equals("FOOD")){
                    theExpense = ExpenseType.FOOD;
                }
                if (thisAmount[3].equals("CLOTHING")){
                    theExpense = ExpenseType.CLOTHING;
                }
                if (thisAmount[3].equals("MEDICAL_SUPPLIES")){
                    theExpense = ExpenseType.MEDICAL_SUPPLIES;
                }
                if (thisAmount[3].equals("EVENTS")){
                    theExpense = ExpenseType.EVENTS;
                }
                thisObject = new Expense(theExpense,Integer.parseInt(thisAmount[2]), convertToCal(thisAmount[1]));
            }
            financialEntries.add(thisObject);
        }
        return financialEntries;
    }

    private Calendar convertToCal(String date){
        Calendar cal = null;
        try {
            cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            cal.setTime(sdf.parse("Mon Mar 14 16:02:37 GMT 2011"));
        }
        catch (Exception e){
        }
        return cal;
    }

    public List<FinancialEntry> getEntries() {
        return entries;
    }
}
