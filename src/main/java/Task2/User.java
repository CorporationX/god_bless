package Task2;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber","Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static int AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address){
        validation(name,age,job,address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
    private void validation(String name, int age, String job, String address){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Поле 'имя' не заполнено");
        }else if(age < AGE){
            throw new IllegalArgumentException("Вам меньше 18 лет");
        }else if(!VALID_JOBS.contains(job)){
            throw new IllegalArgumentException("Место работы не найдено");
        }else if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Адрес не найден");
        }
    }
}
