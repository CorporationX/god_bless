package school.faang;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Getter
@Setter

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(int id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }
    public static Map<String, String> findHobbyLovers(ArrayList<User> users, Set<String> hobbies) {
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<users.size();i++){
            for (String hobby:users.get(i).getHobbies()){
                if (hobbies.contains(hobby)){
                    map.put(users.get(i).getName(), hobby);
                }
            }
        }
        return map;
    }
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
