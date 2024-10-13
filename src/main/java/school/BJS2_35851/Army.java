package school.BJS2_35851;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Character> listOfCharacters = new ArrayList();

    public void addUnit(Character unit) {
        listOfCharacters.add(unit);
    }

//    public int calculateTotalPower() {
//
//        int totalPower = 0;
//        for (Character character : listOfCharacters) {
//            Thread thread = new Thread(() -> {
//                totalPower = character.getPower() + totalPower;
//
//            });
//        }
//
//
//    }





}
