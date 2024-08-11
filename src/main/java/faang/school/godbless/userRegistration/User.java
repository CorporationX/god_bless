package faang.school.godbless.userRegistration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;


@Data
public class User {
    private String name;
    private int age;
    private String address;
    private String placeOfWork;
    private int minAge = 18;
    private int maxAge = 125;
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    public User(@NonNull String name, int age, @NonNull String address, @NonNull String placeOfWork) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (age < minAge || age > maxAge) {
            throw new IllegalArgumentException("age less then " + minAge + " or very much");
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Choose correct place of work");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Choose correct address");
        }
        this.name = name;
        this.age = age;
        this.address = address;
        this.placeOfWork = placeOfWork;

    }

}