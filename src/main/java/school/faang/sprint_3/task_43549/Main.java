package school.faang.sprint_3.task_43549;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Item>> customers = new ArrayList<>();

        customers.add(new ArrayList<>(List.of(
                new Item("Молоко", 10),
                new Item("Хлеб", 6)
        )));
        customers.add(new ArrayList<>(List.of(
                new Item("Эклеры", 100),
                new Item("Кофе", 60),
                new Item("Ватные диски", 20)
        )));
        customers.add(new ArrayList<>(List.of(
                new Item("Хурма", 40),
                new Item("Мандарины", 25)
        )));
        customers.add(new ArrayList<>(List.of(
                new Item("Торт", 110),
                new Item("Чай", 50),
                new Item("Сливки", 70)
        )));

        List<CashierThread> cashiers = new ArrayList<>();
        CashierThread thread;

        for (List<Item> cart : customers) {
            thread = new CashierThread(cart);
            cashiers.add(thread);
        }

        cashiers.forEach(Thread::start);

        for (CashierThread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван во время ожидания");
            }
        }

        System.out.println("Все товары обработаны!");
    }
}
