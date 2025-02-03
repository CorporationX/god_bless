package school.faang;

import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private String work;
    private String location;

    public static void groupUser(ArrayList<User> users) {
        Map<Integer, ArrayList<User>> userMap = new HashMap<>();
        for (User user : users) {
            if (!userMap.containsKey(user.age)) {
                userMap.put(user.age, new ArrayList<>());
            }
            userMap.get(user.age).add(user);
        }
        for (Map.Entry<Integer, ArrayList<User>> entry : userMap.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<User> userList = entry.getValue();
            System.out.println(key + " Age: ");
            for (User user : userList) {
                System.out.println( "Name: " + user.name + " , age: " + user.age +
                        " , work: " + user.work + " , location: " + user.location );
            }
        }
    }
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        User andrew = new User("Andrew", 45, "Service", "Novosibirsk");
        User artur = new User("Artur", 35, "Five Group", "Tomsk");
        User angelina = new User("Angelina", 21, "IT-Company", "Moscow");
        User artem = new User("Artem", 45, "Magnet", "Kemerovo");
        User maria = new User("Maria", 21, "AutoService", "Saint-Petersburg");

        users.add(andrew);
        users.add(artur);
        users.add(angelina);
        users.add(artem);
        users.add(maria);
        groupUser(users);



    }
}
