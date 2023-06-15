package Users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Users(String name, int age, String workplace, String address){
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<Users>> groupUsers(List<Users> usersList) {
        Map<Integer, List<Users>> groupedUser = new HashMap<>();
        for (Users user : usersList) {
            int age = user.getAge();
            if (groupedUser.containsKey(age)) {
                groupedUser.get(age).add(user);
            } else {
                List<Users> usersWithSameAge = new ArrayList<>();
                usersWithSameAge.add(user);
                groupedUser.put(age, usersWithSameAge);
            }
        }
        return groupedUser;
    }
}
