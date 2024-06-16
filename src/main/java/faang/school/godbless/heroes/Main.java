package faang.school.godbless.heroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addWarrior(new Archer(28, 27));
        army.addWarrior(new Archer(11, 33));
        army.addWarrior(new Swordsman(22, 32));
        army.addWarrior(new Swordsman(33, 44));
        army.addWarrior(new Mage(36, 44));
        army.addWarrior(new Mage(55, 12));
        System.out.println(army.calculateTotalStrengthArmy());
    }
}
