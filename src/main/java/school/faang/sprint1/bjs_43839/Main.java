package school.faang.sprint1.bjs_43839;

public class Main {
    public static void main(String[] args) {
        Character gamerW = new Warrior("Warrior gamer");
        Character gamerA = new Archer("Archer gamer");

        gamerW.attack(gamerA);
        gamerA.attack(gamerW);
        System.out.println(gamerA.name + " -> " + gamerA.health);
        System.out.println(gamerW.name + " -> " + gamerW.health);
        gamerW.attack(gamerW);
        System.out.println(gamerW.name + " -> " + gamerW.health);
    }
}
