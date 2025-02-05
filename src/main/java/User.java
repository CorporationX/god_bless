import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS;
    public static final Set<String> VALID_ADDRESSES;

    static {
        VALID_JOBS = Set.of("Google", "Uber", "Amazon");
        VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    }

        public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
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

        public void setName(String name) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank!");
            } else {
                this.name = name;
            }
        }

        public void setAge(int age) {
            if (age < 18) {
                throw new IllegalArgumentException("Age cannot be less than 18!");
            } else {
                this.age = age;
            }
        }

        public void setJob(String job) {
            if (!VALID_JOBS.contains(job)) {
                throw new IllegalArgumentException("Invalid job!");
            } else {
                this.job = job;
            }
        }

        public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address!");
        } else {
            this.address = address;
        }
        }


}

