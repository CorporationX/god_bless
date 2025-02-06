package school.faang;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobby;

    public User(int id, String name, int age, Set<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "User: " +
                "id- " + id +
                ", name- " + name +
                ", age- " + age +
                ", hobby- " + hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(hobby, user.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hobby);
    }

    public static Map<Integer, String> findHobbyLovers(List<User> users, Set<String> hobbySet) {
        Map<Integer, String> findHobby = new LinkedHashMap<>();
        for (User user : users) {
            for (String element : hobbySet) {
                Integer key = user.getId();
                if (!findHobby.containsKey(key) && user.hobby.contains(element)) {
                    findHobby.put(key,element);
                }
            }
        }
        return findHobby;
    }
}
