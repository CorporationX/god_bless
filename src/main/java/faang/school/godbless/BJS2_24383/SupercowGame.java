package faang.school.godbless.BJS2_24383;

class SupercowGame {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player player1 = new Player("Игрок 1", boss);
        Player player2 = new Player("Игрок 2", boss);
        Player player3 = new Player("Игрок 3", boss);
        Player player4 = new Player("Игрок 4", boss);

        new Thread(player1).start();
        new Thread(player2).start();
        new Thread(player3).start();
        new Thread(player4).start();
    }
}
