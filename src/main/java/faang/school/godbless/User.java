package faang.school.godbless;

import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Data
public class User {
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private String job;
    @NonNull
    private String address;

    public User(String name, int age, String job, String address){
        validate(name, age);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
    private void validate(String name, int age){
         if(age < 0 || age > 100 || name == null || name.length() < 2) {
             throw new IllegalArgumentException();
         }
    }
}
