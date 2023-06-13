package abstraction;

    public class Main {
        public static void main(String[] args) {
            Character warrior = new Warrior("Vlad");
            Character archer = new Archer("Kolya");

            performAttack(warrior, archer);
            performAttack(archer, warrior);

            printCharacterHealth(warrior);
            printCharacterHealth(archer);
        }

        private static void performAttack(Character attacker, Character target) {
            attacker.attack(target);
        }

        private static void printCharacterHealth(Character character) {
            System.out.println(character.getName() + "'s health: " + character.getHealth());
        }
}
