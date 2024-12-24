package school.faang.sprint_4.task_50611;

import lombok.NonNull;

public record Kingdom(@NonNull String name) {
    private static final double SUCCESSFUL_SEND_RATE = 0.8;

    public String sendMessage(Kingdom receiver) {
        if (Math.random() < SUCCESSFUL_SEND_RATE) {
            return "Message from " + name + " to " + receiver.name() + " sent";
        } else {
            throw new RuntimeException("Send failed");
        }
    }
}
