package faang.school.godbless.task_work_users.users;


import java.util.*;

public class User {
    private String name;
    private int age;
    private String company;
    private String city;

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String company, String city) {
        validate(name, age, company, city);
        this.name = name;
        this.age = age;
        this.company = company;
        this.city = city;
    }

    private void validate(String name, int age, String company, String city) throws IllegalArgumentException {
        if (name.isBlank() || (age < 18) || !VALID_JOBS.contains(company) || !VALID_ADDRESSES.contains(city)) {
            throw new IllegalArgumentException("не допустимые значения !!!");
        }
    }

    public static Map<Integer, List<User>> getGroupUserAge(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        users.forEach(user -> {
            map.merge(user.getAge(), users.stream().filter(n -> n.getAge() == user.getAge()).toList(),
                    (key, value) -> value);
        });
        return map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork() {
        return company;
    }

    public void setWork(String company) {
        this.company = company;
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(company, user.company) && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, company, city);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
