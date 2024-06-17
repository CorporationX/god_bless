package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Условия задачи
//В том же классе пользователя создать конструктор,
// который принимает в качестве параметров значения для всех полей класса.
//
//В качестве статических констант в классе объявить 2 сета:
//
//{{VALID_JOBS}}— сразу инициализировать его, содержащим 3 строки:
// Google”, “Uber”, “Amazon”;
//
//{{VALID_ADDRESSES}}— сразу инициализировать его, содержащим 3 строки:
// “London”, “New York”, “Amsterdam”.
//
//В конструкторе провести валидацию этих параметров по следующим правилам:
//
//имя не может быть пустым;
//
//возраст не может быть меньше 18;
//
//место работы должно содержаться во множестве VALID_JOBS;
//
//адрес должен содержаться во множестве VALID_ADDRESSES.
//
//Если хотя бы одно из условий не выполняется,
// то выбросить исключение IllegalArgumentException.
public class User {
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public int getAge(){
        return this.age;
    }
    //имя не может быть пустым;
    ////
    ////возраст не может быть меньше 18;
    ////
    ////место работы должно содержаться во множестве VALID_JOBS;
    ////
    ////адрес должен содержаться во множестве VALID_ADDRESSES.
    ////
    ////Если хотя бы одно из условий не выполняется,
    //// то выбросить исключение IllegalArgumentException.
    public User (String name, Integer age, String workplace, String address) {
        if (name == "" || !VALID_JOBS.contains(workplace) || age < 18 || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("incorrect arguments");
        } else {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        }
    }
    public static Map<Integer, List<User>> groupUsers(List<User> userlist) {
        Map<Integer, List<User>> readyMap = new HashMap<Integer, List<User>>();
        for (User usr: userlist) {
            if(readyMap.containsKey(usr.getAge())) {
                readyMap.get(usr.getAge()).add(usr);
            } else {
                List<User> tempList = new ArrayList<User>();
                tempList.add(usr);
                readyMap.put(usr.getAge(),tempList);
            }
        }
        return readyMap;
    }
}
