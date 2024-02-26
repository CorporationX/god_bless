package faang.school.godbless.walmartqueue;

public class Main {

    public static void main(String[] args) {
        Product[][] customers = getCustomers();
        CashierThread[] cashiers = new CashierThread[3];
        int totalCount = 0;
        int totalSum = 0;
        for (int i = 0; i < customers.length; i++) {
            Product[] products = new Product[10];
            for (int j = 0; j < customers[i].length; j++) {
                Product product = customers[i][j];
                products[j] = product;
                totalCount++;
                totalSum += product.getPrice();
            }
            cashiers[i] = new CashierThread(i, products);
        }
        startThreads(cashiers);
        waitThreads(cashiers);
        System.out.println(String.format("Total products count: %d", totalCount));
        System.out.println(String.format("Total purchase amount: %d", totalSum));
    }

    private static Product[][] getCustomers() {
        Product[][] customers = new Product[3][10];
        for (int i = 0; i < customers.length; i++) {
            for (int j = 0; j < customers[i].length; j++) {
                customers[i][j] = new Product(String.format("Product %d%d", i, j), i + j);
            }
        }
        return customers;
    }

    private static void startThreads(Thread[] threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void waitThreads(Thread[] threads) {
        for (Thread thread : threads) {
            join(thread);
        }
    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
