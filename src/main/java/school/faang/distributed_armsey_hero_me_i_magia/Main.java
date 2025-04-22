package school.faang.distributed_armsey_hero_me_i_magia;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final Army army = new Army();
        Squad archers = new Squad();
        archers.addUnit(new Archer());
        archers.addUnit(new Archer());

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman());
        swordsmen.addUnit(new Swordsman());

        Squad mages = new Squad();
        mages.addUnit(new Mage());
        mages.addUnit(new Mage());

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}
