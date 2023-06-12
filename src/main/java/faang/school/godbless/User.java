package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private Jobs job;
    private Addresses address;


    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public User(String name, int age, String job, String address) {
        validate(name,age,job,address);
        this.name = name;
        this.age = age;
        this.job = Jobs.fromString(job);
        this.address = Addresses.fromString(address);
    }

    private void validate(String name, int age, String job, String address) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (age < 18 ){
            throw new IllegalArgumentException("Age can't be less then 18");
        }
        if (!Jobs.contains(job)){
            throw new IllegalArgumentException("Job should be Google, Uber, Amazon");
        }
        if (!Addresses.contains(address)){
            throw new IllegalArgumentException("Address should be London, New York, Amsterdam");
        }
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

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job=" + job +
                ", address=" + address +
                '}';
    }
}
