package faang.school.godbless;

import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
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

    public final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public User(@NonNull String name, @NonNull int age, @NonNull String job, @NonNull String address) {
        validate(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    private void validate(String name, int age, String job, String address){
        if(name.equals("\\s+") || name.length() < 2 || age < 18 || age > 100 ||
                !(VALID_JOBS.contains(job)) || !(VALID_ADDRESSES.contains(address))){
            throw new IllegalArgumentException();
        }
    }
}
