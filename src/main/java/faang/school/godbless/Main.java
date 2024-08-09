package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> listOfAllUser = new ArrayList<>();

        User firstUser = new User("Maxim", 23, "Ajaks", "Moscow");
        User secondUser = new User("Evgeniy", 31, "Sber", "Moscow");
        User thirdUser = new User("Elena", 23, "RosAtom", "Moscow");
        User fourthUser = new User("Ingvar", 51, "free_lance", "Moscow");
        User fifthUser = new User("Svetlana", 52, "RosAtom", "Moscow");

        listOfAllUser = List.of(firstUser, secondUser, thirdUser, fourthUser, fifthUser);

        for(Map.Entry<Integer, List<User>> entry : User.groupUsers(listOfAllUser).entrySet()){
            System.out.println("Возраст: " + entry.getKey() + ", сотрудники: " + " ");
            for(User user : entry.getValue()){
                System.out.printf(user.name);
                System.out.printf(", ");
            }
            System.out.println("");
        }
    }
}