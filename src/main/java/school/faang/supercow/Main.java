package school.faang.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(1);
        Player player1 = new Player("Валера");
        Player player2 = new Player("Абдурозик");
        Player player3 = new Player("Хасбик");
        Player player4 = new Player("Семён");

        Thread threadPlayer1 = new Thread(()-> {
            try {
                player1.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadPlayer2 = new Thread(()-> {
            try {
                player2.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadPlayer3= new Thread(()-> {
            try {
                player3.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadPlayer4= new Thread(()-> {
            try {
                player4.doBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadPlayer1.start();
        threadPlayer2.start();
        threadPlayer3.start();
        threadPlayer4.start();
    }
}
