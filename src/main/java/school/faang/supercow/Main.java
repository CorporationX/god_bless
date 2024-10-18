package school.faang.supercow;

public class Main {
    public static void main(String[] args) {

        Boss valakas = new Boss();

        Player playerAlex = new Player("Alex");
        Player playerIra = new Player("Ira");
        Player playerNatasha = new Player("Natasha");
        Player playerKolya = new Player("Kolya");

        new Thread(() -> valakas.joinBattle(playerAlex)).start();
        new Thread(() -> valakas.joinBattle(playerIra)).start();
        new Thread(() -> valakas.joinBattle(playerNatasha)).start();
        new Thread(() -> valakas.joinBattle(playerKolya)).start();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        new Thread(() -> valakas.leaveBattle(playerAlex)).start();
    }
}
