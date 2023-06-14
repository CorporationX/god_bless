package task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        groupedUsers.put(42, new ArrayList<>());
        for (User user : users) {
            int age = user.getAge();
            if (groupedUsers.containsKey(age)) {
                //List<User> foundUsers = groupedUsers.get(age);
                groupedUsers.get(age).add(user);
                //foundUsers.add(user);
                //groupedUsers.put(age, foundUsers);
            } else {
                groupedUsers.put(age, List.of(user));
                //List<User> userList = new ArrayList<>();
                //userList.add(user);
               //groupedUsers.put(age, userList);
            }
        }
        return groupedUsers;
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

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user = new User("Aleksey", 42, "","");
        User user1 = new User("Petr", 42, "","");
       /* user.setName("Aleksey");
        user.setAge(42);*/
        userList.add(user);
        userList.add(user1);

        Map<Integer, List<User>> map = groupUsers(userList);

        System.out.println(map.get(42).get(0).getName());
        System.out.println(map.get(42).get(1).getName());
    }

}



