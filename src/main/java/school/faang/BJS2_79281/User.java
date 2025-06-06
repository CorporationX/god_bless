package school.faang.BJS2_79281;

import java.util.List;

public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        StringBuilder exceptionMassage = createExceptionMassage(name, age, job, address);
        if (exceptionMassage.isEmpty()) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException(exceptionMassage.toString());
        }
    }

    private static StringBuilder createExceptionMassage(String name, int age, String job, String address) {
        StringBuilder exceptionMassage = new StringBuilder();

        if (name.isEmpty()) {
            exceptionMassage.append("Name is empty\n");
        }
        if (age < 18) {
            exceptionMassage.append(String.format("Age under 18, your age is %s\n", age));
        }
        if (!VALID_JOBS.contains(job)) {
            exceptionMassage.append(String.format("Illegal job, your job is %s\n", job));
        }
        if (!VALID_ADDRESSES.contains(address)) {
            exceptionMassage.append(String.format("Illegal address your address is %s", address));
        }

        return exceptionMassage;
    }
}