package school.faang.bjs2_85496;

public class User {
    private String name;
    private int age;
    private String jobLocation;
    private String address;

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", jobLocation='" + jobLocation + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User(String name, int age, String jobLocation, String address) {
        this.name = name;
        this.age = age;
        this.jobLocation = jobLocation;
        this.address = address;


    }
}