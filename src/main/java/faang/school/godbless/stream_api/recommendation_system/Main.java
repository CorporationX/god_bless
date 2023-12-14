package faang.school.godbless.stream_api.recommendation_system;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<UserProfile> userProfiles =
                List.of(new UserProfile(1, "male", 28, "Almaty", List.of("Спорт кар", "Фильмы", "Аниме")),
                        new UserProfile(2, "female", 25, "Moscow", List.of("Бокс", "Программирование", "Аниме")),
                        new UserProfile(8, "male", 28, "Almaty", List.of("Психология", "Картинг", "Покер", "Спорт кар")),
                        new UserProfile(10, "male", 28, "Almaty", List.of("Психология", "Картинг", "Горы", "Спорт кар")),
                        new UserProfile(9, "male", 28, "Almaty", List.of("Психология", "Бокс", "Покер", "Аниме")),
                        new UserProfile(3, "male", 22, "Astana", List.of("Пианино", "Фильмы", "Игры", "Машины")),
                        new UserProfile(12, "male", 28, "Almaty", List.of("Пианино", "Часы", "Игры", "Машины")),
                        new UserProfile(4, "female", 14, "Almaty", List.of("Книги", "Фантастика", "Путешествие", "Часы")),
                        new UserProfile(5, "male", 28, "Almaty", List.of("Техника", "Машины", "Самолеты", "Спорт кар", "Психология")),
                        new UserProfile(6, "male", 44, "Moscow", List.of("Iphone", "Телевизор", "Компьютер")),
                        new UserProfile(7, "male", 28, "Almaty", List.of("Путешествие", "Фильмы", "Горы")),
                        new UserProfile(11, "female", 28, "Almaty", List.of("Психология", "Машины", "Часы", "Спорт кар")));

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Lenovo legion", "Электроника", 1000, Arrays.asList("Компьютер", "Портативный", "Windows")));
        products.add(new Product(2, "Блендер asus ", "Бытовая техника", 1500, Arrays.asList("Техника", "Миксирование", "Электрический")));
        products.add(new Product(3, "Кроссовки", "Одежда", 2000, Arrays.asList("Бокс", "Спортивные", "Комфортные")));
        products.add(new Product(4, "Iphone 14", "Электроника", 4000, Arrays.asList("Смартфон", "Iphone", "Камера")));
        products.add(new Product(5, "48 законов власти", "Книги", 500, Arrays.asList("Книга", "Психология", "Литература")));
        products.add(new Product(6, "Холодильник samsung", "Бытовая техника", 5000, Arrays.asList("Техника", "Современный", "Экономичный")));
        products.add(new Product(7, "Rolex", "Аксессуары", 10000, Arrays.asList("Часы", "Классические", "Кварцевые")));
        products.add(new Product(8, "Buggati", "Транспорт", 1000000, Arrays.asList("Спорт кар", "Бензин", "Комфорт")));
        products.add(new Product(9, "Harry poter", "Фильмы", 200, Arrays.asList("Фильмы", "Фантастика", "Магия")));
        products.add(new Product(10, "Naruto", "Аниме", 600, Arrays.asList("Аниме", "Фантастика", "Сенэн")));


        List<ProductOrder> productOrders = List.of(
                new ProductOrder(1, 8, LocalDateTime.of(2023, 8, 2, 10, 12)),
                new ProductOrder(2, 3, LocalDateTime.of(2023, 8, 1, 15, 16)),
                new ProductOrder(3, 7, LocalDateTime.of(2023, 7, 31, 12, 18)),
                new ProductOrder(1, 9, LocalDateTime.of(2023, 7, 30, 14, 22)),
                new ProductOrder(9, 5, LocalDateTime.of(2023, 7, 30, 14, 22)),
                new ProductOrder(5, 6, LocalDateTime.of(2023, 7, 29, 16, 10)),
                new ProductOrder(5, 6, LocalDateTime.of(2023, 8, 29, 16, 10)),
                new ProductOrder(5, 8, LocalDateTime.of(2023, 7, 29, 16, 10)),
                new ProductOrder(6, 4, LocalDateTime.of(2023, 7, 28, 18, 5)),
                new ProductOrder(5, 5, LocalDateTime.of(2023, 7, 29, 16, 10)),
                new ProductOrder(7, 9, LocalDateTime.of(2023, 7, 27, 20, 30)),
                new ProductOrder(8, 5, LocalDateTime.of(2023, 7, 26, 22, 45)),
                new ProductOrder(4, 7, LocalDateTime.of(2023, 7, 25, 23, 59)),
                new ProductOrder(10, 5, LocalDateTime.of(2023, 7, 25, 23, 59)),
                new ProductOrder(5, 5, LocalDateTime.of(2023, 1, 29, 16, 10)),
                new ProductOrder(12, 7, LocalDateTime.of(2023, 7, 29, 16, 10)),
                new ProductOrder(8, 8, LocalDateTime.of(2023, 7, 29, 16, 10)),
                new ProductOrder(5, 5, LocalDateTime.of(2023, 5, 29, 16, 10)),
                new ProductOrder(3, 8, LocalDateTime.of(2023, 7, 24, 17, 33)),
                new ProductOrder(1, 10, LocalDateTime.of(2023, 7, 24, 17, 33)));


        RecommendationService recommendationService = new RecommendationService(userProfiles, products, productOrders);
        System.out.println(recommendationService.productInterests(1));
        System.out.println(recommendationService.topPurchasedProducts(1));
        System.out.println(recommendationService.discountCategory(1));


    }
}


class RecommendationService {
    private List<UserProfile> userProfiles;
    private List<Product> products;
    private List<ProductOrder> productOrders;


    public RecommendationService(List<UserProfile> userProfiles, List<Product> products, List<ProductOrder> productOrders) {
        this.userProfiles = userProfiles;
        this.products = products;
        this.productOrders = productOrders;
    }

    public List<Product> productInterests(int userId) {
        return userProfiles.stream().filter(userProfile -> userProfile.getUserId() == userId)
                .findFirst().get().getInterests().stream()
                .flatMap(interest -> products.stream().filter(product -> product.getTags().contains(interest)))
                .collect(Collectors.toList());

    }


    public List<String> topPurchasedProducts(int userId) {

        // стрим id пользователей с одинаковым возрастом, полом и локацией.
        Stream<Integer> usersId = userProfiles
                .stream()
                .filter(userProfile -> userProfile.getUserId() == userId)
                .flatMap(up -> userProfiles.stream()
                        .filter(up1 -> up1.getAge() == up.getAge() &&
                                up1.getGender().equals(up.getGender()) &&
                                up1.getLocation().equals(up.getLocation()) &&
                                up1.getUserId() != userId
                        ))
                .map(userProfile -> userProfile.getUserId());

        // Получаем Map, где ключом является id продукта, а значением количество заказов этого продукта
        Map<Integer, Long> productIdCountMap = usersId.
                flatMap(uId -> productOrders.stream().filter(productOrder -> productOrder.getUserId() == uId))
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting()));


        return productIdCountMap
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().intValue() - e1.getValue().intValue())
                .flatMap(entry -> products.stream().filter(product -> product.getProductId() == entry.getKey())).map(product -> product.getName())
                .toList();

    }


    public String discountCategory(int userId) {
        Integer productId = productOrders.stream().filter(productOrder -> productOrder.getUserId() == userId)
                .collect(Collectors.groupingBy(ProductOrder::getProductId, Collectors.counting())).entrySet().stream().max(Comparator.comparingInt(e -> e.getValue().intValue())).get().getKey();
        return products.stream().filter(product -> product.getProductId() == productId).map(product -> product.getCategory()).findFirst().orElse("null");
    }


}


@Data
@AllArgsConstructor
class UserProfile {
    private int userId;
    private String gender;
    private int age;
    private String location;
    private List<String> interests;


}


@Data
@AllArgsConstructor
class Product {
    private int productId;
    private String name;
    private String category;
    private int price;
    private List<String> tags;

}

@Data
@AllArgsConstructor
class ProductOrder {
    private int userId;
    private int productId;
    private LocalDateTime orderDate;
}

