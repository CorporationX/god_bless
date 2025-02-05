package school.faang.usergrouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for(User user : users){
            if(!groupedUsers.containsKey(user.getAge())){
                groupedUsers.put(user.getAge(), new ArrayList<>());
            }
            groupedUsers.get(user.getAge()).add(user);

        }
        return groupedUsers;
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

    public static void main(String[] args) {
        User user1 = new User("Alex", 21, "Uber", "1st Avenue");
        User user2 = new User("Misha", 22, "Google", "2nd Avenue");
        User user3 = new User("Jenya", 21, "Facebook", "2nd Avenue");
        User user4 = new User("Olya", 23, "Amazon", "3nd Avenue");
        User user5 = new User("Anya", 23, "Uber", "1st Avenue");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        System.out.println(groupUsers(users));
    }
}
