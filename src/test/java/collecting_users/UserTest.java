package collecting_users;

import org.junit.jupiter.api.Test;

import static collecting_users.User.findHobbyLovers;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UserTest {
    @Test
    public void findHobbyLovers_shouldReturnEmptyMap(){
        var result = findHobbyLovers(Collections.emptyList(), Collections.emptySet());
        assertEquals(0,result.size());
    }

    @Test
    public void findHobbyLovers_shouldReturnCorrectMap(){
        Set<String> user1Hobby = Set.of("плавание", "программирование", "армрестлинг", "шахматы");
        Set<String> user2Hobby = Set.of("рисование", "спорт", "чтение", "кулинария");
        Set<String> user3Hobby = Set.of("механника", "садоводство", "гитара", "баскетбол");

        Set<String> testHobby = Set.of("плавание", "кондитерство", "черчение", "гитара");

        User user1 = new User();
        user1.setActivities(user1Hobby);
        User user2 = new User();
        user2.setActivities(user2Hobby);
        User user3 = new User();
        user3.setActivities(user3Hobby);

        List<User> users = List.of(user1, user2, user3);

        var result = findHobbyLovers(users, testHobby);
        assertEquals(2, result.size());
    }
}
