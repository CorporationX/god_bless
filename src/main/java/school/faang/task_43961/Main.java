package school.faang.task_43961;

import java.util.*;

public class Main {
    private static final int USER_COUNT = 100;
    private static final int HOBBIES_COUNT = 3;
    private static final int LOWER_AGE = 18;
    private static final int OLDER_AGE = 100;
    private static final String[] TEST_NAMES = {
            "Alisa", "Chebarkul", "Cheburek",
            "Alabama", "Matroskin", "Cow"
    };
    private static final String[] TEST_HOBBIES = {
            "Coding", "Games", "Sport", "Hardwork",
            "Nothing", "Chilling", "Idk", "Shopping"
    };

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        Random rand = new Random();
        int id;
        String name;
        int age;
        int n;
        for (id = 0; id < USER_COUNT; id++) {
            name = TEST_NAMES[rand.nextInt(TEST_NAMES.length)];
            age = rand.nextInt(LOWER_AGE, OLDER_AGE);
            Set<String> hobbies = new HashSet<String>();
            for (n = 0; n <= HOBBIES_COUNT; n++) {
                hobbies.add(TEST_HOBBIES[rand.nextInt(TEST_HOBBIES.length)]);
            }
            users.add(new User(id, name, age, hobbies));
        }

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, Set.of(TEST_HOBBIES));
        System.out.println(hobbyLovers);
    }

}
