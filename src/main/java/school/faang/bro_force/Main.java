package school.faang.bro_force;

public class Main {
    public static void main(String[] args) {
        Team zoo = new Team();
        Player firstPlayer = new Player("Donkey");
        Player secondPlayer = new Player("Giraffe");
        zoo.addPlayer(firstPlayer);
        zoo.addPlayer(secondPlayer);
        zoo.startGame();
    }
}
