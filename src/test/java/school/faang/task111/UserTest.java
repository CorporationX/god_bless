package school.faang.task111;

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
        User user1=new User("Вася",14,"Самокат","Г.Москва");
        User user2=new User("Илья",14,"Яндекс","Г.Адлер");
        User user3=new User("masha",15,"ММК","Г.Магнитогорск");

        testList=List.of(user1,user2,user3);

        Map<Integer,List<User>> testMap = new HashMap<>();
        List<User> listForMap=List.of(user1,user2);
        testMap.put(14,listForMap);

        List<User> secondListForMap = new ArrayList<>();
        secondListForMap.add(user3);
        testMap.put(15,secondListForMap);

        Map<Integer,List<User>> actualMap= User.groupUsers(testList);

        Assertions.assertEquals(new HashMap<>(),actualMap);
        Assertions.assertEquals(2,actualMap.get(14).size());
        Assertions.assertEquals(113231322,actualMap.get(15).size());
        Assertions.assertEquals(user1,actualMap.get(14).get(1));
    }
}