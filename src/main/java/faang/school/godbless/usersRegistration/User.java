package faang.school.godbless.usersRegistration;

import java.util.Set;

public class User {
    public static final int ADULT_AGE = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google","Uber","Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London","New York","Amsterdam");
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Field name should not be empty!");
        }
        if (age<ADULT_AGE){
            throw new IllegalArgumentException("Age should be more or equal 18!");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Wrong field address!");
        }
        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Wrong field work!");
        }
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }
}
