package heroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Squad<Archer> archers = new Squad<>(SquadType.ARCHERS_SQUAD.getSquadType(),
                List.of(new Archer(Archer.ARCHER_STRENGTH),
                        new Archer(Archer.ARCHER_STRENGTH),
                        new Archer(Archer.ARCHER_STRENGTH)));
        Squad<Swordsman> swordsmen = new Squad<>(SquadType.SWORDSMEN_SQUAD.getSquadType(),
                List.of(new Swordsman(Swordsman.SWORDSMAN_STRENGTH),
                        new Swordsman(Swordsman.SWORDSMAN_STRENGTH)));
        Squad<Mage> mages = new Squad<>(SquadType.MAGES_SQUAD.getSquadType(),
                List.of(new Mage(Mage.MAGE_STRENGTH),
                        new Mage(Mage.MAGE_STRENGTH),
                        new Mage(Mage.MAGE_STRENGTH),
                        new Mage(Mage.MAGE_STRENGTH)));

        List<Squad<? extends Warrior>> squads = new ArrayList<>();
        squads.add(archers);
        squads.add(swordsmen);
        squads.add(mages);

        Army army = new Army(squads);
        int totalPower = army.calculateTotalPower();
        System.out.println("Total java.heroes.Army Power: " + totalPower);
    }
}

