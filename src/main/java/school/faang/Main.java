package school.faang;

import java.util.*;

import static school.faang.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        User newUser1=new User("Nariman", 20);
        User newUser2=new User("Era", 21);
        User newUser3=new User("Shifu", 20);
        User newUser4=new User("Ser", 20);
        List<User> list=new ArrayList<>();
        list.add(newUser1);
        list.add(newUser2);
        list.add(newUser3);
        list.add(newUser4);

        Map<Integer, List<User>> map=groupUsers(list);
        List<Integer> keys=new ArrayList<>(map.keySet());

        for (int i=0;i<keys.size();i++){
            System.out.println("Возраст: "+keys.get(i)+" "+"Имя: "+map.get(keys.get(i)));
        }

    }
}
