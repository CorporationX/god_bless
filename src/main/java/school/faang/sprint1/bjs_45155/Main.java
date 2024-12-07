package school.faang.sprint1.bjs_45155;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Set<Product> products = initializeSet();
    private static Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);

    public static void main(String[] args) {
        // тестирование методов addItem, printAllItems, findItemsByCategory, printProductsByCategory
        addItem("Автомобильные товары", "Зеркало заднего вида");
        printAllItems();
        findItemsByCategory("Автомобильные товары");
        // не совсем понял, в чем должно быть отличие между методами printAllItems и этим
        printProductsByCategory(groupedProducts);

        // тестирование метода removeItem
        removeItem("Автомобильные товары", "Зеркало заднего вида");
        printAllItems();
        findItemsByCategory("Автомобильные товары");
    }

    private static void addItem(String category, String name) {
        products.add(new Product(products.size() - 1, name, category));
        groupedProducts = groupProductsByCategory(products);
    }

    /** вот это наговнокодил так наговнокодил, каждую строчку расписал, чтобы
     * спустя время зайти и понять, что я тут наворотил вообще, желательно без
     * серьезных последствий для мозга)
     * P.S. Ревьюеру здоровья, хотя я думаю он и не такое видел)
     **/
    private static void removeItem(String category, String name) {
        boolean flag = false; // добавил флаг для проверки наличия товара
        int id = 0; // добавил поле id для вытянутого товара
        // если категории не существует - выводим ошибку
        if (!groupedProducts.containsKey(category)) {
            System.out.println("Такая категория не добавлена!");
        } else { // если существует, вытягиваем из мапы по ключу список с товарами и ищем товар в нем
            List<Product> categoryProducts = groupedProducts.get(category);
            // если товар найден - меняем флаг на true и сохраняем id товара
            for (Product product : categoryProducts) {
                if (product.getName().equals(name)) {
                    flag = true;
                    id = product.getId();
                }
            }
            // если true - удаляем, если нет - выводим сообщение об ошибке
            if (flag) {
                products.remove(new Product(id, name, category));
                groupedProducts = groupProductsByCategory(products);
                System.out.println("Товар удален\n");
            } else {
                System.out.println("Такого товара нет\n");
            }
        }
    }

    private static void findItemsByCategory(String category) {
        if (!groupedProducts.containsKey(category)) {
            System.out.println("Такая категория не была добавлена");
        } else {
            List<Product> categoryProducts = groupedProducts.get(category);
            for (Product product : categoryProducts) {
                System.out.println("\nТовары в категории " + category + ": ");
                System.out.println(product.getName() + "\n");
            }
        }
    }

    private static void printAllItems() {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.getName());
            }
            System.out.println("-------------");
        }
    }

    private static Map<String, List<Product>> groupProductsByCategory(Set<Product> products) {
        Map<String, List<Product>> groupedProducts = new HashMap<>();

        for (Product product : products) {
            groupedProducts.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product);
        }

        return groupedProducts;
    }

    private static void printProductsByCategory(Map<String, List<Product>> groupedProducts) {
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Категория: " + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println(product.getName());
            }
            System.out.println("-------------");
        }
    }

    private static Set<Product> initializeSet() {
        Set<Product> products = new HashSet<>();

        String[][] productData = {
                {"0", "Губка для тела", "Гигиена"},
                {"1", "Компьютерная мышь", "Электроника"},
                {"2", "Телефон", "Электроника"},
                {"3", "Кухонный нож", "Бытовые товары"},
                {"4", "Чипсы", "Снэки"}
        };

        for (String[] product : productData) {
            int id = Integer.parseInt(product[0]);
            String name = product[1];
            String category = product[2];

            products.add(new Product(id, name, category));
        }

        return products;
    }
}
