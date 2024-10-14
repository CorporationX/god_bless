package Army;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addWarrior(new Archer(25));
        army.addWarrior(new Archer(25));
        army.addWarrior(new Mag(50));
        army.addWarrior(new Swordsman(75));
        army.addWarrior(new Swordsman(25));
        army.addWarrior(new Mag(50));

        System.out.println("Total power: "+army.calculateTotalPower());
    }
}
