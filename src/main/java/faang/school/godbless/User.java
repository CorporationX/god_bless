package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    String name;
    Integer age;
    String placeOfWork;
    String address;

    User(String name, Integer age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public String getPlaceOfWork() {
        return placeOfWork;
    }
    public String getAddress() {
        return address;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
        }
    }