import java.util.*;
import java.sql.Timestamp;

public class Expense extends FinancialEntry {

  private ExpenseType expense;

  public Expense(ExpenseType expense, int amount, Calendar timestamp) {
     super(Math.abs(amount), timestamp);
     this.expense = expense;
  }

  public ExpenseType getExpense() {
    return expense;
  }

}
