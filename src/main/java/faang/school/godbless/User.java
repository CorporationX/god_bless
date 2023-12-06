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

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for(User user: users){
            int key = user.getAge();
            if(!usersMap.containsKey(key)){
                usersMap.put(key, new ArrayList<>());
            }
            usersMap.get(key).add(user);
        }
        for(Map.Entry<Integer, List<User>> entry: usersMap.entrySet()){
            System.out.println("Ключ: " + entry.getKey() + " Значение: " + entry.getValue());
        }
        return usersMap;
    }

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", adress='" + address + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }
}