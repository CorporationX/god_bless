package userRegistration;

import java.util.HashSet;

public class User {

    String name;
    String work;
    String home;
    int age;

    public static HashSet<String> VALID_JOBS = new HashSet<>();
    public static HashSet<String> VALID_ADDRESSES = new HashSet<>();

    public User(String name, String home, String work, int age) {

        int minimumAge = 18;
        if (age < minimumAge) {
            throw new IllegalArgumentException("Возраст должен быть не менее 18 лет");
        } else {
            this.age = age;
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Неуказанно имя, укажите его");
        } else {
            this.name = name;
        }
        if (VALID_JOBS.contains(work) == false) {
            throw new IllegalArgumentException("Укажите другое место работы : Google, Uber, Amazon ");
        } else {
            this.work = work;
        }
        if (VALID_ADDRESSES.contains(home) == false) {
            throw new IllegalArgumentException("Укажите другой город : London, New York, Amsterdam ");
        } else {
            this.home = home;
        }

    }

    public static void main(String[] args) {

        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");

        User User1 = new User("Bob", "London", "Uber", 19);
        System.out.println(User1.name);
        System.out.println(User1.work);
        System.out.println(User1.home);
        System.out.println(User1.age);

        User User2 = new User("Jack", "London", "Uber", 18);
        System.out.println(User2.name);
    }
}
