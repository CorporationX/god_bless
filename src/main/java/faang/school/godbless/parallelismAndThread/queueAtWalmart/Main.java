package faang.school.godbless.parallelismAndThread.queueAtWalmart;

public class Main {
    public static void main(String[] args) {
        Item[][] customers = new Item[][] {{new Item("item1", 5), new Item("item2", 10)},
                {new Item("item3", 8), new Item("item11", 12)},
                {new Item("item4", 2), new Item("item7", 3), new Item("item5", 5)}};

        CashierThread[] cashiers = new CashierThread[customers.length];

        for (int i = 0; i < customers.length; i++) {
            cashiers[i] = new CashierThread(i + 1, customers[i]);
        }

        for (CashierThread cashierThread : cashiers) {
            cashierThread.start();
        }
        
        for (CashierThread cashierThread : cashiers) {
            try {
                cashierThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int totalPrice = 0;
        int totalItems = 0;
        for (CashierThread cashierThread : cashiers) {
            totalPrice += cashierThread.getTotalPrice();
            totalItems += cashierThread.getTotalItems();
        }

        System.out.println("Обработка заказов завершена! Количество товаров: " + totalItems + "; Общая стоимость: " + totalPrice);
    }
}
