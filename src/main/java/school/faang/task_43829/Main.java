package school.faang.task_43829;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Archer");
        Warrior warrior = new Warrior("Warrior");

        while (warrior.health > 0 && archer.health > 0) {
            archer.attack(warrior);
            System.out.println(String.format("Heath %s after attack %s: %s", warrior.getName(),archer.getName(), warrior.health));
            warrior.attack(archer);
            if (isDead(archer)){
                break;
            }
            System.out.println(String.format("Heath %s after attack %s: %s", archer.getName(), warrior.getName(), archer.health));
            if (isDead(archer)){
               break;
            }

        }
    }

    private static boolean isDead(Character character) {
        if (character.isDead()){
            System.out.println(String.format("%s is dead.", character.getName()));
            return true;
        }
        return false;
    }
}
