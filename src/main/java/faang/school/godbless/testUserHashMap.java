package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class testUserHashMap {

        @Test
        public void Map(){
        Map<User, String> userMap=new HashMap<>();
        User user1=new User(1, "Behzod", 24, Set.of("Хокей", "Футбол", "Программирование"));
        User user2=new User(2, "Sasha", 25, Set.of("Музыка", "Плавание", "Лыжи"));
        User user3=new User(3, "Masha", 26, Set.of("Хокей", "Бег", "Путешествия"));

        userMap.put(user1, "Бег");
        userMap.put(user2, "Шахматы");
        userMap.put(user3, "Походы");

        //remove
        userMap.remove("Плавание");
        assertEquals(1, userMap.size());
        assertFalse(userMap.containsKey(user1));

        //проверка equals()
        assertTrue(user1.equals(user2));

        //проверка hashcode
        int hashcode1=user1.hashCode();
        int hashcode2=user2.hashCode();
        assertEquals(user1, user2);

    }
}
