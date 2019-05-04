import java.util.*;

public class DonationChunk{

    private String donator;
    private TIMESTAMP time;
    private double amount;

    public DonationChunk(String name, TIMESTAMP time, double amt){
        this.donator = name;
        this.time = time;
        this.amount = amt;
    }


}