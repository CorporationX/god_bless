package faang_school;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Рома","Екатеринбург","Сбер",27));
        users.add(new User("Катя","Москва","Яндекс",25));
        users.add(new User("Денис","Казань","Т-Банк",27));
        users.add(new User("Вика","Лондон","Сбер",23));
        users.add(new User("Соня","Нью-Йорк","Вкусно и точка",28));
        for (Map.Entry<Integer, List<User>> entry : groupUsers(users).entrySet()) {
            if(entry.getKey() == 27) {
                System.out.println(entry.getValue());
            }
        }
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            userGroups.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return userGroups;
    }

    public User(String name, String address, String job, int age) {
        this.name = name;
        this.address = address;
        this.job = job;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
