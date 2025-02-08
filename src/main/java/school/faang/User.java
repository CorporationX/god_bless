package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor

public final class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static void main(String[] args) {

        User oleg = new User("Oleg", 48, "Jaguar", "London");
        User ivan = new User("Ivan", 45, "Lada", "Moscow");
        User egor = new User("Egor", 26, "Audi", "Berlin");
        User anton = new User("Anton", 31, "Nissan", "Tokyo");
        User alexander = new User("Alexander", 32, "Maserati", "Rome");
        User pavel = new User("Pavel", 35, "Jeep", "Boston");
        User dima = new User("Dima", 35, "Omoda", "Beijing");
        User sergey = new User("Sergey", 35, "Kia", "Seul");

        List<User> users = new ArrayList<>();

        users.add(oleg);
        users.add(ivan);
        users.add(egor);
        users.add(anton);
        users.add(alexander);
        users.add(pavel);
        users.add(dima);
        users.add(sergey);

        groupUsers(users);
    }

    public static void groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUserByAge = new HashMap<>();

        for (User user : users) {
            groupUserByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        for (Map.Entry<Integer, List<User>> entry : groupUserByAge.entrySet()) {

            System.out.println("Age:" + entry.getKey() + " user " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return name + " (age: " + age + ", workplace: " + workplace + ", address: " + address + ")";
    }

}


