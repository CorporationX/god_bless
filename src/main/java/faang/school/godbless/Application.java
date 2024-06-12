package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import static faang.school.godbless.User.findHobbyLovers;

public class Application{
    public static void main(String[] args){
    Set<String> userIvan = new HashSet<>(Arrays.asList("Чтение","Боулинг"));
    Set<String> userDima = new HashSet<>(Arrays.asList("Плавание","Рисование"));
    Set<String> userVova = new HashSet<>(Arrays.asList("Английский","Баскетбол"));
    Set<String> userOleg = new HashSet<>(Arrays.asList("Скоропись","Футбол"));

    User Ivan = new User(1,"Ivan",20,userIvan);
    User Dima = new User(2,"Dima",25,userDima);
    User Vova = new User(3,"Vova",19,userVova);
    User Oleg = new User(4,"Oleg",18,userOleg);

    List<User> userList = new ArrayList<>();
    userList.add(Ivan);
    userList.add(Dima);
    userList.add(Vova);
    userList.add(Oleg);

    Set<String> activity = new HashSet<>(Arrays.asList("Чтение","Английский"));

    Map<User , String> hobbyLovers = findHobbyLovers(userList , activity);
    for(Map.Entry<User , String> entry : hobbyLovers.entrySet()){
        System.out.println(entry.getKey().name() + " любит " + entry.getValue());
    }
    }
}