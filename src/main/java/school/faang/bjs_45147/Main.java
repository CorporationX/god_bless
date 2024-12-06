package school.faang.bjs_45147;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addItem("Фрукты", "Яблоки");
        store.addItem("Фрукты", "Апельсины");
        store.addItem("Овощи", "Помидоры");
        store.addItem("Напитки", "Сок");
        store.addItem("Молочные продукты", "Йогурт");
        store.addItem("Мясо", "Говядина");
        store.addItem("Кондитерские изделия", "Печенье");
        store.addItem("Крупы", "Рис");
        store.addItem("Специи", "Перец");
        store.addItem("Бытовая химия", "Средство для мытья посуды");
        store.addItem("Косметика", "Шампунь");

        log.info("\nСписок продуктов после добавления:");
        store.printAllItems();

        store.removeItem("Бытовая химия", "Средство для мытья посуды");
        log.info("\nСписок продуктов после добавления:");
        store.printAllItems();

        log.info("\nНайдены продукты:");
        var productsByCategory = store.findItemsByCategory("Фрукты");
        log.info(productsByCategory.toString());

        log.info("\nСписок продуктов по категориям:");
        store.printProductsByCategory(store.groupProductsByCategory(productsByCategory));
    }
}
