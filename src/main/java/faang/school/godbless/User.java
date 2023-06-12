package faang.school.godbless;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class User {
    private String userName;
    private int age;
    private String userJob;
    private String userAddress;
    public User(String userName, int age, String userJob, String userAddress){
        this.userName = userName;
        if(age<0){
            throw new IllegalArgumentException("age cannot be less 0");
        } else this.age = age;
        this.userJob = userJob;
        this.userAddress = userAddress;
    }
    public static Map<Integer,List<User>> groupUsers(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
