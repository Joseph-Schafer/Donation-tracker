import java.util*;
import java.sql.TIMESTAMP;

public class Donation(){

    private String name;
    private double total;
    private TIMESTAMP date;

    public Donation(String name, double amount, TIMESTAMP time ){
        this.name = name;
        this.total = amount;
        date = new TIMESTAMP(time);
    }

    public Set<DonationChunk> SplitDonation(){

    }




}