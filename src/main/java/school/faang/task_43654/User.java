package school.faang.task_43654;

import lombok.Data;

@Data
public class User {
    private static final String[] VALID_JOBS = new String[]{"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = new String[]{"London", "New York", "Amsterdam"};

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name cannot be is null");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Аge cannot be less than 18");
        }

        if (!checkValue(job, VALID_JOBS)) {
            throw new IllegalArgumentException("Job not in VALID_JOBS");
        }

        if (!checkValue(address, VALID_ADDRESSES)) {
            throw new IllegalArgumentException("Address not in VALID_ADDRESSES");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public boolean checkValue(String value, String[] values) {
        for (String text : values) {
            if (text.equals(value)) {
                return true;
            }
        }

        return false;
    }
}
