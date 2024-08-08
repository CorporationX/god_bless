package GroupUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    List<String> VALID_JOBS = new ArrayList<>(Arrays.asList("Google", "Amazon", "Uber"));
    List<String>VALID_ADDRESSES = new ArrayList<>(Arrays.asList("London", "New York", "Amsterdam"));


    public User(String name, int age, String workPlace, String address) throws Exception{
        this.name = name;
        if(name == "" || name == " " || name == "  "){
            throw new IllegalArgumentException();
        }

        this.age = age;
        if(age <18){
            throw new IllegalArgumentException();
        }

        this.workPlace = workPlace;
        if(!VALID_JOBS.contains(workPlace)){
            throw new IllegalArgumentException();
        }
        this.address = address;
        if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        }
    }
    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(workPlace, user.workPlace) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workPlace, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
