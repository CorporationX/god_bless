package school.faang;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class UserTest {

    static private List<User> initList;
    static private ArrayList<int[]> outCheckResultList;

    @Test
    void transferListUsersToMapNullReturnNull() {
        assertNull(User.transferListUsersToMap(null));
    }

    @Test
    void transferListUsersToMap() {
        setInitData();
        Map<Integer, List<User>> testedMap = User.transferListUsersToMap(initList);
        assertEquals(testedMap.size(), outCheckResultList.size());
        for(int [] testArray : outCheckResultList){
            assertEquals(testedMap.get(testArray[0]).size(), testArray[1]);
        }
    }

    private static void setInitData(){
         initList = new ArrayList<>();
         initList.add(new User("Name1", 1, "WorkingPalce1", "Addresse1"));
         initList.add(new User("Name5", 5, "WorkingPalce5", "Addresse5"));
         initList.add(new User("Name3", 3, "WorkingPalce3", "Addresse3"));
         initList.add(new User("Name4", 1, "WorkingPalce4", "Addresse4"));

         outCheckResultList = new ArrayList<>();
         outCheckResultList.add(new int[] {1,2});
         outCheckResultList.add(new int[] {5,1});
         outCheckResultList.add(new int[] {3,1});
    }
}