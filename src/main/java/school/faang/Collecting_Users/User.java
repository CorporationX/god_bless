package school.faang.Collecting_Users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private final long id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    public User(long id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> result = new HashMap<>();


        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (activities.contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getHobbies() {
        return hobbies;
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

