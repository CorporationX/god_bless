package school.faang.task_43656;

import java.util.Set;

public class User {
    public static final int AGE_OF_MAJORITY = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("The name is empty");
        } else if (age < AGE_OF_MAJORITY) {
            throw new IllegalArgumentException("Age less " + AGE_OF_MAJORITY);
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("job is not valid");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address is not valid");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
