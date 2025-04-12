package school.faang.BJS2_68058;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(int age, String name, int id, Set<String> hobbies) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.hobbies = hobbies;
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

    public Set<String> getHobbies() {
        return hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {

        Map<User, String> groupedByHobby = new HashMap<>();
        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (hobbies.contains(hobby)) {
                    groupedByHobby.put(user, hobby);
                    break;
                }
            }
        }

        return groupedByHobby;
    }
}
