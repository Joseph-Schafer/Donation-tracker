import java.sql.Timestamp;

public class FinancialEntry {
  private int amount;
  private Timestamp timestamp;

  public FinancialEntry(int amount, Timestamp timestamp) {
    this.amount = amount;
    this.timestamp = timestamp;
  }

  public int getAmount() {
    return amount;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

}
