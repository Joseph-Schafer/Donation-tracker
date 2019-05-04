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

    public List<DonationChunk> SplitDonation(){
        List<DonationChunk> chunks = new ArrayList<DonationChunk>();
        double copyOfTotal = this.total;
        while(copyOfTotal >= 5.0){
            chunks.add(new DonationChunk(this.name, this.date));
        }


    }




}