package faang.school.godbless.sprint3.supercow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss();

        Player player = new Player("Pavel");
        Player player2 = new Player("Vlad");
        Player player3 = new Player("Ivan");
        Player player4 = new Player("Anton");

        boss.joinBattle(player);
        boss.joinBattle(player2);
        boss.joinBattle(player3);
        boss.joinBattle(player4);
    }
}
