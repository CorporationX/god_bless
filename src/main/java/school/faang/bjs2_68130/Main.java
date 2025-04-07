package school.faang.bjs2_68130;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("John Doe", 25, "TechCorp", "1234 Elm Street, Springfield, IL 62704"),
                new User("Jane Smith", 25, "HealthInc", "5678 Oak Avenue, Metropolis, NY 10001"),
                new User("Alice Johnson", 40, "EduWorld", "9101 Maple Drive, Gotham, NJ 07001"),
                new User("Bob Brown", 35, "FinancePlus", "1213 Pine Lane, Star City, CA 90210"),
                new User("Charlie Davis", 35, "RetailMart", "1415 Cedar Street, Central City, TX 73301")
        );

        Map<Integer, List<User>> groupedByAgeUsers = User.groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedByAgeUsers.entrySet()) {
            log.info("{}", entry);
        }
    }
}
