package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> hobbies;

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> hobbies) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            List<String> userHobbies = user.getHobbies();
            if (userHobbies!=null){
                for (String hobby : userHobbies) {
                    if (hobbies.contains(hobby)) {
                        map.put(user, hobby);
                        break;
                    }
                }
            }
        }
        return map;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public User(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
