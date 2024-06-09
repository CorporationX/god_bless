package faang.school.godbless.JavaBaisic.BJS2_7165;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> user1Activities = new HashSet<>(Set.of("swimming", "reading"));
        Set<String> user2Activities = new HashSet<>(Set.of("hiking", "gaming"));
        Set<String> user3Activities = new HashSet<>(Set.of("swimming", "gaming"));
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", 25, user1Activities));
        users.add(new User(1, "Bob", 30, user2Activities));
        users.add(new User(1, "Charlie", 22, user3Activities));
        Set<String> hobbies = new HashSet<>(Set.of("reading", "gaming"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("User: " + entry.getKey().getName() + ", Hobby: " + entry.getValue());
        }
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getActivities().contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}



