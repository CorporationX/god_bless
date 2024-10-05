package school.BJS2_31329;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static school.BJS2_31329.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Рома","Екатеринбург","Сбер",27));
        users.add(new User("Катя","Москва","Яндекс",25));
        users.add(new User("Денис","Казань","Т-Банк",27));
        users.add(new User("Вика","Лондон","Сбер",23));
        users.add(new User("Соня","Нью-Йорк","Вкусно и точка",28));
        for (Map.Entry<Integer, List<User>> entry : groupUsers(users).entrySet()) {
            if(entry.getKey() == 27) {
                System.out.println(entry.getValue());
            }
        }
    }
}
