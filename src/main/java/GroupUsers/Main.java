package GroupUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        List<User> users = new ArrayList<>(10);
        users.add(new User("Алексей Смирнов", "IT-компания", "Москва, ул. Ленина, 10", 30));
        users.add(new User("Мария Иванова", "Магазин одежды", "Санкт-Петербург, пр. Невский, 25", 32));
        users.add(new User("Дмитрий Кузнецов", "Строительная компания", "Екатеринбург, ул. Мира, 15", 45));
        users.add(new User("Ольга Петрова", "Банк", "Казань, ул. Баумана, 5", 30));
        users.add(new User("Сергей Васильев", "Университет", "Новосибирск, ул. Красный проспект, 50", 29));
        users.add(new User("Елена Сидорова", "Клиника", "Волгоград, ул. Советская, 12", 27));
        users.add(new User("Игорь Федоров", "Ресторан", "Ростов-на-Дону, ул. Пушкинская, 8", 34));
        users.add(new User("Анна Николаева", "Кинотеатр", "Калуга, ул. Ленина, 20", 25));
        users.add(new User("Артем Григорьев", "Фрилансер", "Уфа, ул. Карла Маркса, 3", 29));
        users.add(new User("Наталья Борисова", "Маркетинговое агентство", "Краснодар, ул. Красная, 14", 30));
        for (User user: users)
            System.out.println(user);
    }
}
