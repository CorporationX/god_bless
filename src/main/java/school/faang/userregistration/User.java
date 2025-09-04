package school.faang.userregistration;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String workplace, String address) {


        this.name = name;
        this.age = age;
        this.job = workplace;
        this.address = address;
    }

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


}
