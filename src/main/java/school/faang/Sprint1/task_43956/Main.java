package school.faang.Sprint1.task_43956;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User("Walter White", 50, "Gray Matter Technologies", "Albuquerque, NM"));
        listUser.add(new User(" Jesse Pinkman", 26, "Unemployed","Albuquerque, NM"));
        listUser.add(new User("Skyler White", 43, "Owner of A1A Car Wash", "Albuquerque, NM"));
        listUser.add(new User("Hank Schrader", 43, "DEA", "Albuquerque, NM"));
        listUser.add(new User("Saul Goodman", 50, "Saul Goodman & Associates", "Albuquerque, NM"));
        listUser.add(new User("Gustavo Fring", 50, " Los Pollos Hermanos", "Albuquerque, NM"));
        listUser.add(new User("Mike Ehrmantraut", 50, "Private investigator", "Albuquerque, NM"));
        Map<Integer, List<User>> groupedUser = User.groupUser(listUser);
        String result = groupedUser.toString();
        System.out.println(result);


    }
}

