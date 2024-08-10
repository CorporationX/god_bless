package faang.school.godbless.BJS2_19821;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static Map<User, List<Query>> queriesByUsers = new HashMap<>();

    private static void checkNewUser(User user) {
        if (queriesByUsers.containsKey(user)) {
            throw new IllegalArgumentException("This user already exists");
        }
    }

    private static void checkExistUser(User user) {
        if (!queriesByUsers.containsKey(user)) {
            throw new IllegalArgumentException("This user does not exist");
        }
    }

    private static void addNewUser(User user, List<Query> queries) {
        checkNewUser(user);
        queriesByUsers.put(user, queries);
    }

    private static void addUserQuery(User user, Query query) {
        queriesByUsers.computeIfAbsent(user, userKey -> new ArrayList<>()).add(query);
    }

    private static void removeUser(User user) {
        checkExistUser(user);
        queriesByUsers.remove(user);
    }

    private static void viewAllUsers() {
        queriesByUsers.forEach((user, queries) -> {
            System.out.println(user);
            queries.forEach(query -> {
                System.out.println("\t" + query);
            });
        });
    }

    private static void viewUserHistory(User user) {
        checkExistUser(user);
        for (Map.Entry<User, List<Query>> entry : queriesByUsers.entrySet()) {
            User targetUser = entry.getKey();
            if (Objects.equals(user, targetUser)) {
                List<Query> queries = entry.getValue();
                queries.sort(Comparator.comparing(Query::getTimestamp));
                Collections.reverse(queries);
                System.out.println("User: " + targetUser.getName());
                queries.forEach(query -> {
                    LocalDateTime timestamp = query.getTimestamp();
                    String dataTime = timestamp.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
                    System.out.println(dataTime + "\t\t" + query.getContent());
                });
                break;
            }
        }
    }

    public static void main(String[] args) {
        User userOne = new User("Alice");
        List<Query> userOneQueries = new ArrayList<>();
        userOneQueries.add(new Query("What is the weather like today?"));
        userOneQueries.add(new Query("How do I reset my password?"));
        userOneQueries.add(new Query("What are the best practices for SEO?"));
        userOneQueries.add(new Query("Can you recommend a good book on Java programming?"));
        userOneQueries.add(new Query("How to cook a perfect steak?"));
        addNewUser(userOne, userOneQueries);

        User userTwo = new User("Bob");
        List<Query> userTwoQueries = new ArrayList<>();
        userTwoQueries.add(new Query("What are the symptoms of the flu?"));
        userTwoQueries.add(new Query("What time does the movie start?"));
        userTwoQueries.add(new Query("How do I create a new Git repository?"));
        userTwoQueries.add(new Query("What is the capital of France?"));
        userTwoQueries.add(new Query("How can I improve my public speaking skills?"));
        addNewUser(userTwo, userTwoQueries);

        User userThree = new User("Charlie");
        List<Query> userThreeQueries = new ArrayList<>();
        userThreeQueries.add(new Query("What is the meaning of life?"));
        userThreeQueries.add(new Query("How do I make a simple website using HTML and CSS?"));
        userThreeQueries.add(new Query("What are the benefits of meditation?"));
        userThreeQueries.add(new Query("Can you explain the theory of relativity?"));
        userThreeQueries.add(new Query("How to create a budget for a small business?"));
        addNewUser(userThree, userThreeQueries);

        viewUserHistory(userThree);
    }
}
