package faang.school.godbless.UserRegistr;

import lombok.ToString;

import java.util.Set;

@ToString
public class Users {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int NUMBER_CONSTANT = 18;

    public Users(String name, int age, String workPlace, String address) {
        if (!name.isBlank() & age >= NUMBER_CONSTANT & VALID_JOBS.contains(workPlace) & VALID_ADDRESSES.contains(address)){
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.address = address;
        }else
            throw new IllegalArgumentException("ошибка");
    }
}
