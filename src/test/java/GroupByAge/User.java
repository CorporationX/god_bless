package GroupByAge;
import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class User {
    private String name;
    private int age;
    private String work;
    private String adress;

    public User(String name, int age, String work, String adress) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user : users) {
            map.computeIfAbsent(user.getAge(),key ->new ArrayList<>()).add(user);
        }
        return map;
    }

}
