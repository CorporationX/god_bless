package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User(1,"Vlad", 17, "music","tennis");
        User user2 = new User(2,"Gleb", 22,"football");
        User user3 = new User(3,"Zlata", 32,"");
        User user4 = new User(4,"Varvara", 17,"movies", "martial arts","games");
        User user5 = new User(5,"Nikolas", 24,"reading","drawing");
        User user6 = new User(6,"Mathew", 22,"travels");
        User user7 = new User(7,"Jennifer", 17,"singing","movies");
        User user8 = new User(8,"Andrew", 30,"theater", "swimming");
        User user9 = new User(9,"Alice", 35,"theater", "teachings","reading");
        User user10 = new User(10,"Jane", 35,"writings", "readings","poems");
        User user11 = new User(11,"Merry", 24,"dances","languages");
        User user12 = new User(12,"Lisa", 30,"yacht sport");
        User user13 = new User(13,"Arnold", 27,"football","games","movies");
        User user14 = new User(14,"Gwen", 17,"readings");
        User user15 = new User(15,"Michael", 35,"bikes","cars","auto sport");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
        users.add(user11);
        users.add(user12);
        users.add(user13);
        users.add(user14);
        users.add(user15);
        List<String> hobbies = new ArrayList<>();
       hobbies.add("auto sport");
       hobbies.add("reading");
       hobbies.add("languages");
       hobbies.add("dances");
       hobbies.add("travels");
       hobbies.add("bikes");
       Map<User,String> groupedUsers = User.findHobbyFrom(hobbies, users);

        System.out.println(groupedUsers);
    }
}