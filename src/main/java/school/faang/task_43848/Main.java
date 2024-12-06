package school.faang.task_43848;

public class Main {
    public static void main(String[] args) {
        Character attacker = new Warrior("Dmitry");
        Character defender = new Archer("Timofey");

        attacker.attack(defender);
        System.out.println("Current health of defender: " + defender.getHealth());
        defender.attack(attacker);
        System.out.println("Current health of attacker: " + attacker.getHealth());

        startBattle(attacker, defender);
    }

    public static void startBattle(Character attacker, Character defender) {
        System.out.println("Battle is starting");
        while (attacker.isAlive() && defender.isAlive()) {
            attacker.attack(defender);
            if (!defender.isAlive()) {
                System.out.println("Battle is ended. Winner: " + attacker.getName());
                break;
            }

            defender.attack(attacker);
            if (!attacker.isAlive()) {
                System.out.println("Battle is ended. Winner: " + defender.getName());
                break;
            }
        }
    }
}

