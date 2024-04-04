package faang.school.godbless.module.core.group;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    
    private String name;
    private int age;
    private String job;
    private String address;
    
    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException(String.format("место работы должно содержаться во множестве %s",
                                                             String.join(",", VALID_JOBS)));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException(String.format("место работы должно содержаться во множестве %s",
                                                             String.join(",", VALID_JOBS)));
        }
        
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
    
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
