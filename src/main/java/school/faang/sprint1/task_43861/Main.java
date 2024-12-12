package school.faang.sprint1.task_43861;

class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Jack");
        Warrior warrior = new Warrior("Sarah");

        try {
            for (int i = 0; i < 100; i++) {
                archer.attack(warrior);
                warrior.attack(archer);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("game is over!");
        }
    }
}
