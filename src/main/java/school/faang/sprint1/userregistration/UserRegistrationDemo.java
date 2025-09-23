package school.faang.sprint1.userregistration;

import java.util.List;
import java.util.stream.Stream;

public class UserRegistrationDemo {

    public static void main(String[] args) {

        getUserData()
            .forEach(u -> {
                try {
                    User user = new User(
                        u.get(0).toString(),
                        (int) u.get(1),
                        u.get(2).toString(),
                        u.get(3).toString());
                    System.out.println(user);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            });

    }

    private static Stream<List<Object>> getUserData() {
        return Stream.of(
            List.of("User1", 18, "Google", "London"),
            List.of("", 200, "Uber", "New York"),
            List.of("User3", 2, "Uber", "New York"),
            List.of("User4", 33, "Meta", "New York"),
            List.of("User5", 67, "Uber", "Alaska")
        );
    }


}
