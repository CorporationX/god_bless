package school.faang.task_58557;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int age;
    private String name;
    private String workPlace;
    private String address;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(int age, String name, String workPlace, String address) {
        this.age = age;
        this.name = name;
        this.workPlace = workPlace;
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, workPlace, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return  false;
        }
        User user = (User) obj;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(address, user.address)
                && Objects.equals(workPlace, user.workPlace);
    }

    @Override
    public String toString() {
        return "name : " + name + ", age : " + age + ", workplace : " + workPlace + ", address : " + address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageUsersMap = new HashMap<>();
        for (User user : users) {
            ageUsersMap.computeIfAbsent(user.age, k -> new ArrayList<User>()).add(user);
        }
        return ageUsersMap;
    }
}
