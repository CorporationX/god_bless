package heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Squad<Archer> archers = new Squad<>(SquadType.ARCHERS_SQUAD.getSquadType(),
                List.of(new Archer(25), new Archer(25), new Archer(25)));
        Squad<Swordsman> swordsmen = new Squad<>(SquadType.SWORDSMEN_SQUAD.getSquadType(),
                List.of(new Swordsman(40), new Swordsman(40)));
        Squad<Mage> mages = new Squad<>(SquadType.MAGES_SQUAD.getSquadType(),
                List.of(new Mage(50), new Mage(50), new Mage(50), new Mage(50)));

        List<Squad<? extends Warrior>> squads = new ArrayList<>();
        squads.add(archers);
        squads.add(swordsmen);
        squads.add(mages);

        Army army = new Army(squads);
        int totalPower = army.calculateTotalPower();
        System.out.println("Total java.heroes.Army Power: " + totalPower);
    }
}

