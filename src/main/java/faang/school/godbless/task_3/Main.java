package faang.school.godbless.task_3;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Tem");
        Archer archer = new Archer("Vlad");

        System.out.println("Step 0");
        System.out.println(warrior.name + ": " + warrior.health);
        System.out.println(archer.name + ": " + archer.health);

        archer.attack(warrior);

        System.out.println("Step 1");
        System.out.println(warrior.name + ": " + warrior.health);
        System.out.println(archer.name + ": " + archer.health);

        warrior.attack(archer);

        System.out.println("Step 2");
        System.out.println(warrior.name + ": " + warrior.health);
        System.out.println(archer.name + ": " + archer.health);

        Character character = new Character("Bill", 3, 3 ,5) {
            @Override
            public void attack(Character opponent) {
                opponent.health -= this.strength * this.dexterity + this.intelligence;
            }
        };

        character.attack(warrior);
        character.attack(archer);

        System.out.println("Step 3");
        System.out.println(warrior.name + ": " + warrior.health);
        System.out.println(archer.name + ": " + archer.health);
    }

}
