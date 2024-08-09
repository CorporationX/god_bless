package faang.school.godbless;

import java.util.*;

public class User {
    String name;
    int age;
    String place_of_work;
    String adress;

    public User(String name, int age, String place_of_work, String adress){
        this.name = name;
        this.age = age;
        this.place_of_work = place_of_work;
        this.adress = adress;
    }

    static Map<Integer, List<User>> groupUsers(List<User> users){

        Map<Integer, List<User>> targetMap = new HashMap<>();
        Set<Integer> setOfAge = new HashSet<>();
        List<User> listOfTargetUser;

        for(User currentUser : users){ //сбор всех возрастов без повторений
            setOfAge.add(currentUser.age);
        }
        for (int currentAge : setOfAge){ // сопоставление возрастов с юзерами, при совпадении добавить пользователя в список текущего возраст
            listOfTargetUser = new ArrayList<>();
            for(User currentUser : users){
                if (currentUser.age == currentAge) {
                    if(!listOfTargetUser.contains(currentUser)){
                        listOfTargetUser.add(currentUser);
                    }
                }
            }
            targetMap.put(currentAge, listOfTargetUser);
        }
        return targetMap;
    }
}
