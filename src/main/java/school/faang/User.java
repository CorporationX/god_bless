package school.faang;


import java.util.Objects;

public class User {
    final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};

    public String name;
    public int age;
    public String job;
    public String address;

    public User(String name, int age, String job, String address) {
        if (!userValidate(name, age, job, address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    private boolean userValidate(String name, int age, String job, String address) {
        if (Objects.equals(name, "")) {
            return false;
        }
        if (age < 18) {
            return false;
        }
        if (!listValidate(job, VALID_JOBS)) {
            return false;
        }
        return listValidate(address, VALID_ADDRESSES);
    }

    private boolean listValidate(String job, String[] VALID_VALUES) {
        for (String validJob : VALID_VALUES) {
            if (Objects.equals(job, validJob)) {
                return true;
            }
        }
        return false;
    }
}