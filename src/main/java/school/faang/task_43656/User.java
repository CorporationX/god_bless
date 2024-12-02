package school.faang.task_43656;

public class User {
    private String name;       // имя пользователя.
    private int age;            // возраст пользователя.
    private String job;         // место работы.
    private String address;     // адрес
    private static final String[] VALID_JOBS = new String[]{"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = new String[]{"London", "New York", "Amsterdam"};

    public User(String name, int age, String job, String address) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("The name is empty");
        } else if (age < 18) {
            throw new IllegalArgumentException("Age less 18");
        } else if (isIncorrectParam(job, VALID_JOBS)) {
            throw new IllegalArgumentException("job is not valid");
        } else if (isIncorrectParam(address, VALID_ADDRESSES)) {
            throw new IllegalArgumentException("address is not valid");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private boolean isIncorrectParam(String param, String[] validValues) {
        for (String validString : validValues) {
            if (param.equals(validString)) {
                return false;
            }
        }
        return true;
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
