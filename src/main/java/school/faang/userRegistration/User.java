package school.faang.userRegistration;

import java.util.*;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 18){
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
    }

    public void setJob(String job) {
        if (VALID_JOBS.contains(job)){
            this.job = job;
        } else{
            throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
        }
    }

    public void setAddress(String address) {
        if (VALID_ADDRESSES.contains(address)){
            this.address = address;
        } else {
            throw new IllegalArgumentException("Адрес должен содержaться в наборе VALID_ADDRESSES");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(job, user.job) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, address);
    }


}
