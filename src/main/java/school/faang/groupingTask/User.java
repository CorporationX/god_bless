package school.faang.groupingTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, String address, String workplace, int age) {
        this.name = name;
        this.address = address;
        this.workplace = workplace;
        this.age = age;
    }

    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>(List.of(
                new User("Frodo Begins", "Shire", "traveler", 50),
                new User("Bilbo Begins", "Shire", "traveler", 111),
                new User("Mister Reviewer", "Russia", "philanthropist", 25),
                new User("Anton Sidorov", "Hogwarts", "student", 25),
                new User("Egor Ivanov", "Narnia ", "merchant", 25)));

        Map<Integer, List<User>> usersMap = groupUsers(usersList);

        for (Map.Entry<Integer, List<User>> entry: usersMap.entrySet()) {
            System.out.println("age of the group = " + entry.getKey());
            System.out.println(entry.getValue() + "\n");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> usersMap = new HashMap<>();

        for(User user : usersList) {
            int age = user.getAge();

            if (usersMap.containsKey(age)) {
                usersMap.get(age).add(user);
            } else {
                usersMap.put(age, new ArrayList<>(List.of(user)));
            }
        }

        return usersMap;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkplace() {
        return workplace;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
