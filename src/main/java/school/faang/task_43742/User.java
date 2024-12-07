package school.faang.task_43742;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name ==  null || name.isEmpty()){
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (age < 18){
            throw new IllegalArgumentException("Your age must be over 18");
        }
        if (!VALID_JOBS.contains(job)){
            throw new IllegalArgumentException("Not a valid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Please enter a valid address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

}
