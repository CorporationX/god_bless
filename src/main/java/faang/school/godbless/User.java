package faang.school.godbless;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
@Data
public class User {
    private String name;
    private int age;
    private String workAddress;
    private String address;
    public static final Set<String> VALID_JOBS=new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES=new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public User(String name, int age, String workAddress, String address) {
        if(name!=null && !name.isBlank() && age>=18 && VALID_JOBS.contains(workAddress) && VALID_ADDRESSES.contains(address)){
            this.name = name;
            this.age = age;
            this.workAddress = workAddress;
            this.address = address;
        } else throw new IllegalArgumentException("Ошибка заполнения полей :)");
    }
}

