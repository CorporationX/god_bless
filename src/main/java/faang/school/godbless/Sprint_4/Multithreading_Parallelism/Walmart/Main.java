package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Walmart;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Item>> customers = new ArrayList<>();
        List<CashierThread>  cashiers = new ArrayList<>();

        List<Item> items1 = List.of(new Item("Bread", 30), new Item("Water", 36), new Item("Vodka", 666));
        List<Item> items2 = List.of(new Item("Chocolate", 97), new Item("Juice", 150), new Item("Beer", 81));
        List<Item> items3 = List.of(new Item("Beer", 76), new Item("Wotar", 30), new Item("Vodka", 200));
        List<Item> items4 = List.of(new Item("Apples", 168), new Item("Beer", 97), new Item("Sprite", 85));
        customers.add(items1);
        customers.add(items2);
        customers.add(items3);
        customers.add(items4);

        for(int i = 0; i < customers.size(); ++i) {
            cashiers.add(new CashierThread(i, customers.get(i)));
            cashiers.get(i).start();
        }
    }
}
