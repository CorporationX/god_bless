package faang.school.godbless.Task18483;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private String name;
    private int age;
    private String workOfPlace;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "User", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workOfPlace, String address) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if(age < 18){
            throw new IllegalArgumentException("Age cannot be less than 18");
        }

        if(!VALID_JOBS.contains(workOfPlace)){
            throw new IllegalArgumentException("Work Of Place is not valid: " + workOfPlace);
        }

        if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Address is not valid: " + address);
        }

        this.name = name;
        this.age = age;
        this.workOfPlace = workOfPlace;
        this.address = address;
    }
}
