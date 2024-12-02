package school.faang.BJS2_43851;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Вадим", 23, "Банк", "Краснодар");
        User user2 = new User("Настя", 18, "Студент", "Новоросийск");
        User user3 = new User("Пулат", 31, "Разнорабочий", "Сочи");
        User user4 = new User("Олег", 31, "Безработный", "Хабаровск");
        User user5 = new User("Максим", 23, "Строительная фирма", "Самара");
        User user6 = new User("Оксана", 23, "Столовая", "Москва");

        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        HashMap<Integer,List<User>> hashMapUser = User.groupUsers(users);

        for(Map.Entry<Integer,List<User>> entry : hashMapUser.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
