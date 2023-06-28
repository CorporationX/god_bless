package faang.school.godbless.WallmartQueue;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        String[][] customers = {{"Apple", "Banana", "Cucumber"},
                {"Coffee", "Milk", "Tea"},
                {"Potato", "Watermelon", "Strawberry"}};
        CashierThread[] cashierThreads = new CashierThread[3];
        for (int i = 0; i < cashierThreads.length; i++) {
            cashierThreads[i] = new CashierThread(i + 1, customers[i]);
        }
        for (CashierThread cashierThread : cashierThreads) {
            cashierThread.start();
            cashierThread.join();
        }
        int overallQuantity = customers.length * customers[0].length;
        int overallPrice = overallQuantity * 300;
        System.out.println("Products quantity: " + overallQuantity + " Products price: " + overallPrice);
    }
}
