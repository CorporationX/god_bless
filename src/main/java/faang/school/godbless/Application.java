package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static faang.school.godbless.User.*;

public class Application {
    public static void main(String[] args) {
        //создание объектов с типом User
        User user1  =  new User("user1", 20, "завод 1", "Москва");
        User user2  =  new User("user2", 30, "завод 2", "Москва");
        User user3  =  new User("user3", 20, "завод 1", "Москва");
        User user4  =  new User("user4", 30, "завод 2", "Москва");

        //создание списка объектов User
        List<User> userAll = new ArrayList<>();

        //добавление всех объектов
        userAll.add(user1);
        userAll.add(user2);
        userAll.add(user3);
        userAll.add(user4);

        //группировка пользователей по возрасту
        HashMap<String, List<User>> userMap = groupUser(userAll);

        //печать списка пользователей сгруппированных по возрасту
        userMap.forEach((year, user) ->{
            System.out.println("Возраст: " + year);
            user.forEach(userName -> {
                System.out.println("ФИО: " + userName.getName().toString() + ",  "
                        + "адрес: " + userName.getAdress());
            });
        });
    }
}