import java.util.*;
import java.sql.Timestamp;

public class Donation extends FinancialEntry{

    private String name;
    private int total;
    private Timestamp date;

    public Donation(String name, int amount, Timestamp time ){
        super(amount, time);
        this.name=  name;
    }

    public List<DonationChunk> SplitDonation(){
        List<DonationChunk> chunks = new ArrayList<DonationChunk>();
        int copyOfTotal = this.total;
        while(copyOfTotal >= 5){
            chunks.add(new DonationChunk(this.name, this.date));
            copyOfTotal -= 5;
        }

        if(this.total != 0) {
            chunks.add(new DonationChunk(this.name, this.date, this.total));
        }
        return chunks;
    }
}