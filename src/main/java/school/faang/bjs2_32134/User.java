package school.faang.bjs2_32134;


import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

//1.1 Task
public class User {
    private String name;
    private  int age;
    private String occupation;
    private String address;

    //Construct
    public User(String name, int age, String occupation, String address) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
    }

    //Getters
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAddress() {
        return address;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setOccupation() {
        this.occupation = occupation;
    }

    public void setAddress() {
        this.address = address;
    }

    //1.2 Task
    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> map = new HashMap<>();


        for (User user : users) {
            int age = user.getAge();

            if (!map.containsKey(age)) {
                map.put(age, new ArrayList<>());
            }

            map.get(age).add(user);
        }
        return map;
    }

}
