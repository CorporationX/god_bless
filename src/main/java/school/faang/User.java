package school.faang;

public class User {
    private static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        this.age = age;
    }

    public void setJob(String job) {
        for (String currentJob : VALID_JOBS) {
            if (currentJob.equals(job)) {
                this.job = job;
                return;
            }
        }
        throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
    }

    public void setAddress(String address) {
        for (String currentAddress : VALID_ADDRESSES) {
            if (currentAddress.equals(address)) {
                this.address = address;
                return;
            }
        }
        throw new IllegalArgumentException("Адрес должен быть содержится в наборе VALID_ADDRESSES");
    }
}
