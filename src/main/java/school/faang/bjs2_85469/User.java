package school.faang.bjs2_85469;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Objects;

public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> hobbies;

    private static int counter;

    public User(String name, int age, Set<String> hobbies) {
        this.id = ++counter;
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> someHobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String userHobby : user.getHobbies()) {
                if (someHobbies.contains(userHobby)) {
                    hobbyLovers.put(user, userHobby);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "id[" + id + "]--name[" + name + "]--age[" + age + "]--hobbies" + hobbies;
    }
}
