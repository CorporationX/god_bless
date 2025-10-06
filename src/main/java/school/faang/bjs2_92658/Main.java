package school.faang.bjs2_92658;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem system = new QuestSystem();
        Quest sin = new Quest("Defeat THE Sin", 2, 100_000_000);
        Quest kitava = new Quest("The GOD Kitava", 2, 2_500);
        Quest dragonSlayer = new Quest("Slay the Ancient Dragon", 3, 150_000);
        Quest lostTemple = new Quest("Explore the Lost Temple", 3, 10_000);
        Quest darkRitual = new Quest("Dark Ritual Challenge", 5, 25_000);

        Player sorcerer = new Player("Zareth", 20, 5_000);
        Player amazon = new Player("Amazon", 1, 1_000);
        Player berserker = new Player("Bibo", 5, 50_000);
        Player knight = new Player("Sir Alaric", 30, 20_000);
        Player rogue = new Player("Kael", 15, 3_000);

        CompletableFuture<Player> pathOfNewbie = system.startQuest(amazon, kitava);
        CompletableFuture<Player> pathOfMadMan = system.startQuest(berserker, sin);
        CompletableFuture<Player> pathOfMystic = system.startQuest(sorcerer, darkRitual);
        CompletableFuture<Player> pathOfValor = system.startQuest(knight, dragonSlayer);
        CompletableFuture<Player> pathOfAdventure = system.startQuest(rogue, lostTemple);
        CompletableFuture<Player> pathOfAdventure2 = system.startQuest(amazon, sin);

        CompletableFuture.allOf(pathOfNewbie, pathOfMadMan, pathOfAdventure,  pathOfMystic, pathOfValor,
                pathOfAdventure2).join();

        system.executorsShutdown();
    }
}
