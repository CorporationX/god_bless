package BJS2_25537_MiniZoom;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Conference conference = new Conference();

        List<Participant> participants = Arrays.asList(new Participant("Nagibator2001"),
                new Participant("Ubivashka"), new Participant("babka_B_KEDAX_23_RUS"),
                new Participant("ololoshka"), new Participant("Destroyer2012"),
                new Participant("Final_Boss_Helicopter"));

        for (int i = 0; i < participants.size(); i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep((finalI + 1) * 1000L);
                } catch (InterruptedException e) {
                    log.error("Thread was interrupted!", e);
                    Thread.currentThread().interrupt();
                }
                participants.get(finalI).joinConference(conference);
            });
            thread.start();
        }
    }
}
