package faang.school.godbless.walmart;

public class CashierThread extends Thread {
  private int cashierId;
  private String[] customerItems;

  public CashierThread(int cashierId, String[] customerItems) {
    this.cashierId = cashierId;
    this.customerItems = customerItems;
  }

  @Override
  public void run() {
    for (String item : customerItems) {
      System.out.println(item);
    }
  }
}
