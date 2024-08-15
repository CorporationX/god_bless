package faang.school.godbless.BJS2_19821;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private final Map<User, Set<Query>> queriesByUsers = new HashMap<>();

    private void addNewUser(User user, Set<Query> queries) {
        if (queriesByUsers.containsKey(user)) {
            throw new IllegalArgumentException("This user already exist");
        }
        queriesByUsers.put(user, queries);
    }

    private void addUserQuery(User user, Query query) {
        queriesByUsers.computeIfAbsent(user, userKey -> new TreeSet<>()).add(query);
    }

    private void removeUser(User user) {
        if (!queriesByUsers.containsKey(user)) {
            throw new IllegalArgumentException("This user does not exist");
        }
        queriesByUsers.remove(user);
    }

    private void viewAllUsers() {
        queriesByUsers.forEach((user, queries) -> {
            System.out.println(user);
            queries.forEach(query -> System.out.println("\t" + query));
        });
    }

    private void viewUserHistory(User user) {
        if (!queriesByUsers.containsKey(user)) {
            throw new IllegalArgumentException("This user does not exist");
        }
        for (Map.Entry<User, Set<Query>> entry : queriesByUsers.entrySet()) {
            User targetUser = entry.getKey();
            if (Objects.equals(user, targetUser)) {
                Set<Query> queries = entry.getValue();
                System.out.println("User: " + targetUser.getName());
                queries.forEach(System.out::println);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Main application = new Main();
        User userOne = new User(1L, "Alice");
        Set<Query> userOneQueries = new TreeSet<>();
        userOneQueries.add(new Query(1L, "What is the weather like today?"));
        userOneQueries.add(new Query(2L, "How do I reset my password?"));
        userOneQueries.add(new Query(3L, "What are the best practices for SEO?"));
        userOneQueries.add(new Query(4L, "Can you recommend a good book on Java programming?"));
        userOneQueries.add(new Query(5L, "How to cook a perfect steak?"));
        application.addNewUser(userOne, userOneQueries);
        application.addUserQuery(userOne, new Query(100L, "How to cook a perfect steak quickly?"));

        User userTwo = new User(2L, "Bob");
        Set<Query> userTwoQueries = new TreeSet<>();
        userTwoQueries.add(new Query(6L, "What are the symptoms of the flu?"));
        userTwoQueries.add(new Query(7L, "What time does the movie start?"));
        userTwoQueries.add(new Query(8L, "How do I create a new Git repository?"));
        userTwoQueries.add(new Query(9L, "What is the capital of France?"));
        userTwoQueries.add(new Query(10L, "How can I improve my public speaking skills?"));
        application.addNewUser(userTwo, userTwoQueries);

        User userThree = new User(3L, "Charlie");
        Set<Query> userThreeQueries = new TreeSet<>();
        userThreeQueries.add(new Query(11L, "What is the meaning of life?"));
        userThreeQueries.add(new Query(12L, "How do I make a simple website using HTML and CSS?"));
        userThreeQueries.add(new Query(13L, "What are the benefits of meditation?"));
        userThreeQueries.add(new Query(14L, "Can you explain the theory of relativity?"));
        userThreeQueries.add(new Query(15L, "How to create a budget for a small business?"));
        application.addNewUser(userThree, userThreeQueries);

        application.viewUserHistory(userOne);
        System.out.println();
        application.removeUser(userThree);
        application.viewAllUsers();
    }
}
