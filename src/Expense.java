import java.util*.;

public class Expense extends FinancialEntry {

  private ExpenseType expense;
  private int amount;
  private Timestamp timestamp;

  public Expense(ExpenseType expense, int amount, Timestamp timestamp) {
     this(expense,amount,timestamp);
  }

  public ExpenseType getExpense() {
    return expense;
  }

}
