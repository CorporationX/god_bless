package groupUsers;

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
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
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
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", placeWork='" + placeWork + '\'' + ", address='" + address + '\'' + '}';
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
