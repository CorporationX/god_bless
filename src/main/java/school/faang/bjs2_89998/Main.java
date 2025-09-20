package school.faang.bjs2_89998;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<List<Item>> customers = List.of(
                List.of(new Item("Колбаса", 420), new Item("Хлеб", 79), new Item("Сникерс", 112)),
                List.of(new Item("Сосиски", 320), new Item("Сок яблочный", 159), new Item("Семечки", 156)),
                List.of(new Item("Торт", 720), new Item("Килька", 220), new Item("Дыня", 150)),
                List.of(new Item("Сельдь", 340), new Item("Бананы", 89), new Item("Сервиз", 1619)),
                List.of(new Item("Тетрадь", 49), new Item("Картофель", 39), new Item("Сок томатный", 159)),
                List.of(new Item("Картофель", 39), new Item("Бананы", 89), new Item("Кетчуп", 115)),
                List.of(new Item("Вода", 149), new Item("Кофе", 650), new Item("Картофель", 39)));
        List<CashierThread> cashiers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            CashierThread cashier = new CashierThread(i, customers.get(i));
            cashiers.add(cashier);
        }
        for (CashierThread cashier : cashiers) {
            cashier.start();
        }
        for (CashierThread cashier : cashiers) {
            cashier.join();
        }
        System.out.println();



    }
}
