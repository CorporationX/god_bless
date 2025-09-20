package school.faang;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter

public class User {
    private String name;
    private int age;
    private String address;
    private String job;

    public static final Set<String> VALID_JOBS=Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES=Set.of("London", "New York", "Amsterdam");


    public User(String name, int age, String address, String job) {
        this.name = name;
        this.age = age;
        if (VALID_ADDRESSES.contains(address)){
            this.address = address;
        }else{
            System.out.println("Error: address");
        }
        if (VALID_JOBS.contains(job)){
            this.job = job;
        }else{
            System.out.println("Error: job");
        }
    }
}
