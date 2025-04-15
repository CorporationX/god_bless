package school.faang.BJS2_68058;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(int id, String name, int age, Set<String> hobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
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
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(hobbies, user.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, hobbies);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> groupedByHobby = new HashMap<>();

        for (User user : users) {
            for (String hobby : user.getHobbies()) {
                if (groupedByHobby.containsKey(hobby)) {
                    groupedByHobby.put(user, hobby);
                }
            }
        }
        return groupedByHobby;
    }
}
