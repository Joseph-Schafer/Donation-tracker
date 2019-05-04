import java.util.*;
import java.io.*;
import java.sql.Timestamp;

public class Parser {

    public static void main(String[] args) throws FileNotFoundException{
        File theFile = new File("./testfiles/TestFile_10.csv");
        Scanner scanFile = new Scanner(theFile);
        List<FinancialEntry> list = organize(scanFile);
        for (int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }

    }

    public static List<FinancialEntry> organize(Scanner theScanner){
        List<FinancialEntry> financialEntries = new ArrayList<>();
        theScanner.nextLine();
        while (theScanner.hasNextLine()){
            FinancialEntry thisObject = null;
            String thisLine = theScanner.nextLine();
            String[] thisAmount = thisLine.split(",", 4);
            if (Integer.parseInt(thisAmount[2]) > 0){
                thisObject = new Donation(thisAmount[3], Integer.parseInt(thisAmount[2]), Timestamp.valueOf(thisAmount[1]));

            }
            else {
                //thisObject = new Expense(thisAmount[3],Integer.parseInt(thisAmount[2]), Timestamp.valueOf(thisAmount[1]));
            }
            financialEntries.add(thisObject);
        }
        return financialEntries;
    }

    //  theScanner.next();


    // have not implemented
    //   throw new RuntimeException();

    //
    /*




     */




}
