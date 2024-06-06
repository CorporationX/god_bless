package faang.school.godbless;

import java.util.Set;
import java.util.HashSet;

public class User{
    private String name;
    private int age;
    private String workplace;
    private String adress;

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
        if(name.isEmpty()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        } else {
            this.name = name;
        }if(age < 18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        } else {
            this.age =age;
        }if(!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("место работы должно соответствовать одному из предложенных вариантов ");
        } else {
            this.workplace = workplace;
        }if(!VALID_ADDRESSES.contains(adress)){
                throw new IllegalArgumentException("адрес доленж соответствовать одному из предложенных варинатов");
            } else {
            this.adress = adress;
        }
    }
}