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
        isUserValid(name, age, workPlace, address  );
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.workPlace = workPlace;

    }
    private void isUserValid( String name, int age, String workPlace, String address){
        if(name==null || name.isBlank() ){
            throw new IllegalArgumentException("User name cannot be empty or null!");
        }
        if(age<18){
            throw new IllegalArgumentException("User age cannot be <18");

        }if( !VALID_JOBS.contains(workPlace ) ){
            throw new IllegalArgumentException("Workplace is not valid company name");

        }if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Address is not valid address name");
        }
    }
}
