package school.faang.heroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Squad archers = new Squad();
        archers.addWarrior(new Archer(25));
        archers.addWarrior(new Archer(30));

        Squad swordsmen = new Squad();
        swordsmen.addWarrior(new Swordsman(40));
        swordsmen.addWarrior(new Swordsman(35));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);

        System.out.println("Общая сила армии: " + army.calculateSquadPower());
    }
}
