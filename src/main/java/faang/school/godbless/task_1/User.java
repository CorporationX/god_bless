package faang.school.godbless.task_1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
public class User {
    private String name;
    @Getter
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Vasya", 18, "Coorp - x", "Zhukova 28"));
        userList.add(new User("Natasha", 25, "Google", "Vermishenskogo 13"));
        userList.add(new User("Igor", 18, "Uber", "Barburova 22 - A"));
        userList.add(new User("Yevhenii", 13, "FAANG", "Mikatina 2A"));
        userList.add(new User("Matvei", 17, "SCHOOL 23", "Boguna 33/3"));
        userList.add(new User("Ksenia", 18, "Stepik", "Krasnoarmeyska 8"));
        userList.add(new User("Rostislav", 25, "Amazon", "Gorlova 13"));
        userList.add(new User("Nikita", 25, "Amazon", "Paradna 33"));
        userList.add(new User("Nadia", 13, "Apple", "Zhukova 28"));
        System.out.println(groupUsers(userList));
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersByYears = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            int age = users.get(i).getAge();
            if (!usersByYears.containsKey(age)) {
                List<User> userList = new ArrayList<>();
                for (int j = i; j < users.size(); j++) {
                    int secondAge = users.get(j).getAge();
                    if (age == secondAge) {
                        userList.add(users.get(j));
                    }
                }
                usersByYears.put(age, userList);
            }
        }
        return usersByYears;
    }
}
