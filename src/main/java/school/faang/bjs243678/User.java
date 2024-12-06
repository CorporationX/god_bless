package school.faang.bjs243678;

import lombok.Getter;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class User {

    public static final int MIN_AGE = 18;
    public static final List<String> VALID_JOBS = List.of("google", "uber", "amazon");
    public static final List<String> VALID_ADDRESSES = List.of("london", "new york", "amsterdam");

    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {

        validateName();
        validateAge();
        validateJob();
        validateAddress();

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    private void validateName() {
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateAge() {
        if (this.age < MIN_AGE) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
    }

    private void validateJob() {
        if (!VALID_JOBS.contains(workplace.toLowerCase())) {
            StringJoiner joiner = new StringJoiner(" ,");
            VALID_JOBS.forEach(joiner::add);
            throw new IllegalArgumentException("Workplace entered: " + workplace
                    + ", but should be one of the following values: " + joiner);
        }
    }

    private void validateAddress() {
        if (!VALID_ADDRESSES.contains(this.address.toLowerCase())) {
            throw new IllegalArgumentException(String.join(
                    "Address entered: %s, but should be one of the following values: %s%n",
                    this.address, String.join(" ,", VALID_JOBS)));
        }
    }

    private void validateAddress(boolean usingCollection) {
        if (!VALID_ADDRESSES.contains(this.address.toLowerCase())) {
            throw new IllegalArgumentException(String.join(
                    "Address entered: %s, but should be one of the following values: %s%n",
                    this.address, VALID_ADDRESSES.stream().collect(Collectors.joining(" ,"))));
        }
    }
}