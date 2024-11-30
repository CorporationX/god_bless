package faang.school.godbless.groupusers;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class User {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.placeOfWork = placeOfWork;
        this.address = address;
        if(age < 0){
            throw new IllegalArgumentException("Age cant be less then 0");
        }else{
            this.age = age;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
