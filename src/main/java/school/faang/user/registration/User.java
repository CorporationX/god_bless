package school.faang.user.registration;

import java.util.Arrays;

public class User {
    public static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    public static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if(name.equals("")){
            throw new IllegalArgumentException("Enter your name correctly");
        }
        if(age < 18){
            throw new IllegalArgumentException("You are too little");
        }
        if(!Arrays.asList(VALID_JOBS).contains(job)){
            throw new IllegalArgumentException("You are in a wrong job");
        }
        if(!Arrays.asList(VALID_ADDRESSES).contains(address)){
            throw new IllegalArgumentException("You are in a wrong address");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
