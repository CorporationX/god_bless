package faang.school.godbless;

import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public final static Set<String> VALID_JOBS = Stream.of("Google", "Uber", "Amazon")
            .collect(Collectors.toSet());
    public final static Set<String> VALID_ADDRESSES = Stream.of("London", "New York", "Amsterdam")
            .collect(Collectors.toSet());

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public User(@NonNull String name, @NonNull int age, @NonNull String job, @NonNull String address) {
        this.name = name;
        this.age = validateAge(age);
        this.job = validateJob(job);
        this.address = validateAddress(address);
    }
    private int validateAge(int age){
        if(age < 18) throw new IllegalArgumentException();
        else return age;
    }
    private String validateJob(String job){
        if(!(VALID_JOBS.contains(job))) throw new IllegalArgumentException();
        else return job;
    }
    private String validateAddress(String address){
        if(!(VALID_ADDRESSES.contains(address))) throw new IllegalArgumentException();
        else return address;
    }
}
