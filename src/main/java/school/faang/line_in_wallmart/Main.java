package school.faang.line_in_wallmart;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
public class Main {
    private static final int numCashiers = 3;

    public static void main(String[] args) {
        List<List<Item>> allPurchases = getLists();

        CashierThread[] cashiers = new CashierThread[allPurchases.size()];
        Random random = new Random();

        for (int i = 0; i < allPurchases.size(); i++) {
            int cashierId = random.nextInt(numCashiers) + 1;
            cashiers[i] = new CashierThread(cashierId, allPurchases.get(i));
        }
        for (CashierThread cashier : cashiers) {
            cashier.start();
        }

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                log.error("Exception occurred in threads connected to join() method", e);
                e.printStackTrace();
            }
        }
        System.out.println("All the cashiers have finished work.");
    }

    private static List<List<Item>> getLists() {
        Item carrot = new Item("Carrot", 5);
        Item potato = new Item("Potato", 30);
        Item beets = new Item("Beets", 7);
        Item onion = new Item("Onion", 15);
        Item cheese = new Item("Cheese", 40);
        List<Item> purchase1 = new ArrayList<>(Arrays.asList(carrot, potato, beets));
        List<Item> purchase2 = new ArrayList<>(Arrays.asList(potato, beets, onion));
        List<Item> purchase3 = new ArrayList<>(Arrays.asList(cheese, cheese, cheese, cheese));
        List<Item> purchase4 = new ArrayList<>(Arrays.asList(beets, onion, beets));
        return new ArrayList<>(Arrays.asList(purchase1, purchase2, purchase3, purchase4));
    }
}