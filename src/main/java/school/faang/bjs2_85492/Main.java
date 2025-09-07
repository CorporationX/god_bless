package school.faang.bjs2_85492;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Список юзеров
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Ваня", 28, new HashSet<>(Arrays.asList("велосипед", "футбол"))));
        users.add(new User(2, "Аня",  32, new HashSet<>(Arrays.asList("танцы", "кино"))));
        users.add(new User(3, "Леша", 25, new HashSet<>(Arrays.asList("футбол", "баскетбол"))));
        users.add(new User(4, "Вика", 25, new HashSet<>(Arrays.asList("шахматы", "бег"))));

        //Список интересуемых активностей
        Set<String> targetActivities = new HashSet<>(List.of("футбол", "кино"));

        //Вызов метода для поиска итересующих нас юзеров
        Map<String, String> interestUser = User.findHobbyLovers(users, targetActivities);

        //Вывод на экран нужных юзеров
        System.out.println(interestUser);
    }
}
