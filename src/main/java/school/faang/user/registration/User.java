package school.faang.user.registration;

import java.util.Arrays;
import java.util.Set;

public class User {
    public static final Set<String> VALID_JOBS = Set.of("Uber", "Google", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final String name;
    private final int age;
    private final String job;
    private final String address;
    public static final int MIN_AGE = 18

    public User(String name, int age, String job, String address) {
        if(name == null || job == null || address == null){
            throw new IllegalArgumentException("Заполните все поля");
        }
        if(!name.isBlank()){
            throw new IllegalArgumentException("Введите ваше имя корректно");
        }
        if(age < MIN_AGE){
            throw new IllegalArgumentException("Регистрация доступна с 18 лет");
        }
        if(!Arrays.asList(VALID_JOBS).contains(job)){
            throw new IllegalArgumentException("Неверное значение в поле работы. " +
                    "Работа должна быть одна из следующих: Google, Uber, Amazon");
        }
        if(!Arrays.asList(VALID_ADDRESSES).contains(address)){
            throw new IllegalArgumentException("Неверное значение в поле адреса. " +
                    "Адрес должен быть один из следующих: London, New York, Amsterdam");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }//
}
