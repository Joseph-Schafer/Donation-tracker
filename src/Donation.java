import java.util.*;
import java.sql.Timestamp;

public class Donation {

    private String name;
    private int total;
    private Timestamp date;

    public Donation(String name, int amount, Timestamp time ){
        this.name = name;
        this.total = amount;
        this.date = time;
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