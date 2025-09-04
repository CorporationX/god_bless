package school.faang.BJS2_85750;

import java.util.HashSet;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = getJobsSet();
    private static final Set<String> VALID_ADDRESSES = getAddressesSet();

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static Set<String> getJobsSet() {
        Set<String> jobs = new HashSet<>();
        jobs.add("Google");
        jobs.add("Uber");
        jobs.add("Amazon");
        jobs.add("Tesla");
        return jobs;
    }

    private static Set<String> getAddressesSet() {
        Set<String> addresses = new HashSet<>();
        addresses.add("New York");
        addresses.add("Amsterdam");
        addresses.add("LA");
        addresses.add("Chicago");
        return addresses;
    }
}
