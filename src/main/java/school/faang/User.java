package school.faang;

public class User {

    final static String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    final static String[] ADDRESS = {"London", "New York", "Amsterdam"};

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
       if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
       if (!isValidAge(age)) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
        if (!isValidJob(job)) {
            throw new IllegalArgumentException("Invalid job");
        }
        this.job = job;
        if (!isValidAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }

    public static boolean isValidJob(String job) {
        for (String validJob : VALID_JOBS) {
            if (validJob.equals(job)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidAddress(String address) {
        for (String validAddress : ADDRESS) {
            if (validAddress.equals(address)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidAge(int age) {
        return age >= 18 && age <= 99;
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
}

