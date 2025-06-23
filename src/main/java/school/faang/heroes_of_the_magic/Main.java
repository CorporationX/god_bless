package school.faang.heroes_of_the_magic;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad();
        archers.addUnit(new Archer());
        archers.addUnit(new Archer());
        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman());
        swordsmen.addUnit(new Swordsman());
        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}