package Java_Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String adress;
    public static final Set<String> VALID_JOBS =  Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String adress) throws IllegalArgumentException{
        if(name.isEmpty()||name == null || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(adress) ){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.adress = adress;
        System.out.println(VALID_JOBS.contains(job));
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
