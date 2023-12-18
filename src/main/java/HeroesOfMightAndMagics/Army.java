package HeroesOfMightAndMagics;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
    private List<Character> army = new ArrayList<>();
    private int totalPower = 0;

    public int calculateTotalPower() throws Exception {
        int totalPower = 0;
        List<ArmyPowerThread> listOfPowerThreads = new ArrayList<>();
        for (Character character : army){
        //Запускаем поток в котором прибавим силу текущей армии к totalPower
            ArmyPowerThread armyPowerThread = new ArmyPowerThread(character);
            armyPowerThread.start();
            listOfPowerThreads.add(armyPowerThread);
        }

        for (ArmyPowerThread armyPowerThread : listOfPowerThreads){
            armyPowerThread.join();
            totalPower += armyPowerThread.getCurrentPower();
        }

        return totalPower;
    }

    public void addUnit(Character character){
        army.add(character);
    }

}
