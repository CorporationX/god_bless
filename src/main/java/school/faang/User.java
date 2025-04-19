package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(workplace, user.workplace) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public static Map<Integer, List<User>> groupUsers (List<User> listUsers){
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user: listUsers){
            int age = user.getAge();
            List<User> userGroup = userGroups.get(age);
            if (userGroup == null){
                userGroup = new ArrayList<>();
                userGroups.put(age, userGroup);
            }
            userGroup.add(user);
        }
        return userGroups;
    }
}