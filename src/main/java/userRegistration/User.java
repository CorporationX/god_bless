package userRegistration;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Arrays;

@Getter
@Setter
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }

        if (age > 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }

        if (VALID_JOBS.contains(placeWork)) {
            this.placeWork = placeWork;
        } else {
            throw new IllegalArgumentException();
        }

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        return this.age == user.age && Objects.equals(this.name, user.name)
                && Objects.equals(this.placeWork, user.placeWork) && Objects.equals(this.address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, placeWork, address);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age
                + ", placeWork='" + placeWork + '\''
                + ", address='" + address + '\'' + '}';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> res = new HashMap<>();

        for (User user : users) {

            // Используем computeIfAbsent для получения списка пользователей по возрасту
            List<User> userList = res.computeIfAbsent(user.getAge(), k -> new ArrayList<>());
            // Добавляем текущего пользователя в соответствующий список
            userList.add(user);

        }
        return res;
    }
}
