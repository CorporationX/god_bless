package faang.school.godbless.RecommendationSystem;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserProfile> users = getUser();
        List<Product> products = getProducts();
        List<ProductOrder> orders = getProductOrders();
        RecommendationService service = new RecommendationService(users, products, orders);

        System.out.println("getInterestProducts: ");
        List<Product> out1 = service.getInterestProducts(5);
        out1.forEach(out -> System.out.println("----" + out.getName()));

        System.out.println("\ngetFrequentProducts: ");
        List<Product> out2 = service.getFrequentProducts(8);
        out2.forEach(out -> System.out.println("----" + out.getName()));

        System.out.println("\ngetFrequentProducts: ");
        String out3 = service.getPersonalDiscountCategory(2);
        System.out.println(out3);
    }

    private static List<UserProfile> getUser() {
        List<String> interests1 = Arrays.asList("футбол", "кино", "путешествия");
        List<String> interests2 = Arrays.asList("гитара", "программирование", "видеоигры");
        List<String> interests3 = Arrays.asList("кулинария", "литература", "спорт");
        List<String> interests4 = Arrays.asList("плавание", "живопись", "мода");
        List<String> interests5 = Arrays.asList("музыка", "психология", "автомобили");
        List<String> interests6 = Arrays.asList("театр", "путешествия", "фотография");
        List<String> interests7 = Arrays.asList("баскетбол", "география", "искусство");
        List<String> interests8 = Arrays.asList("видеоигры", "путешествия", "история");
        List<String> interests9 = Arrays.asList("пение", "танцы", "экстрим");
        List<String> interests10 = Arrays.asList("волейбол", "мода", "гастрономия");

        UserProfile userProfile1 = new UserProfile(1, Gender.MALE, 25, "Москва", interests1);
        UserProfile userProfile2 = new UserProfile(2, Gender.FEMALE, 30, "Санкт-Петербург", interests2);
        UserProfile userProfile3 = new UserProfile(3, Gender.MALE, 22, "Новосибирск", interests3);
        UserProfile userProfile4 = new UserProfile(4, Gender.FEMALE, 27, "Екатеринбург", interests4);
        UserProfile userProfile5 = new UserProfile(5, Gender.MALE, 29, "Казань", interests5);
        UserProfile userProfile6 = new UserProfile(6, Gender.FEMALE, 26, "Челябинск", interests6);
        UserProfile userProfile7 = new UserProfile(7, Gender.MALE, 24, "Омск", interests7);
        UserProfile userProfile8 = new UserProfile(8, Gender.FEMALE, 26, "Челябинск", interests8);
        UserProfile userProfile9 = new UserProfile(9, Gender.MALE, 31, "Уфа", interests9);
        UserProfile userProfile10 = new UserProfile(10, Gender.FEMALE, 23, "Ростов-на-Дону", interests10);

        return List.of(userProfile1,userProfile2,userProfile3,userProfile4,userProfile5,userProfile6,userProfile7,userProfile8,userProfile9,userProfile10);
    }

    private static List<Product> getProducts() {
        List<String> tags1 = Arrays.asList("футбол", "тренажерный зал", "спортивная экипировка");
        List<String> tags2 = Arrays.asList("музыка", "гитара", "концерты");
        List<String> tags3 = Arrays.asList("кулинария", "рецепты", "поварское искусство");
        List<String> tags4 = Arrays.asList("искусство", "живопись", "художественные материалы");
        List<String> tags5 = Arrays.asList("электроника", "гаджеты", "технологии");
        List<String> tags6 = Arrays.asList("развлечения", "театр", "кинотеатр");
        List<String> tags7 = Arrays.asList("баскетбол", "спорт", "тренировки");
        List<String> tags8 = Arrays.asList("видеоигры", "компьютерные игры", "онлайн-игры");
        List<String> tags9 = Arrays.asList("музыка", "концерты", "музыкальные инструменты");
        List<String> tags10 = Arrays.asList("мода", "одежда", "стиль");

        Product product1 = new Product(1, "Футбольный мяч", "Спорт", 20.0, tags1);
        Product product2 = new Product(2, "Электрогитара", "Музыка", 200.0, tags2);
        Product product3 = new Product(3, "Кулинарная книга", "Кулинария", 15.0, tags3);
        Product product4 = new Product(4, "Набор акриловых красок", "Искусство", 30.0, tags4);
        Product product5 = new Product(5, "Умные часы", "Электроника", 50.0, tags5);
        Product product6 = new Product(6, "Билет в театр", "Развлечения", 40.0, tags6);
        Product product7 = new Product(7, "Мяч для баскетбола", "Спорт", 25.0, tags7);
        Product product8 = new Product(8, "Компьютерная игра", "Игры", 60.0, tags8);
        Product product9 = new Product(9, "Микрофон для концертов", "Музыка", 80.0, tags9);
        Product product10 = new Product(10, "Платье", "Мода", 30.0, tags10);

        return List.of(product1,product2,product3,product4,product5,product6,product7,product8,product9,product10);
    }

    private static List<ProductOrder> getProductOrders() {
        ProductOrder order1 = new ProductOrder(1, 1, LocalDateTime.now());
        ProductOrder order2 = new ProductOrder(2, 2, LocalDateTime.now().minusDays(7));
        ProductOrder order11 = new ProductOrder(2, 8, LocalDateTime.now().minusDays(7));
        ProductOrder order12 = new ProductOrder(2, 8, LocalDateTime.now().minusDays(7));
        ProductOrder order3 = new ProductOrder(3, 3, LocalDateTime.now().minusDays(14));
        ProductOrder order4 = new ProductOrder(4, 4, LocalDateTime.now().minusDays(21));
        ProductOrder order5 = new ProductOrder(5, 5, LocalDateTime.now().minusDays(30));
        ProductOrder order6 = new ProductOrder(6, 6, LocalDateTime.now().minusDays(45));
        ProductOrder order7 = new ProductOrder(7, 7, LocalDateTime.now().minusDays(60));
        ProductOrder order8 = new ProductOrder(8, 8, LocalDateTime.now().minusDays(75));
        ProductOrder order9 = new ProductOrder(9, 9, LocalDateTime.now().minusDays(90));
        ProductOrder order10 = new ProductOrder(10, 10, LocalDateTime.now().minusDays(100));

        return List.of(order1,order2,order3,order4,order5,order6,order7,order8,order9,order10,order11,order12);
    }
}
