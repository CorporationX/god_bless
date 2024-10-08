package school.faang.collectionusers;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Marat", 21, new HashSet<>(Arrays.asList("бегать", "прыгать")));
        User user2 = new User(1, "Andrey", 21, new HashSet<>(Arrays.asList("плавать", "отдыхать")));
        User user3 = new User(1, "Loxa", 21, new HashSet<>(Arrays.asList("читать", "футбол")));
        User user4 = new User(1, "Rashit", 21, new HashSet<>(Arrays.asList("музыка", "танец")));

        List<User> users = Arrays.asList(user1, user2, user3, user4);
        Set<String> hobbies = new HashSet<>(Arrays.asList("читать", "танец","музыка"));
        Map<User, String> result = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " хобби " + entry.getValue());
        }
    }
}
