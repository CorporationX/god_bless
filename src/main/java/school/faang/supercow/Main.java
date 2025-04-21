package school.faang.supercow;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(4);
        for (int i = 1; i <= 10; i++) {
            Player player = new Player("Игрок_" + i);
            new Thread(()->player.doBattle(boss)).start();
        }
    }
}
