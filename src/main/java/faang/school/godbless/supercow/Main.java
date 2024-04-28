package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5,4);
        Player player1 = new Player("Gerald");
        Player player2 = new Player("John");
        Player player3 = new Player("Warlord");
        Thread player1Thread = new Thread(()->player1.startBattle(boss));
        Thread player2Thread = new Thread(()->player2.startBattle(boss));
        Thread player3Thread = new Thread(()->player3.startBattle(boss));

        player1Thread.start();
        player2Thread.start();
        player3Thread.start();


    }
}
