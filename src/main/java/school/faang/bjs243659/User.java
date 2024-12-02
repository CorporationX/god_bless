package school.faang.bjs243659;

import java.util.List;

public class User {
    private final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(String name, Integer age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
            return;
        }
        throw new IllegalArgumentException("Имя не может быть пустым");
    }

    public void setAge(Integer age) {
        if (age >= 18) {
            this.age = age;
            return;
        }
        throw new IllegalArgumentException("Возраст не может быть меньше 18");
    }

    public void setJob(String job) {
        for (String validJob : VALID_JOBS) {
            if (job.equals(validJob)) {
                this.job = job;
                return;
            }
        }
        throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
    }

    public void setAddress(String address) {
        for (String validAddress : VALID_ADDRESSES) {
            if (address.equals(validAddress)) {
                this.address = address;
                return;
            }
        }
        throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
    }
}
