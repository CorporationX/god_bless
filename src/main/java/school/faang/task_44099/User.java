package school.faang.task_44099;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private String[] hobbies;

    public User(int id, String name, int age, String[] hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }

    protected static LinkedHashMap<User, String> findHobbyLovers(List<User> userList, Set<String> hobbiesList) {
        LinkedHashMap<User, String> hobbyLovers = new LinkedHashMap<>();
        for (User user : userList) {
            for (String hobbie : user.getHobbies()) {
                if (hobbiesList.contains(hobbie)) {
                    hobbyLovers.put(user, hobbie);
                    break;
                }
            }
        }
        return hobbyLovers;
    }
}