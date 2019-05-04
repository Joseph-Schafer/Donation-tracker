import java.sql.Timestamp;
import java.util.Calendar;

public class FinancialEntry {
  private int amount;
  private Calendar timestamp;

  public FinancialEntry(int amount, Calendar timestamp) {
    this.amount = amount;
    this.timestamp = timestamp;
  }

  public int getAmount() {
    return amount;
  }

  public Calendar getTimestamp() {
    return timestamp;
  }

}
