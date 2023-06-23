package user_registration;

import java.util.Set;

public class UsersValidator {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private String name;
    private Integer age;
    private String placeOfWork;
    private String address;

    public UsersValidator(String name, Integer age, String placeOfWork, String address){
        validateUser(name, age, placeOfWork, address);
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
    public static void validateUser(String name, Integer age, String placeOfWork, String address){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name should not be empty");
        }
        if(age < MIN_AGE){
            throw new IllegalArgumentException("The age must not be less than 18");
        }
        if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Wrong address");
        }
        if(!VALID_JOBS.contains(placeOfWork)){
            throw new IllegalArgumentException("Wrong place of work");
        }
    }
}
