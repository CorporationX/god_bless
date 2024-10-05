package school.faang;

import java.util.Set;

public class User {

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) throws IllegalArgumentException {
        System.out.println();
        try {
            if (validation(name, age, placeWork, address)) {
                this.name = name;
                this.age = age;
                this.placeWork = placeWork;
                this.address = address;

                System.out.println("User created successfully");
                Main.created = true;
            }
            else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Not valid, check the following:\n" +
                    "- Name should not be empty\n" +
                    "- Age must above 18\n" +
                    "- Job: Google, Uber or Amazon\n" +
                    "- Address London, New York or Amsterdam\n");
        }
    }

    private boolean validation(String name, int age, String placeWork, String address) {
        return name != null && name.length() > 1 && age >= 18 && VALID_JOBS.contains(placeWork) && VALID_ADDRESSES.contains(address);
    }
}