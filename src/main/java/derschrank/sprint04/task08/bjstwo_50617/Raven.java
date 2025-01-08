package derschrank.sprint04.task08.bjstwo_50617;

import java.util.Random;

public record Raven(
        TypeMsg type,
        String msg,
        Kingdom sender,
        Kingdom receiver
) {
    private static final int DELAY_ROAD_TIME_MILLIS = 1000;
    private static final int PROCENT_OF_FAILURE_OF_RAVEN = 30;
    private static final Random rnd = Utils.RANDOM;

    public Raven(String msg, Kingdom sender, Kingdom receiver) {
        this(TypeMsg.NEW_MSG, msg, sender, receiver);
    }

    public Raven(TypeMsg typeOfAnswer, Raven answerToRaven) {
        this(typeOfAnswer, "Confirmation or other service message", answerToRaven.receiver, answerToRaven.sender);
    }

    public Raven send() {
        Utils.doSleepForCurrentThread(DELAY_ROAD_TIME_MILLIS);
        Utils.makeRandomTimeException(rnd, PROCENT_OF_FAILURE_OF_RAVEN);

        Raven ravenWithAnswer = receiver.receiveRaven(this);
        Utils.makeRandomTimeException(rnd, PROCENT_OF_FAILURE_OF_RAVEN);
        return ravenWithAnswer;
    }
}
