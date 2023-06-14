package faang.school.godbless.user_collection;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobby;

    public User(int id, String name, int age, LinkedHashSet<String> hobby) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.hobby = new LinkedHashSet<>(hobby);
    }

    public static Map<User, String> findHobbyLovers(Set<User> userSet, Set<String> hobbySet) {
        Map<User, String> resutlMap = new HashMap<>();
        for (User user : userSet) {
            Set<String> matchingHobby = new LinkedHashSet<>(hobbySet);
            matchingHobby.retainAll(user.hobby);
            if (!matchingHobby.isEmpty()) {
                resutlMap.put(user, matchingHobby.iterator().next());
            }
        }
        return resutlMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(hobby, user.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, hobby);
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                "} \n";
    }
}

