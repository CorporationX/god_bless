package school.faang.modul_rpg;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Arthur");
        Archer archer = new Archer("Legolas");

        System.out.println(warrior.getName() + " health: " + warrior.getHealth());
        System.out.println(archer.getName() + " health: " + archer.getHealth());

        warrior.attack(archer);
        System.out.println(archer.getName() + " health: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " health: " + warrior.getHealth());

        Character basicCharacter = new Character("Basic Guy") {

            @Override
            public void attack(Character opponent) {
                System.out.println(name + " lazily pokes " + opponent.getName() + " for 1 damage!");
                opponent.takeDamage(1);
            }
        };
        System.out.println(basicCharacter.getName() + " health: " + basicCharacter.getHealth());
        archer.attack(basicCharacter);
        System.out.println(basicCharacter.getName() + " health: " + basicCharacter.getHealth());
    }
}