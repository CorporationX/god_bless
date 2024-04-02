package faang.school.godbless.BJS2_4189;

public class Main {
    public static void main(String[] args) {

        Archer attackArcher = new Archer("Fletcher");
        Warrior defenderWarrior = new Warrior("Roy");
        attackArcher.attack(defenderWarrior);
        System.out.println("Roy health: " + defenderWarrior.getHealth());

        Warrior attackWarrior = new Warrior("Harry");
        Archer defenderArcher = new Archer("Piter");
        attackWarrior.attack(defenderArcher);
        System.out.println("Piter health: " + defenderArcher.getHealth());

    }
}
