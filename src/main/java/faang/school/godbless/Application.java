package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        int[][] customers = {{5, 7, 3, 2}, {1, 2, 3}, {6, 5, 2}, {10, 2, 1, 3, 5}};
        for (int i = 0; i < customers.length; i++) {
            int[] items = new int[customers[i].length];
            for (int j = 0; j < customers[i].length; j++) {
                items[j] = customers[i][j];
            }
            CashierThread cashierThread = new CashierThread(i, items);
            cashierThread.start();
        }
    }
}
