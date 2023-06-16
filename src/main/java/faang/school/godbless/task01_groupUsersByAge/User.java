package faang.school.godbless.task01_groupUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public int getAge() {
        return age;
    }

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Oleg", 17, "homeless", "Arbat 19"));
        users.add(new User("Gleb", 20, "Google", "Kirova 121"));
        users.add(new User("Kirill", 40, "Microsoft", "Mingazheva 32"));
        users.add(new User("Nadya", 20, "SpaceX", "Chirkova 32"));

    }
    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user:users) {
            int age = user.getAge();
            if(!map.containsKey(age)){
                map.put(age, new ArrayList<>());
            }
            map.get(age).add(user);
        }
        return map;
    }
}
