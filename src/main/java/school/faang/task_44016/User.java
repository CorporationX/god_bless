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
        for (User user : users) {
            List<User> userSameAge = sameAge.get(user.age);
            if (userSameAge == null) {
                userSameAge = new ArrayList<>();
                sameAge.put(user.age, userSameAge);
            }
            userSameAge.add(user);
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

