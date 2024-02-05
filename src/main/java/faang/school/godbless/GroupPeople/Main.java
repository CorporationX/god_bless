package faang.school.godbless.GroupPeople;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User test1 = new User("Нейм1", 25, "ООО ООО", "Город");
        User test2 = new User("Нейм2", 24, "ООО ОГО", "Село");
        User test3 = new User("Нейм3", 24, "ПАО ОАП", "ПГТ");
        User test4 = new User("Нейм4", 27, "ПлатимЕдой", "Нефтеюганск");

        List<User> testList = new ArrayList<>();
        Collections.addAll(testList, test1, test2, test3, test4);
        Map<Integer, List<User>> testMap = User.groupUser(testList);

        System.out.println(testMap);
    }
}
