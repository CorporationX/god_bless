package school.faang.Bjs2_85628;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public static final Set<String> VALID_JOB = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESS = Set.of("Лондон", "Нью-Йорк", "Амстердам");

    public User(String name, int age, String workPlace, String address) {
        nameValidation(name);
        ageValidation(age);
        workValidation(workPlace);
        addressValidation(address);
    }

    private void nameValidation(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Empty name");
        }
        this.name = name;
    }

    private void ageValidation(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age less of 18");
        }
        this.age = age;
    }

    private void workValidation(String workPlace) {
        if (workPlace == null || !VALID_JOB.contains(workPlace)) {
            throw new IllegalArgumentException("Job incorrect");
        }
        this.workPlace = workPlace;
    }

    private void addressValidation(String address) {
        if (address == null || !VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Address incorrect");
        }
        this.address = address;
    }
}



