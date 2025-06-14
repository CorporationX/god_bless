import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    // Поля класса с private модификатором
    private String name;
    private int age;
    private String workplace;
    private String address;

    // Конструктор для создания объектов User
    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    // Геттеры для доступа к полям
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    // Метод для группировки пользователей по возрасту
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        // Создаем пустую Map для хранения результатов
        Map<Integer, List<User>> ageGroups = new HashMap<>();

        // Проходим по всем пользователям
        for (User user : users) {
            int age = user.getAge();

            // Проверяем, есть ли уже группа для этого возраста
            if (!ageGroups.containsKey(age)) {
                // Если нет - создаем новую группу
                ageGroups.put(age, new ArrayList<>());
            }
            // Добавляем пользователя в соответствующую группу
            ageGroups.get(age).add(user);
        }

        return ageGroups;
    }

    public static void main(String[] args) {
        // Создаем список пользователей
        List<User> users = new ArrayList<>();
        users.add(new User("Витя", 24, "Окко", "Монако"));
        users.add(new User("Саша", 30, "Google", "Санкт-Петербург"));
        users.add(new User("Антон", 28, "Нетфликс", "Казань"));
        users.add(new User("Елена", 30, "Mail.ru", "Новосибирск"));

        Map<Integer, List<User>> groupedUsers = groupUsers(users);

        System.out.println("Пользователи, сгруппированные по возрасту:");
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("\nВозраст " + entry.getKey() + ":");
            for (User user : entry.getValue()) {
                System.out.println("- " + user.getName() +
                                   ", работает в " + user.getWorkplace() +
                                   ", проживает в " + user.getAddress());
            }
        }
    }
}