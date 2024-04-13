package faang.school.godbless.BJS2_5188;
import lombok.*;
import java.util.*;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;
    private static final int VALID_AGE = 18;

    private static final HashSet<String> VALID_JOBS = new HashSet<>(Set.of("Google","Uber","Amazon"));
    private static final HashSet<String> VALID_ADDRESSES = new HashSet<>(Set.of("London","New York","Amsterdam"));

    public User(String name, int age, String job, String address){
        this.name = name;
        this.age = age;
        this.workplace = job;
        this.address = address;
        validation(name, age, job, address);
    }
    @SneakyThrows
    private void validation(String name, int age, String workplace, String address) {
        if (name.isBlank() || name.isEmpty() || age < VALID_AGE || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid fields");
        }
    }
}
