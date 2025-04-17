package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior ork = new Warrior("Орк");
        Archer legolas = new Archer("Леголас");

        try {
            ork.attack(legolas);
            legolas.attack(ork);
            System.out.println(ork.getHealth());
            System.out.println(legolas.getHealth());
        } catch (IllegalArgumentException e) {
            System.out.printf("Неверное значение здоровья: %s", e.getMessage());
        }
    }

}
