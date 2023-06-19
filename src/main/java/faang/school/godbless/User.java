package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESS = Set.of("London", "New York", "New York");

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty() || age < 18 ||
                !VALID_JOBS.contains(placeOfWork) ||
                !VALID_ADDRESS.contains(address))
                throw new IllegalArgumentException("wrong input");
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
}
