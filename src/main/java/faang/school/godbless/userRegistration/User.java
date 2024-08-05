package faang.school.godbless.userRegistration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;



@Data
public class User {
    private String name;
    private int age;
    private String address;
    private String placeOfWork;

    static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    public User(String name, int age, String address, String placeOfWork) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("name is empty");
        }
        if (age < 18 || age >125){
            throw new IllegalArgumentException("age less then 18 or very much");
        }
        if (!VALID_JOBS.contains(placeOfWork)){
            throw new IllegalArgumentException("Choose correct place of work");
        }
        if (!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Choose correct address");
        }
        this.name = name;
        this.age = age;
        this.address = address;
        this.placeOfWork = placeOfWork;

    }

}