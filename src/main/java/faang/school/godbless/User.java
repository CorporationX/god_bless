package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    String name;
    Integer age;
    String placeOfWork;
    String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    User(String name, Integer age, String placeOfWork, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Incorrect data entered");
        }
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