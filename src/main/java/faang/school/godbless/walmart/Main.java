package faang.school.godbless.walmart;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String[][] customers = {
        {"Bread", "Milk", "Tea", "Water"},
        {"Cake", "Water", "Salt"},
        {"Oranges", "Bananas", "Ice cream"}
    };

    List<CashierThread> cashiers = new ArrayList<>(customers.length);

    for (int i = 0; i < customers.length; i++) {
      CashierThread cashierThread = new CashierThread(i, customers[i]);
      cashiers.add(cashierThread);
      cashierThread.start();

      try {
        cashierThread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("all customers are served");
  }
}
