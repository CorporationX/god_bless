package school.faang.groupusers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Usermain {
    public static void main(String[] args) {
        List<User> userlist = new ArrayList<>();
        userlist.add(new User("name1", 20, "rabota1", "adres1"));
        userlist.add(new User("name2", 20, "rabota2", "adres2"));
        userlist.add(new User("name3", 30, "rabota3", "adres3"));
        userlist.add(new User("name4", 20, "rabota4", "adres4"));
        userlist.add(new User("name5", 30, "rabota5", "adres5"));

        Map<Integer, List<User>> groupedUsers = User.groupUsers(userlist);

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {

            System.out.println("Возраст: " + entry.getKey());

            for (User user : entry.getValue()) {
                System.out.println(" - Имя: %s" + user.getName() + ", Место работы: %s" +
                        user.getWorkplace() + ", Адрес: %s%n" + user.getAddress());
            }

        }
    }
}