package faang.school.godbless.raven;

import java.util.concurrent.CompletableFuture;

import static faang.school.godbless.raven.RavenService.sendRaven;

public record Kingdom(String name) {
    public CompletableFuture<String> sendMessage(Kingdom destinationKingdom) {
        return sendRaven(this, destinationKingdom);
    }
}
