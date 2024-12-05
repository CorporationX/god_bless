package school.faang.BJS2_43729;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User{

    public static final Set<String> VALID_JOBS = new HashSet<String>();
    public static final Set<String> VALID_ADDRESSES = new HashSet<>();

    private void initDefaultJobAndAddresses() {
        String[] listDefaultJob = new String[]{"Google", "Uber", "Amazon"};
        String[] listDefaultAddresses = new String[]{"London", "New York", "Amsterdam"};

        if (VALID_JOBS.isEmpty()) {
            Collections.addAll(VALID_JOBS, listDefaultJob);
        }
        if (VALID_ADDRESSES.isEmpty()) {
            Collections.addAll(VALID_ADDRESSES, listDefaultAddresses);
        }


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

    public static void addValidJob(String job) {
        VALID_JOBS.add(job);
    }

    public static void addValidAddress(String address) {
        VALID_ADDRESSES.add(address);
    }

    private String name;
    private int age;
    private String job;
    private String address;


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

    public User(String name, int age, String job, String address){


        checkValidity(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;


    }

    private void checkValidity(String name, int age, String job, String address) throws IllegalArgumentException {

        initDefaultJobAndAddresses();
        if (name.isEmpty()
                | age < 18
                | !VALID_ADDRESSES.contains(address)
                | !VALID_JOBS.contains(job)

        ) {
            throw new IllegalArgumentException("Arguments failed validation when created");
        }


    }


}
