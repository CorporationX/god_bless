package school.faang.Group_Users_By_Age;

import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {

        ArrayList<Userr> users = new ArrayList<>();
        users.add(new Userr("Anton", 17, "home", "18 street"));
        users.add(new Userr("Grisha", 18, "home", "18 street"));
        users.add(new Userr("Anton1", 17, "home", "18 street"));
        users.add(new Userr("Anton2", 19, "home", "18 street"));
        users.add(new Userr("Anton4", 14, "home", "18 street"));
        users.add(new Userr("Anton3", 14, "home", "18 street"));
        System.out.println(Userr.groupUsers(users));

    }

}