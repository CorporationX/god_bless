package pigs.game;

import pigs.game.players.Pig1Thread;
import pigs.game.players.Pig2Thread;
import pigs.game.players.Pig3Thread;
import pigs.game.players.PigThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PigThread nifnifThread = new Pig1Thread("Nif-nif", "straw");
        PigThread nufnufThread = new Pig2Thread("Nuf-nuf", "sticks");
        PigThread nafnafThread = new Pig3Thread("Naf-naf", "stone");
        nifnifThread.start();
        nufnufThread.start();
        nafnafThread.start();
        nifnifThread.join();
        nufnufThread.join();
        nafnafThread.join();
        System.out.println("Game is finished!");
        System.out.println("But is this really the end? I hear howling...");
    }
}
