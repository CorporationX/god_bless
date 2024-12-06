package school.faang.task_43729;

import java.util.Set;

public class User {

    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void addValidJob(String job) {
        VALID_JOBS.add(job);
    }

    public static void addValidAddress(String address) {
        VALID_ADDRESSES.add(address);
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String name, int age, String job, String address) {

        checkValidity(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void checkValidity(String name, int age, String job, String address) throws IllegalArgumentException {

        if (name.isEmpty() || age < 18 || !VALID_ADDRESSES.contains(address) || !VALID_JOBS.contains(job)

        ) {
            throw new IllegalArgumentException("Arguments failed validation when created");
        }
    }
}