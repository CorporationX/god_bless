package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    private static List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String workPlace;
    private String address;

    public User(String name, Integer age, String workPlace, String address) {
        if(name.isBlank()) {
            throw new IllegalArgumentException("Invalid username");
        }
        if(age < 18) {
            throw new IllegalArgumentException("Invalid age, must be over 18");
        }
        if(!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Not found workPlace");
        }
        if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Not found address");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
