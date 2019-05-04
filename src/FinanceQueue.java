import java.util.*;

public class FinanceQueue {
  private PriorityQueue<DonationChunk> queue;

  public FinanceQueue(List<FinancialEntry> list) {
    this.queue = new PriorityQueue<DonationChunk>();
    for(FinancialEntry entry : list) {
      if( entry instanceof Donation ) {
        Donation donationEntry = (Donation) entry;
        List<DonationChunk> chunkList = donationEntry.SplitDonation();
        for(DonationChunk chunk : chunkList) {
          queue.add(chunk);
        }
      } else if (entry instanceof Expense) {
        this.remove((Expense) entry);
      } else { //UNREACHABLE, PARSER FAILED IF ENTERING BRANCH
        throw new IllegalArgumentException("Bad entry in FinancialEntry list");
      }
    }
  }

  private void remove(Expense expense) {

  }
}
