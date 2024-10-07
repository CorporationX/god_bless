package tasks.bjs2_31534;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> hobbies;

    private static int SEQUENCE_ID = 1;

    public User(String name, int age, List<String> hobbies) {
        this.id = SEQUENCE_ID++;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return String.format("Я - %s, мой возраст : %d. Мои хобби : %s", name, age, hobbies.toString());
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> hobbyLovers) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbyLovers.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }
}
