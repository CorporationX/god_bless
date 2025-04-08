package school.faang.modul_rpg;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Arthur");
        Archer archer = new Archer("Legolas");

        System.out.printf("%s health: %d%n", warrior.getName(), warrior.getHealth());
        System.out.printf("%s health: %d%n", archer.getName(), archer.getHealth());

        warrior.attack(archer);
        System.out.printf("%s health: %d%n", archer.getName(), archer.getHealth());

        archer.attack(warrior);
        System.out.printf("%s health: %d%n", warrior.getName(), warrior.getHealth());

        Character basicCharacter = new Character("Basic Guy") {

            @Override
            public void attack(Character opponent) {
                System.out.printf("%s lazily pokes %s for 1 damage!%n", name, opponent.getName());
                opponent.takeDamage(1);
            }
        };
        System.out.printf("%s health: %d%n", basicCharacter.getName(), basicCharacter.getHealth());
        archer.attack(basicCharacter);
        System.out.printf("%s health: %d%n", basicCharacter.getName(), basicCharacter.getHealth());
    }
}