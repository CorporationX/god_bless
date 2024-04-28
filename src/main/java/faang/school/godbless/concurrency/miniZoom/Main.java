package faang.school.godbless.concurrency.miniZoom;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference("The open doors day");
        Set<Participant> users = new HashSet<>();

        List<CompletableFuture<Void>> connectionsResults = new ArrayList<>();

        users.add(new Participant("Denis"));
        users.add(new Participant("Oleg"));
        users.add(new Participant("Vasya"));
        users.add(new Participant("Yarik"));
        users.add(new Participant("Ruslan"));
        users.add(new Participant("Alex"));
        users.add(new Participant("Elisey"));
        users.add(new Participant("Danya"));
        users.add(new Participant("Dimon"));
        users.add(new Participant("Nikita"));
        users.add(new Participant("Robert"));
        users.add(new Participant("Volodimir"));

        ExecutorService usersPool = Executors.newCachedThreadPool();

        users.forEach(user -> {
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(0, 5));
            } catch (InterruptedException e) {
                log.error("User " + user.name() + " was interrupted during joining to the conference.", e);
            } finally {
                connectionsResults.add(CompletableFuture.runAsync(() -> user.joinConference(conference), usersPool));
            }
        });

        CompletableFuture.allOf(connectionsResults.toArray(new CompletableFuture[0])).join();

        log.info("All users connected to the " + conference.getTheme() + " conference.");
        conference.showParticipants();

        usersPool.shutdown();
    }
}
