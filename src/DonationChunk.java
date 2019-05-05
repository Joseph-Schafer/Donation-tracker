
import java.util.*;

public class DonationChunk extends FinancialEntry implements Comparable<DonationChunk> {

    private String donator;

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
       if(other.getTimestamp().getWeekYear() != this.getTimestamp().getWeekYear() ||
            other.getTimestamp().getWeeksInWeekYear() != this.getTimestamp().getWeeksInWeekYear()) {
           return this.getTimestamp().compareTo(other.getTimestamp());
       }

       if(Math.random() > 0.5) {
           return 1;
       }

       return -1;

    }
}