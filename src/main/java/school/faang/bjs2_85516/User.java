package school.faang.bjs2_85516;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    private Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    public User(String address, Integer age, String job, String name) {
        validate(address, job, age, name);

        this.address = address;
        this.job = job;
        this.age = age;
        this.name = name;
    }

    private void validate(String name, String job, Integer age, String address) {
        if (!VALID_ADDRESSES.contains(address) || address == null) {
            throw new IllegalArgumentException("адрес не корректен, необходимо " + VALID_ADDRESSES);
        }
        if (!VALID_JOBS.contains(job) || job == null) {
            throw new IllegalArgumentException("работа не корректна, необходимо " + VALID_JOBS);
        }
        if (age < 18) {
            throw new IllegalArgumentException("возраст должен быть больше 18");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
    }
}
