package school.faang.bjs44019;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();
        users.add(new User("Vitali", 26, "Facebook", "Sovetskaya 29"));
        users.add(new User("Anna", 30, "Google", "Lenina 10"));
        users.add(new User("Ivan", 26, "Microsoft", "Pushkina 15"));
        users.add(new User("Olga", 28, "Amazon", "Gorkogo 5"));
        users.add(new User("Sergey", 30, "Apple", "Kirova 20"));
        users.add(new User("Elena", 27, "Tesla", "Mira 8"));
        users.add(new User("Dmitry", 26, "IBM", "Frunze 12"));
        users.add(new User("Natalia", 29, "Intel", "Zhukova 3"));
        users.add(new User("Alexey", 28, "NVIDIA", "Tolstogo 7"));
        users.add(new User("Maria", 27, "AMD", "Pr. Nezavisimosti 1"));

        var ageGroups = User.groupUsers(users);
        for (int age : ageGroups.keySet()) {
            String result = ageGroups.get(age).stream()
                            .map(User::toString)
                            .reduce((user1, user2) -> user1 + "\n" + user2)
                            .orElse("");
            System.out.println(age + ": \n" + result + "\n");
        }
    }
}
