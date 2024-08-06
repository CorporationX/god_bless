package BJS218427;

import java.util.Set;
import java.lang.IllegalArgumentException;

public class User {
    private String name;
    private int age;
    private String work;
    private String adress;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String work, String adress) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("age < 18");
        }
        if (!VALID_JOBS.contains(work) || work.isEmpty()) {
            throw new IllegalArgumentException("work does not contains in list of valid jobs");
        }
        if (!VALID_ADDRESSES.contains(adress) || adress.isEmpty()) {
            throw new IllegalArgumentException("adress does not contains in list of valid adresses");
        }
        this.name = name;
        this.age = age;
        this.work = work;
        this.adress = adress;

    }

}
