package school.faang.bjs2_31388;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        if (users == null || users.isEmpty() ) {
            return null;
        }
        for (User user : users) {
            //если нет в мапе ключа с возрастом добавляем <возраст, список<user>>
            usersByAge.putIfAbsent(user.getAge(), new ArrayList<>());

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




}
