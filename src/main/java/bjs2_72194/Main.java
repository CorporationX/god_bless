package bjs2_72194;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        Squad archers = new Squad();
        archers.addCharacter(new Archer(25));
        archers.addCharacter(new Archer(30));

        Squad swordsmen = new Squad();
        swordsmen.addCharacter(new Swordsman(40));
        swordsmen.addCharacter(new Swordsman(35));

        army.addSquad(archers);
        army.addSquad(swordsmen);

        log.info("The overall strength of the army: " + army.calculateTotalPower());
    }
}
