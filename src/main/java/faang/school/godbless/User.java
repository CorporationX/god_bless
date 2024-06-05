package faang.school.godbless;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workplace;
    private String address;


    public User(String name, int age, String workplace, String address) {
        if (validateInputDataByUser(name, age, workplace, address)) throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }


    private boolean validateInputDataByUser(String name, int age, String workplace, String address) {
        return (name.isEmpty() ||
                age < 18 ||
                VALID_JOBS.contains(workplace) ||
                VALID_ADDRESSES.contains(address));
    }

    public static void main(String[] args) {
        User user = new User("test", 17, "test", "test");
    }
}