package UserRegistration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String work;
    private String adress;
    private final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set <String> VALID_ADRESS = new HashSet<>(Arrays.asList("London", "New-York", "Amsterdam"));


    public User(String name, int age, String work, String adress) {
        if ( !name.isEmpty() && age >= 18 && VALID_JOBS.contains(work) && VALID_ADRESS.contains(adress)) {
            this.name = name;
            this.age = age;
            this.work = work;
            this.adress = adress;
        }else  {
            throw new IllegalArgumentException("Incorrect data");
        }
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge());
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}


