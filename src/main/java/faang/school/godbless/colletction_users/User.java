package faang.school.godbless.colletction_users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> active;

    public User(int id, String name, int age, Set<String> active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> strings) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {
            for (String str : user.active) {
                if (strings.contains(str)) {
                    map.put(user, str);
                }
            }
        }
        return map;
    }
    //Насчет переопределения методов не знаю вообще ничего пока,просто слышал в видео влада,что всегда это
    // делать надо,поэтому тупо " Alt+Insert "
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && name.equals(user.name) && active.equals(user.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
