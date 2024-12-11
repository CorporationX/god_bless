package school.faang.sprint_1.task_43793;

import static school.faang.sprint_1.task_43793.UserValidator.validate;
import static school.faang.sprint_1.task_43793.UserValidator.validateAddress;
import static school.faang.sprint_1.task_43793.UserValidator.validateAge;
import static school.faang.sprint_1.task_43793.UserValidator.validateJob;
import static school.faang.sprint_1.task_43793.UserValidator.validateName;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        try {
            validate(name, age, job, address);
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
            System.out.println("User created successfully: " + this);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to create user: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "User{Name = " + name + ", Age = " + age + ", Job = " + job + ", Address = " + address + "}";
    }

    public void setName(String name) {
        try {
            validateName(name);
            this.name = name;
            System.out.println("Name change successfully: " + this);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to change name: " + e.getMessage());
        }
    }

    public void setAge(int age) {
        try {
            validateAge(age);
            this.age = age;
            System.out.println("Age change successfully: " + this);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to change age: " + e.getMessage());
        }
    }

    public void setJob(String job) {
        try {
            validateJob(job);
            this.job = job;
            System.out.println("Job change successfully: " + this);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to change workplace: " + e.getMessage());
        }
    }

    public void setAddress(String address) {
        try {
            validateAddress(address);
            this.address = address;
            System.out.println("Address change successfully: " + this);
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to change address: " + e.getMessage());
        }
    }
}
