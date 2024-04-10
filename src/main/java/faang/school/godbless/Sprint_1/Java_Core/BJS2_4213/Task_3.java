package faang.school.godbless.Sprint_1.Java_Core.BJS2_4213;

import java.util.Set;

public class Task_3 {
    public static void main(String[] args) {
        PlaseOfWork plaseOfWork = new PlaseOfWork("Lexa",18,"Google","London");
    }
}
class PlaseOfWork{
    private static final Set<String> VALID_JOBS = Set.of("Google","Uber","Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;
    public PlaseOfWork(String name, int age, String job, String address) {
        if (name == null){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18){
            throw new IllegalArgumentException("Возраст меньше 18 лет");
        }
        if (!VALID_JOBS.contains(job)){
            throw new IllegalArgumentException("Место работы неккоректно");
        }
        if (!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Город работы неккоректен");
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;


    }
}

//1. В том же классе пользователя создать конструктор, который принимает в качестве параметров значения для всех полей класса.
//2. В качестве статических констант в классе объявить 2 сета:
//VALID_JOBS— сразу инициализировать его, содержащим 3 строки: “Google”, “Uber”, “Amazon”;
//VALID_ADDRESSES— сразу инициализировать его, содержащим 3 строки: “London”, “New York”, “Amsterdam”.
//3. В конструкторе провести валидацию этих параметров по следующим правилам:
//имя не может быть пустым;
//возраст не может быть меньше 18;
//место работы должно содержаться во множестве VALID_JOBS;
//адрес должен содержаться во множестве VALID_ADDRESSES.
//Если хотя бы одно из условий не выполняется, то выбросить исключение IllegalArgumentException.
//Иначе сохранить переданные значения в поля.
