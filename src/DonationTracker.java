import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;


public class DonationTracker {

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        File thisData = new File("./testfiles/RevisedTestFile_50.csv");
        Parser thisParser = new Parser(thisData);
        System.out.println(thisParser.getEntries().toString());
        for (FinancialEntry x : thisParser.getEntries()) {
            System.out.println(x);
        }
        FinanceQueue q = new FinanceQueue(thisParser.getEntries());
    }
}
