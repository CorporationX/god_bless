package faang.school.godbless.usersRegistration;

import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google","Uber","Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London","New York","Amsterdam");
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        if (name.isEmpty()) throw new IllegalArgumentException();
        if (age<18) throw new IllegalArgumentException();
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException();
        if (!VALID_JOBS.contains(work)) throw new IllegalArgumentException();
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }
}
