package faang.school.godbless.grouping_users_by_age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // создаем пользователей
        Users sam = new Users("Sam", 21, "Uber", "London");
        Users ivan = new Users("Ivan", 28, "Amazon", "New York");
        Users maria = new Users("Maria", 45, "Google", "Amsterdam");
        Users natalia = new Users("Natalia", 21, "Uber", "Amsterdam");
        Users mihail = new Users("Mihail", 28, "Amazon", "London");
        Users eugen = new Users("Eugen", 45, "Google", "Amsterdam");

        // наполняем лист пользователями
        List<Users> usersList = new ArrayList<>();
        usersList.add(sam);
        usersList.add(ivan);
        usersList.add(maria);
        usersList.add(natalia);
        usersList.add(mihail);
        usersList.add(eugen);

        // сортируем пользователей по возрасту
        HashMap<Integer, List<Users>> usersByAge = Users.groupUsers(usersList);

        // выводим в консоль для наглядности
        for (Map.Entry<Integer, List<Users>> entry : usersByAge.entrySet()) {
            System.out.println("age = " + entry.getKey());
            for (Users user : entry.getValue()) {
                System.out.println(user.toString());
            }
        }
    }
}
