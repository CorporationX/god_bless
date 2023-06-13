package Registration;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {

    private String name;

    private Integer age;

    private String workPlace;

    private String address;
    
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));

    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, Integer age, String workPlace, String address) {

        if (name.equals("")){
            throw new IllegalArgumentException("Имя не должно быть пустым! ");
        } else {
            this.name = name;
        }

        if (age < 18){
            throw new IllegalArgumentException("Возраст меньше 18! " + age);
        } else {
            this.age = age;
        }

        if (workPlace.contains(VALID_JOBS.toString())){
            this.workPlace = workPlace;
        } else {
            throw new IllegalArgumentException("Место работы не входит в оригинальный состав!");
        }

        if (address.contains(VALID_ADDRESSES.toString())){
            this.address = address;
        } else {
            throw new IllegalArgumentException("Ваш город не входит в оригинальный состав!");
        }

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){

        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users){

            Integer age = user.age;

            if (userGroups.containsKey(age)){
                userGroups.get(age).add(user);
            } else {

                List<User> userList = new ArrayList<>();
                userGroups.put(age, userList);
                userList.add(user);

            }
        }
        return userGroups;
    }
}
