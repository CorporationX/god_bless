package school.faang;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> hob = new HashSet<String>();
        hob.add("play");
        hob.add("swim");
        Set<String> hob1 = new HashSet<String>();
        hob.add("read");
        hob.add("learn");
        User Nariman=new User(1, "Nariman", 24, hob);
        User Era=new User(2, "Era", 25, hob1);
        User Shifu=new User(3, "Shifu", 27, hob);
        ArrayList<User> users=new ArrayList<>();
        users.add(Nariman);
        users.add(Era);
        users.add(Shifu);
        Set<String> hob2 = new HashSet<String>();
        hob2.add("play");
        Map<String,String> map=User.findHobbyLovers(users, hob2);
        map.forEach((name,hobby)->
            System.out.println("name: "+name+ "   hobby: " + hobby)
        );
    }
}
