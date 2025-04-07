package school.faang.user_registration;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    final static Set<String> VALID_JOBS = Set.of("Google", "User", "Amazon");
    final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address){
        if (name!=null && age>=18 && VALID_JOBS.contains(job) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
        else
            throw new IllegalArgumentException("Exception: Illegal argument");
    }
}
