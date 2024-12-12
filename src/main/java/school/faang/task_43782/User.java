package school.faang.task_43782;

import java.util.Set;

public class User {
    private static final int AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amstersdam");

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Enter your name, please!");
        }
        if (!(VALID_JOBS.contains(workplace))) {
            throw new IllegalArgumentException("You should work in FAANG!");
        }
        if (!(VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Sorry((( You can't live outside London, Amsterdam or NewYork");
        }
        if (age < AGE) {
            throw new IllegalArgumentException("Wait 18th HB and comeback later");
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
