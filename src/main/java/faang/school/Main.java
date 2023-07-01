package faang.school;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserProfile> users = new ArrayList<>();
        users.add(new UserProfile(1, "MALE", 20, "Москва", List.of("Сноубординг", "Фантастика", "Видеоигры","Спорт","Искусство")));
        users.add(new UserProfile(2, "FEMALE", 25, "Санкт-Петербург", List.of("Туризм", "Живопись")));
        users.add(new UserProfile(3, "MALE", 20, "Москва", List.of("Футбол", "Кино", "Музыка")));

        List<Product> products = new ArrayList<>();
        products.add(new Product(123, "Ботинки для сноуборда", "Спорт", 100.0, List.of("Спорт", "Сноубординг", "Зимний спорт")));
        products.add(new Product(456, "Книга", "Книги", 20.0, List.of("Фантастика", "Литература")));
        products.add(new Product(789, "Игровая консоль", "Электроника", 300.0, List.of("Видеоигры", "Техника")));
        products.add(new Product(111, "Туристический рюкзак", "Спортивные товары", 50.0, List.of("Туризм", "Походы")));
        products.add(new Product(222, "Живописная картина", "Искусство", 200.0, List.of("Живопись", "Картины")));
        products.add(new Product(333, "Футбольный мяч", "Спортивные товары", 30.0, List.of("Спорт", "Футбол")));

        List<ProductOrder> orders = new ArrayList<>();
        orders.add(new ProductOrder(1, 123, LocalDate.now()));
        orders.add(new ProductOrder(2, 456, LocalDate.now()));
        orders.add(new ProductOrder(2, 123, LocalDate.now()));
        orders.add(new ProductOrder(3, 789, LocalDate.now()));
        orders.add(new ProductOrder(3, 123, LocalDate.now()));
        orders.add(new ProductOrder(2, 111, LocalDate.now()));
        orders.add(new ProductOrder(3, 222, LocalDate.now()));
        orders.add(new ProductOrder(3, 333, LocalDate.now()));
        orders.add(new ProductOrder(1, 222, LocalDate.now()));
        orders.add(new ProductOrder(1, 222, LocalDate.now()));

        RecommendationService recommendationService = new RecommendationService(users, products, orders);
        try {
            var c = recommendationService.getPersonalDiscount(1);
            System.out.println(c);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
