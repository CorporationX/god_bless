package school.faang.sprint1.bjs_43839;

public class Main {
    public static void main(String[] args) {
        Character gamerW = new Warrior("Warrior gamer");
        Character gamerA = new Archer("Archer gamer");

        for (int i = 0; i < 4; i++) {
            gamerW.attack(gamerA);
            System.out.println(gamerA);
            gamerA.attack(gamerW);
            System.out.println(gamerW);
            gamerW.attack(gamerW);
            System.out.println(gamerW);
        }
    }
}
