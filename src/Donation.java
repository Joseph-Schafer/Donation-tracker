import java.util.*;
import java.sql.Timestamp;

public class Donation extends FinancialEntry{

    private String name;

    public Donation(String name, int amount, Calendar time ){
        super(amount, time);
        this.name=  name;
    }

    public List<DonationChunk> SplitDonation(){
        List<DonationChunk> chunks = new ArrayList<DonationChunk>();
        int copyOfTotal = this.getAmount();
        while(copyOfTotal >= 5){
            chunks.add(new DonationChunk(this.name, this.getTimestamp()));
            copyOfTotal -= 5;
        }

        if(copyOfTotal != 0) {
            chunks.add(new DonationChunk(this.name, this.getTimestamp(), copyOfTotal));
        }
        return chunks;
    }

    public String toString(){
        return ("amount: " + getAmount() + ", name: " + name);
    }
}