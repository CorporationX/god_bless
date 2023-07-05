package faang.school.godbless.asyncAndFuture.sendRaven;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Kingdom westernLands = new Kingdom("Western lands");
        Kingdom royalLands = new Kingdom("Royal lands");
        Kingdom riverLands = new Kingdom("River lands");
        Kingdom valeOfArryn = new Kingdom("Vale of Arryn");
        Kingdom ironIslands = new Kingdom("Iron islands");

        List<CompletableFuture<String>> list = List.of(
                westernLands.sendMessage(royalLands),
                westernLands.sendMessage(valeOfArryn),
                riverLands.sendMessage(ironIslands),
                riverLands.sendMessage(royalLands),
                royalLands.sendMessage(riverLands),
                royalLands.sendMessage(valeOfArryn)
        );

        list.forEach(future -> future.thenAccept(System.out::println));

        list.forEach(CompletableFuture::join);
    }
}
