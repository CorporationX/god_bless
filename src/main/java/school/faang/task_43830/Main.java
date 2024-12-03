package school.faang.task_43830;

public class Main {

    public static void main(String[] args) {

        Archer myArcher = new Archer("Anatolijs");
        Warrior myWarrior = new Warrior("Dmitrijs");

        System.out.println("Health :: " + myWarrior.getHealth());
        myArcher.attack(myWarrior);
        System.out.println("Health :: " + myWarrior.getHealth());
        myArcher.attack(myWarrior);
        System.out.println("Health :: " + myWarrior.getHealth());
        System.out.println(" ----------------- ");
        System.out.println("Health :: " + myArcher.getHealth());
        myWarrior.attack(myArcher);
        System.out.println("Health :: " + myArcher.getHealth());
        myArcher.attack(myArcher);
        System.out.println("Health :: " + myArcher.getHealth());
        myArcher.attack(myArcher);
        System.out.println("Health :: " + myArcher.getHealth());
    }
}
