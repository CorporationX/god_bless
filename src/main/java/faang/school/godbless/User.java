package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class User {
    private static final List<String> VALID_JOBS = List.of("Google","Uber","Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London","New York","Amsterdam");
    private String name;
    private long age;
    private String workName;
    private String address;

    public User(String name, Long age, String workName, String address) {
        if(name==null||name.isEmpty()){
            throw new IllegalArgumentException("negative value!");
        }else{
            this.name = name;
        }
        if(age<18){
            throw new IllegalArgumentException("negative value!");
        }else{
            this.age = age;
        }
        if (VALID_JOBS.contains(workName)) {
            this.workName = workName;
        }else{
            throw new IllegalArgumentException("negative value!");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        }else{
            throw new IllegalArgumentException("negative value!");
        }
    }
}