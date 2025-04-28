package school.faang.heroes;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private List<Warrior> warriors = new ArrayList<>();
    private int totalStrength;
    public int calculateSquadPower(){
        for (Warrior warrior : warriors) {
            totalStrength+= warrior.getStrength();
        }
        return totalStrength;
    }
    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }
}
