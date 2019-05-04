import java.util.*;
import java.sql.Timestamp;

public class Expense extends FinancialEntry {

  private ExpenseType expense;
  private int amount;
  private Timestamp timestamp;

  public Expense(ExpenseType expense, int amount, Timestamp timestamp) {
     super(Math.abs(amount), timestamp);
  }

  public ExpenseType getExpense() {
    return expense;
  }

}
