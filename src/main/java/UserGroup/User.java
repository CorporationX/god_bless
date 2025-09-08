package UserGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    @SuppressWarnings("checkstyle:MethodParamPad")
    public User (String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

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

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, workplace='%s', address='%s'}",
                name, age, workplace, address);
    }
    //Группировка по возрасту
    @SuppressWarnings("checkstyle:EmptyLineSeparator")
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            return Collections.emptyMap();
        }
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Иван", 30, "Компания А", "Москва"),
                new User("Гриша", 25, "Компания Б", "Санкт-Петербург"),
                new User("Пётр", 30, "Компания В", "Казань"),
                new User("Настя", 25, "Компания Г", "Новосибирск"),
                new User("Маша", 40, "Компания Д", "Сочи")
        );

        Map<Integer, List<User>> grouped = User.groupUsers(users);

        grouped.forEach((age, list) -> {
            System.out.println("Возраст " + age + ":");
            list.forEach(user -> System.out.println("  " + user));
        });
    }
}