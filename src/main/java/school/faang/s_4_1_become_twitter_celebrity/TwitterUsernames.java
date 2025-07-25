package school.faang.s_4_1_become_twitter_celebrity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwitterUsernames {
    public static final Map<String, Integer> usernames = new HashMap<>();

    public static String addUsername(String username) {
        Scanner scanner = new Scanner(System.in);
        while (usernames.containsKey(username)) {
            System.out.println("This is already a user with this name, give one more: ");
            username = scanner.nextLine();
        }
        usernames.put(username, 1);
        return username;
    }
}
