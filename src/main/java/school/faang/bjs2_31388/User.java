package school.faang.bjs2_31388;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String name;
    private int age;
    private String company;
    private String address;

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        if (users == null || users.isEmpty() ) {
            return null;
        }
        for (User user : users) {
            //если нет в мапе ключа с возрастом добавляем <возраст, список<user>>
            if (!usersByAge.containsKey(user.getAge())) {
                usersByAge.put(user.getAge(), new ArrayList<User>());
            }
            //добавляем юзера
            usersByAge.get(user.getAge()).add(user);
        }
        return usersByAge;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                "}\n";
    }

    public User(String name, int age, String company, String address) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
