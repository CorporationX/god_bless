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
    private final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADRESS = new HashSet<>(Arrays.asList("London", "New-York", "Amsterdam"));
    private final int LEGAL_AGE = 18;

    private String name;
    private int age;
    private String work;
    private String adress;


    public User(String name, int age, String work, String adress) {
        validDate(name, age, work, adress);
        this.name = name;
        this.age = age;
        this.work = work;
        this.adress = adress;
    }

    public void validDate(String name, int age, String work, String adress) {
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Field cannot be empty");
        }
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException(" Must be over 18 years of age");
        }
        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("The work place is not suitable ");
        }
        if (!VALID_ADRESS.contains(adress)) {
            throw new IllegalArgumentException("The adress is not suitable");
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


