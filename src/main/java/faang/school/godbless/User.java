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
        this.name = name;
        this.age = validateAge(age);
        this.job = job;
        this.address = address;
    }

    public Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
    private int validateAge(int age){
         if(age < 0) throw new IllegalArgumentException();
         if(age > 100) throw new IllegalArgumentException();
         return age;
    }
}
