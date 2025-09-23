package school.faang.bjs2_86611;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Aleks");
        Archer archer = new Archer("Boris");

        System.out.println(" name " + warrior.getName() +
                " power " + warrior.getPower() + " hp " + warrior.getHealth());
        System.out.println(" name " + archer.getName() +
                " power " + warrior.getAgility() + " hp " + warrior.getHealth());


        for (int i = 0; i < archer.getHealth(); i++) {
            archer.attack(warrior);
            System.out.println("archer attacked warrior");
            System.out.println(warrior.getHealth() + "warrior hp");
            warrior.attack(archer);
            System.out.println("warrior attacked archer");
            System.out.println(archer.getHealth() + "archer hp");
            boolean hpManager = archer.checkHealth(warrior.getHealth()) || warrior.checkHealth(archer.getHealth());
            if (hpManager) {
                return;
            }
        }
    
    }
}
