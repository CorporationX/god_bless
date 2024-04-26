package faang.school.godbless.Task_25;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2, 0);

        Thread playerOne = new Thread(() -> new Player("John").startBattle(boss));
        Thread playerTwo = new Thread(() -> new Player("Mike").startBattle(boss));
        Thread playerThree = new Thread(() -> new Player("Kevin").startBattle(boss));

        playerOne.start();
        playerTwo.start();
        playerThree.start();

    }
}
