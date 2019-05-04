import java.sql.Timestamp;
import java.util.*;

public class DonationChunk extends FinancialEntry{

    private String donator;
    private Timestamp time;
    private int amount;

    public DonationChunk(String name, Timestamp time){
        this(name, time, 5);
    }

    public DonationChunk(String name, Timestamp time, int amount) {
        super(amount, time);
        this.donator = name;
    }

}