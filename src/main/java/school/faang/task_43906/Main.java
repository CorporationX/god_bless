package school.faang.task_43906;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(10);

        users.add(new User("Алексей Смирнов", 29, "IT-компания", "Москва, ул. Ленина, 10"));
        users.add(new User("Мария Иванова", 32, "Магазин одежды", "Санкт-Петербург, пр. Невский, 25"));
        users.add(new User("Дмитрий Кузнецов", 41, "Строительная компания", "Екатеринбург, ул. Мира, 15"));
        users.add(new User("Ольга Петрова", 30, "Банк", "Казань, ул. Баумана, 5"));
        users.add(new User("Сергей Васильев", 29, "Университет", "Новосибирск, ул. Красный проспект, 50"));
        users.add(new User("Елена Сидорова", 30, "Клиника", "Волгоград, ул. Советская, 12"));
        users.add(new User("Игорь Федоров", 32, "Ресторан", "Ростов-на-Дону, ул. Пушкинская, 8"));
        users.add(new User("Анна Николаева", 29, "Кинотеатр", "Калуга, ул. Ленина, 20"));
        users.add(new User("Артем Григорьев", 29, "Фрилансер", "Уфа, ул. Карла Маркса, 3"));
        users.add(new User("Наталья Борисова", 30, "Маркетинговое агентство", "Краснодар, ул. Красная, 14"));

        Map<Integer, List<User>> usersMap = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : usersMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
