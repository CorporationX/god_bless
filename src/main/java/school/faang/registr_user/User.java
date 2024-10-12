package school.faang.registr_user;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_START = 18;

    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        try {
            if (name == null || name.isEmpty() || name.isBlank()) {
                throw new IllegalArgumentException("ERROR: not valid name " + name);
            } else if (age < AGE_START) {
                throw new IllegalArgumentException("ERROR: not valid age " + age);
            } else if (placeWork == null || placeWork.isEmpty() || placeWork.isBlank() || !VALID_JOBS.contains(placeWork)) {
                throw new IllegalArgumentException("ERROR: not valid place of work" + placeWork);
            } else if (address == null || address.isEmpty() || address.isBlank() || !VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("ERROR: not valid address" + address);
            }
            this.name = name;
            this.age = age;
            this.placeWork = placeWork;
            this.address = address;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nYour params should follow the rules:\n" +
                    "- Name not to be empty\n" +
                    "- Age must be above 18\n" +
                    "- Work on Google, Uber or Amazon\n" +
                    "- Address London, New York or Amsterdam\n");
        }
    }
}
