package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character[] characters = new Character[3];
        characters[0] = new Warrior("Axe");
        characters[1] = new Archer("Drow Ranger");
        characters[2] = new Warrior("Pudge");

        for (int i = 0; i < characters.length - 1; i++) {
            characters[i].attack(characters[2]);
            System.out.println("Здоровье груши для битья: " + characters[2].getHealth());
        }
    }
}
