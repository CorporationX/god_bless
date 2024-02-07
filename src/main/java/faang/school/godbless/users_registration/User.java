package faang.school.godbless.users_registration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {
    private long id;
    private String name;
    private int age;
    private String workPlace;
    private String address;
    private static final Set<String> VALID_JOBS = new HashSet<>( Arrays.asList( "Google","Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New-York", "Amsterdam"));



    public User(long id, String name, int age, String workPlace, String address) {
        if(name.isEmpty() || age < 18 || !VALID_JOBS.contains(workPlace ) || !VALID_ADDRESSES.contains(address)){
            throw new  IllegalArgumentException("Invalid user data");
        }
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.workPlace = workPlace;

    }
}
