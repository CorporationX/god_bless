package school.faang.task_56308;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String adress;

    public User(String name, int age, String workplace, String adress) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.adress = adress;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAdress() {
        return adress;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getAge));
        return map;
    }
}
