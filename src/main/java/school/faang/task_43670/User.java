package school.faang.task_43670;

public class User {
    private int MIN_AGE = 18;
    private String name;
    private int age;
    private Job job;
    private Address address;

    public User(String name, int age, Job job, Address address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

        if (name.isEmpty()) throw new IllegalArgumentException();
        if (age < MIN_AGE) throw new IllegalArgumentException();
        if (job == null || address == null) throw new IllegalArgumentException();

    }
}
