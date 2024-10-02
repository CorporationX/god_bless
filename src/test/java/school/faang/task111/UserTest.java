package school.faang.task111;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsers() {
        List<User> testList = new ArrayList<>();
        testList.add(new User("Вася",14,"Самокат","Г.Москва"));
        testList.add(new User("Илья",14,"Яндекс","Г.Адлер"));
        testList.add(new User("masha",15,"ММК","Г.Магнитогорск"));

        Map<Integer,List<User>> testMap = new HashMap<>();

        List<User> listForMap = new ArrayList<>();
        listForMap.add(new User("Вася",14,"Самокат","Г.Москва"));
        listForMap.add(new User("Илья",14,"Яндекс","Г.Адлер"));

        testMap.put(14,listForMap);

        List<User> secondListForMap = new ArrayList<>();
        secondListForMap.add(new User("masha",15,"ММК","Г.Магнитогорск"));

        testMap.put(15,secondListForMap);

        Map<Integer,List<User>> actualMap= User.groupUsers(testList);

        Assertions.assertEquals(testMap,actualMap);
    }
}