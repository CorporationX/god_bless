package collectUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
    List<User> users = new ArrayList<>();
    User andrey = new User("Andrey", 33,"Home", "Moscow");
    User sabina = new User("Sabina", 18, "Sber", "Moscow");
    User elon = new User("Elon", 53,"Tesla", "USA");
    User noname = new User("Incognito", 33, "Null","Moscow");

    users.add(andrey);
    users.add(sabina);
    users.add(elon);
    users.add(noname);

    Map<Integer, List<User>> group = User.groupUsers(users);
    for(Map.Entry<Integer, List<User>> entry: group.entrySet()){
        for(User user: entry.getValue()){
                    System.out.println(entry.getKey()+":" + user.getFirstName()+ " " + user.getCompanyName() + " " + user.getAddress());
        }
    }
    }
}
