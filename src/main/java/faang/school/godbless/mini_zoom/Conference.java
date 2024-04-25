package faang.school.godbless.mini_zoom;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
@Slf4j
public class Conference {
    private int totalMembers;
    private List<Participant> participants;
    private boolean isStreaming;
    private CountDownLatch countDownLatch;

    public Conference(int totalMembers) {
        this.totalMembers = totalMembers;
        this.participants = new ArrayList<>();
        this.countDownLatch = new CountDownLatch(totalMembers);
    }

    public void startStreaming() {
        log.info("The conference has begun!");
    }

    public void endStreaming() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        participants = new ArrayList<>();
        log.info("The conference has finished!");
    }

    public void addParticipant(Participant participant) {
        synchronized (participants) {
            if (!isStreaming) {
                participants.add(participant);
                countDownLatch.countDown();
                if (countDownLatch.getCount() == 0) {
                    isStreaming = true;
                    ExecutorService executorService = Executors.newFixedThreadPool(participants.size());
                    List<CompletableFuture<Void>> futures = new ArrayList<>();
                    futures.add(CompletableFuture.runAsync(() -> participants.forEach(Participant::joinConference), executorService));
                    futures.forEach(CompletableFuture::join);
                    startStreaming();
                    executorService.shutdown();
                }
            } else {
                log.info("The conference is full");
            }
        }
    }
}
