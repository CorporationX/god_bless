package faang.school.godbless;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class User {
    private String name;
    private int age;
    private String userJob;
    private String address;

    public User(String userName, int age, String userJob, String userAddress){
        this.name = userName;
        if(age<0){
            throw new IllegalArgumentException("age cannot be less 0");
        } else this.age = age;
        this.userJob = userJob;
        this.address = userAddress;
    }
    public static Map<Integer,List<User>> groupUsers(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}