package school.faang;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    static final Set<String> VALID_JOBS = new HashSet<>();
    static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public static final String MESSAGE_ERROR_NAME = "имя не может быть пустым";
    public static final String MESSAGE_ERROR_AGE = "возраст не может быть меньше 18";
    public static final String MESSAGE_ERROR_WORKING_PLACE = "место работы должно содержаться во множестве";
    public static final String MESSAGE_ERROR_ADDRESS = "адрес должен содержаться во множестве";

    static final int CHECK_AGE = 18;

    private String name;
    private int age;
    private String workingPlace;
    private String address;

    public User(String name, int age, String workingPlace, String address) {
        if(name == null || name.isEmpty())                             throw new IllegalArgumentException(MESSAGE_ERROR_NAME);
        if(age < CHECK_AGE)                                            throw new IllegalArgumentException(MESSAGE_ERROR_AGE);
        if(workingPlace == null || !VALID_JOBS.contains(workingPlace)) throw new IllegalArgumentException(MESSAGE_ERROR_WORKING_PLACE);
        if(address == null || !VALID_ADDRESSES.contains(address))      throw new IllegalArgumentException(MESSAGE_ERROR_ADDRESS);

        this.name = name;
        this.age = age;
        this.workingPlace = workingPlace;
        this.address = address;
    }
}