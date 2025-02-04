package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            Integer key = user.getAge();
            if (!userGroups.containsKey(key)) {
                userGroups.put(key, new ArrayList<>());
            }
            userGroups.get(key).add(user);
        }
        return userGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(workplace, user.workplace) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
