package school.faang.service;

import java.util.*;

public class User {
    private String name;
    private int age;
    private Set<String> hobby;


    public User(String name, int age, Set<String> hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public static HashMap<User, String> findHobbyLovers(List<User> users, Set<String> hobbys) {
        HashMap<User, String> result = new HashMap<>();
        for (User user: users) {
            for (String hobby:hobbys) {
                if (user.getHobby().contains(hobby)) {
                    result.put(user,hobby);
                    break;
                }
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    public void setHobby(Set<String> hobby) {
        this.hobby = hobby;
    }
}
