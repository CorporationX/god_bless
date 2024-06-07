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
    Set<String> userValues1 = new HashSet<>(Arrays.asList("Чтение","Боулинг"));
    Set<String> userValues2 = new HashSet<>(Arrays.asList("Плавание","Рисование"));
    Set<String> userValues3 = new HashSet<>(Arrays.asList("Английский","Баскетбол"));
    Set<String> userValues4 = new HashSet<>(Arrays.asList("Скоропись","Футбол"));

    User Ivan = new User(1,"Ivan",20,userValues1);
    User Dima = new User(2,"Dima",25,userValues2);
    User Vova = new User(3,"Vova",19,userValues3);
    User Oleg = new User(4,"Oleg",18,userValues4);

    List<User> userList = new ArrayList<>();
    userList.add(Ivan);
    userList.add(Dima);
    userList.add(Vova);
    userList.add(Oleg);

    Set<String> activity = new HashSet<>(Arrays.asList("Чтение","Английский"));

    Map<User , String> hobbyLovers = findHobbyLovers(userList , activity);
    for(Map.Entry<User , String> entry : hobbyLovers.entrySet()){
        System.out.println(entry.getKey().name + " любит " + entry.getValue());
    }
    }
}