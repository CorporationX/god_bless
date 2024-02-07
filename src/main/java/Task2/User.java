package Task2;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber","Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static int AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address){
        if(name.isBlank() || age < AGE || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        }else{
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }
}
