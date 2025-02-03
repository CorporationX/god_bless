package school.faang.abstraction;


import java.util.Random;

public class Game {
    Character character1;
    Character character2;

    public Game(Character character1, Character character2) {
        this.character1 = character1;
        this.character2 = character2;
        printStateOfCharacters();
        attack();
        printWinner();
    }

    private void printStateOfCharacters() {
        System.out.println(character1);
        System.out.println(character2);
    }

    private void attack() {
        Random random = new Random();
        do {
            int choice = random.nextInt(2);
            if (choice == 0) {
                character1.attack(character2);
            } else {
                character2.attack(character1);
            }
        } while (character1.isAlive() && character2.isAlive());
    }

    private void printWinner() {
        Character winner = character1.isAlive() ? character1 : character2;
        System.out.println("Winner\n" + winner);
    }
}
