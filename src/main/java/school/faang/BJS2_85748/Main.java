package school.faang.BJS2_85748;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Users users1 = new Users("Sara", 22, "UX/UI", "Paris");
        Users users2 = new Users("Kevin", 25, "Data Analyst", "Toronto");
        Users users3 = new Users("Maya", 21, "QA Tester", "London");
        Users users4 = new Users("Alex", 25, "Frontend Developer", "Berlin");
        Users users5 = new Users("Liam", 25, "Backend Developer", "Tokyo");

        List<Users> usersList = new ArrayList<>();
        usersList.add(users1);
        usersList.add(users2);
        usersList.add(users3);
        usersList.add(users4);
        usersList.add(users5);

        Map<Integer, List<Users>> grouped = Users.groupUsers(usersList);
        System.out.println(grouped);
    }
}