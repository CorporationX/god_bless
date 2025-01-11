package derschrank.sprint04.task23.bjstwo_51054;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final String SPLITTER = "\n----------------------------------\n";
    private static final int COUNT_OF_BASE = 5;
    private static final int COUNT_OF_TRANSMISSION = 5;
    private static final int TIME_BETWEEN_MESSAGES_MILLIS = 300;
    private static List<CompletableFuture<Void>> futuresBases;

    public static void main(String[] args) {
        List<Base> bases = generateBase(COUNT_OF_BASE);

        startBases(bases);

        transmitMessage(bases);

        stopBases(bases);
    }

    private static List<Base> generateBase(int count) {
        List<Base> bases = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bases.add(new MilitaryBase("MilitaryBase #" + i));
        }
        return bases;
    }

    private static void startBases(List<Base> bases) {
        futuresBases = bases.stream()
                .map(CompletableFuture::runAsync)
                .toList();
    }

    private static void transmitMessage(List<Base> bases) {
        System.out.println(SPLITTER + "TRANSMITTING MESSAGES: BEGIN" + SPLITTER);
        int count = 0;
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (int i = 0; i < COUNT_OF_TRANSMISSION; i++) {
            for (Base baseFrom : bases) {
                for (Base baseTo : bases) {
                    if (baseFrom == baseTo) {
                        continue;
                    }
                    futures.add(
                            sendMessageInThread(
                                    baseFrom,
                                    baseTo,
                                    String.format("Super Message #%d-%d, to base: %s", i, ++count, baseTo)
                            )
                    );
                    doSleep(TIME_BETWEEN_MESSAGES_MILLIS);
                }
            }
        }
        futures.forEach(CompletableFuture::join);
        System.out.println(SPLITTER + "TRANSMITTING MESSAGES: ENDED" + SPLITTER);
    }

    private static CompletableFuture<Void> sendMessageInThread(Base from, Base to, String msg) {
        return CompletableFuture.runAsync(
                () -> from.sendMessage(to, msg)
        );
    }

    private static void stopBases(List<Base> bases) {
        bases.forEach(Base::stop);
        futuresBases.forEach(CompletableFuture::join);
    }

    private static void doSleep(int delayMillis) {
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            System.out.println("Main was interrupted: " + e);
            ;
        }
    }
}
