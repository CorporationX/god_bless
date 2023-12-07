package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(int age, String name, String workplace, String address){
        this.age=age;
        this.name=name;
        this.workplace=workplace;
        this.address=address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listOfUsers){
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : listOfUsers) {
            int key = user.getAge();
            List<User> value = result.getOrDefault(key,new ArrayList<>());
            value.add(user);
            result.put(key, value);
        }
        for (Map.Entry<Integer, List<User>> asd : result.entrySet()) {
            System.out.println(asd.getKey()+": "+asd.getValue());
        }
        return result;
    }
    public String getAddress() {
        return address;
    }

    public String getWorkplace() {
        return workplace;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return getName();
    }
}
