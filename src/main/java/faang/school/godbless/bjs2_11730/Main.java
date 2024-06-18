package faang.school.godbless.bjs2_11730;

import static faang.school.godbless.ColorScheme.RESET;

public class Main {

  private static final String CASHIERING_IS_COMPLETE = "Работа кассиров завершена!";

  public static void main(String[] args) {
    final String[][] customers = {{"Молоко", "Хлеб", "Сметана", "Семечки"},
        {"Бананы", "Апельсины", "Кефир"},
        {"Пельмени", "Сыр", "Хлебцы", "Кетчуп", "Яблоки"},
        {"Макароны", "Тушонка"},
        {"Капуста", "Курица", "Лаваш", "Помидоры", "Огурцы", "Соус"}};

    final CashierThread[] cashiers = new CashierThread[customers.length];

    for (int i = 0; i < cashiers.length; i++) {
      cashiers[i] = new CashierThread(i, customers[i]);
    }

    final Thread[] threads = new Thread[cashiers.length];

    for (int i = 0; i < cashiers.length; i++) {
      cashiers[i].start();
      threads[i] = cashiers[i];
    }

    for (int i = 0; i < threads.length; i++) {
      try {
        threads[i].join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println(RESET.getColor() + CASHIERING_IS_COMPLETE);
  }
}
