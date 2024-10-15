package the_queue_at_walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    
    /**
     * Runs the simulation. Creates a few customers with items and creates a number of cashiers equal to the number of customers.
     * Each customer is given to a cashier, and the cashiers are started.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        List<List<Items>> customers = List.of(
                List.of(new Items("Coke", 1, 20), new Items("Tomatos", 5, 30)),
                List.of(new Items("Lays", 2, 10), new Items("Juice", 2, 100), new Items("Potato", 10, 5))
        );

        List<CashierThread> cashiers = new ArrayList<>();

        customers.forEach(customer -> cashiers.add(new CashierThread(random.nextInt(10), customer)));

        cashiers.forEach(Thread::start);
    }
}
