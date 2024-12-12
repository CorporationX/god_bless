package school.faang.s12task43705;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final Random random = new Random();
        List<User> users = IntStream.range(0, 100)
                .mapToObj(i -> {
                    try {
                        String company = (String) User.VALID_JOBS.toArray()[i % User.VALID_JOBS.size()];
                        String city = (String) User.VALID_ADDRESSES.toArray()[i % User.VALID_ADDRESSES.size()];
                        int age = 18 + random.nextInt(100);

                        return new User("User" + (i + 1), age, company, city);

                    } catch (IllegalArgumentException e) {
                        System.err.println("Error creating user at index " + i + ": " + e.getMessage());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toList();

        users.forEach(System.out::println);
    }
}