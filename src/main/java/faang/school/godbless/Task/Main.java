package faang.school.godbless.Task;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Arrays;


public class Main {
    public static void main(String[] args){

        Set<String> hobby = new HashSet<>(Arrays.asList("reading", "dancing"));
        Set<String> hobby1 = new HashSet<>(Arrays.asList("dancing", "coding"));
        Set<String> hobby2 = new HashSet<>(Arrays.asList("coding", "reading"));

        User user1 = new User( "Alice", 25, hobby);
        User user2 = new User( "Bob", 30, hobby1);
        User user3 = new User("Charlie", 22, hobby2);

        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("reading", "coding", "dancing"));

        Map<User, String> findUser = User.findUser(users, hobbies);
        for (Map.Entry<User, String> entry : findUser.entrySet()) {
            System.out.println(entry.getKey() + " loves " + entry.getValue());
        }
    }
}
