package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User firstUser = new User("John",22,"Bells","Google");
        User secondUser = new User("Stu",12,"Bells","Amazon");
        User thirdUser = new User("Steve",22,"Grows","FAANG");
        User fourthUser = new User("Ada",19,"Clay","Яндекс");

        List<User> users = new ArrayList<>();
        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);
        users.add(fourthUser);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);


        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey() + " -> Users: " + entry.getValue());
        }
    }
}
