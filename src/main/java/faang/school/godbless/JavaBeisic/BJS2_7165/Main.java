package faang.school.godbless.JavaBeisic.BJS2_7165;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> activities1 = new HashSet<>(Set.of("football", "basketball", "swimming"));
        Set<String> activities2 = new HashSet<>(Set.of("chess", "football", "cycling"));
        Set<String> activities3 = new HashSet<>(Set.of("running", "swimming", "tennis"));
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", 25, activities1));
        users.add(new User(2, "Bob", 30, activities2));
        users.add(new User(3, "Charlie", 35, activities3));
        Set<String> hobbies = new HashSet<>(Set.of("football", "tennis"));
        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("User: " + entry.getKey() + ", Matching Hobby: " + entry.getValue());
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
