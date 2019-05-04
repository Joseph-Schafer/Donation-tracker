import java.sql.Timestamp;
import java.util.*;

public class DonationChunk{

    private String donator;
    private Timestamp time;
    private int amount;

    public DonationChunk(String name, Timestamp time){
        this.donator = name;
        this.time = time;
    }

    public DonationChunk(String name, Timestamp time, int amount) {
        this.donator = name;
        this.time = time;
        this.amount = amount;
    }

}