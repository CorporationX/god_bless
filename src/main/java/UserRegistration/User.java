package UserRegistration;

import java.util.HashSet;
import java.util.Set;

public class User {
    public static Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public static Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String workPlace;
    private String adress;

    public User(String name, int age, String workPlace, String adress) {
        userValidation(name, age, workPlace, adress);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.adress = adress;
    }


    private void userValidation(String name, int age, String workPlace, String adress) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("имя пользователя не должно быть пустым");
        } else if (age < 18) {
            throw new IllegalArgumentException("Возраст пользователя должен быть не меньше 18ти");
        } else if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Место работы " + workPlace + " невалидно");
        } else if (!VALID_ADDRESSES.contains(adress)) {
            throw new IllegalArgumentException("Адрес " + adress + " невалиден");
        }
    }

}
