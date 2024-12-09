package school.faang.task_43986;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Faker fake = new Faker();

        List<User> users = IntStream.range(0, 10).mapToObj(i -> new User(
                fake.name().name(),
                fake.number().numberBetween(20, 40),
                fake.company().name(),
                fake.address().city()
        )).toList();

        Map<Integer, List<User>> groupedUses = User.groupUsers(users);

        groupedUses.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(user -> System.out.println(" " + user));
        });
    }
}
