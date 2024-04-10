package faang.school.godbless.BJS2_5188;
import lombok.*;
import java.util.*;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    private static final HashSet<String> VALID_JOBS = new HashSet<>() {{ //set of
        add("Google");
        add("Uber");
        add("Amazon");
    }};

    private static final HashSet<String> VALID_ADDRESSES = new HashSet<>() {{
        add("London");
        add("New York");
        add("Amsterdam");
    }};

    public User(String name, int age, String job, String address) throws Exception {
        this.name = name;
        this.age = age;
        this.workplace = job;
        this.address = address;
        Validation(name, age, job, address);
    }

    @SneakyThrows
    private void Validation(String name, int age, String workplace, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalAccessException("Invalid fields");
        }
    }
}
