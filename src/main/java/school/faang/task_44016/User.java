package school.faang.task_44016;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sameAge = new HashMap<>();
        for (int cycleForMap = 0; cycleForMap < users.size(); cycleForMap++) {
            List<User> userSameAge = new ArrayList<>();
            for (int cycleForList = 0; cycleForList < users.size(); cycleForList++) {
                if (users.get(cycleForList).age == users.get(cycleForMap).age) {
                    userSameAge.add(users.get(cycleForList));
                }
            }
            sameAge.put(users.get(cycleForMap).age, userSameAge);
        }
        return sameAge;
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
        return age == user.age
                && Objects.equals(name, user.name)
                && Objects.equals(workplace, user.workplace)
                && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", AGE=" + age + ", workplace='"
                + workplace + '\'' + ", address='" + address + '\'' + '}';
    }
}

