
import java.util.*;

public class DonationChunk extends FinancialEntry implements Comparable<DonationChunk> {

    private String donator;
    private Calendar time;
    private int amount;

    public DonationChunk(String name, Calendar time){
        this(name, time, 5);
    }

    public DonationChunk(String name, Calendar time, int amount) {
        super(amount, time);
        this.donator = name;
    }

    public String getDonator() {
        return donator;
    }

    public int compareTo(DonationChunk other) {
        return -1;

    }
}