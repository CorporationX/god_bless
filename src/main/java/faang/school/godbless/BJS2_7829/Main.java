package faang.school.godbless.BJS2_7829;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Vasya", 18, "Google", "London"));
        users.add(new User("Vasya", 18, "Uber", "New York"));
        users.add(new User("Vasya", 18, "Amazon", "Amsterdam"));
        /*users.add(new User("Vasya", 17, "Google", "London"));
        users.add(new User("Vasya", 18, "WorkAddressVasya", "London"));
        users.add(new User("Vasya", 18, "Google", "AddressVasya"));
        users.add(new User("", 18, "Google", "London"));*/
        users.forEach(System.out::println);

    }
}
