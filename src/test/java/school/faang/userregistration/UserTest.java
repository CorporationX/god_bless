package school.faang.userregistration;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    static private List<User> initList;
    static private ArrayList<int[]> outCheckResultList;

    @Test
    void transferListUsersToMapNullReturnNull() {
        assertEquals(User.groupUsersByAge(null), new HashMap<>());
    }

    @Test
    void transferListUsersToMap() {
        setInitData();
        Map<Integer, List<User>> testedMap = User.groupUsersByAge(initList);
        assertEquals(testedMap.size(), outCheckResultList.size());
        for(int[] testArray : outCheckResultList){
            assertEquals(testedMap.get(testArray[0]).size(), testArray[1]);
        }
    }

    private static void setInitData(){
        initList = new ArrayList<>();
        initList.add(new User("Name1", 1, "WorkingPlace1", "Address1"));
        initList.add(new User("Name5", 5, "WorkingPlace5", "Address5"));
        initList.add(new User("Name3", 3, "WorkingPlace3", "Address3"));
        initList.add(new User("Name4", 1, "WorkingPlace4", "Address4"));

        outCheckResultList = new ArrayList<>();
        outCheckResultList.add(new int[] {1,2});
        outCheckResultList.add(new int[] {5,1});
        outCheckResultList.add(new int[] {3,1});
    }
}
