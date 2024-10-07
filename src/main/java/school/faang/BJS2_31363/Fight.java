package school.faang.BJS2_31363;

public class Fight {
    public static void main(String[] args) {
        Character warrior = new Warrior("Thor");
        Character archer = new Archer("Legolas");

        System.out.println("Battle starts between " + warrior.name + " and " + archer.name + "!");

        while (warrior.isAlive() && archer.isAlive()) {
            warrior.attack(archer);
            if (!archer.isAlive()) {
                break;
            }
            System.out.println(archer.name + "'s health: " + archer.health);
            archer.attack(warrior);
            if (!archer.isAlive()){
                break;
            }
            System.out.println(warrior.name + "'s health: " + warrior.health);
        }
    }

}
