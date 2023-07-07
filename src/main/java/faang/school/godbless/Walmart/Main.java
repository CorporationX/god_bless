package faang.school.godbless.Walmart;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[][] customers = {{"Apple", "Beer", "Chocolate", "Apple"},
                {"Gum", "Water", "Pancake"},
                {"Water", "Tomato", "Potato"},
                {"Milk", "Cheese", "ToothPaste", "Butter", "Sweets"}};

        Thread[] cashiers = new Thread[customers.length];
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new CashierThread(i, customers[i]);
        }
        for (Thread thread : cashiers) {
            thread.start();
        }
    }
}
