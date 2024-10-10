package tasks.bjs2_31534;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> hobbies;

    public String getInformation() {
        return String.format("Я - %s, мой возраст : %d. Мои хобби : %s", name, age, hobbies.toString());
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
