package faang.school.godbless;

import java.util.Set;
import java.util.HashSet;

public class User{
    private final String name;
    private final int age;
    private final String workplace;
    private final String adress;

    private static final Set <String> VALID_JOBS = new HashSet<>();
    private static final Set <String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public User(String name, int age, String workplace, String adress){
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.adress = adress;
        validate();
    }

    private void validate(){
        if(this.name.isEmpty()){
            throw new IllegalArgumentException("Name не может быть пустым");
        } if (this.age < 18){
            throw new IllegalArgumentException("Указаны неверные данные");
        } if (!VALID_JOBS.contains(this.workplace)){
            throw new IllegalArgumentException("Место работы выбранно не верно");
        } if (!VALID_ADDRESSES.contains(this.adress)){
            throw new IllegalArgumentException("Адресс проживания выбран не верно");
        }
    }

    public void getValue(){
        System.out.println(name + age + workplace + adress);
    }
}