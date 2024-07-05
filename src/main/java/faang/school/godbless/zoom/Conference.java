package faang.school.godbless.zoom;

import lombok.Getter;

import java.util.concurrent.CyclicBarrier;

public class Conference {
    private final int quantityPraticipant;
    private final String aboutTheConference;
    @Getter
    private final CyclicBarrier barrier;

    public Conference(int quantity, String aboutTheConference) {
        if (quantity <= 1) {
            throw new IllegalArgumentException(
                    "In constructor Conference class apply int quantity <= 1, it is impossible to meet with one or less people");
        }
        if (aboutTheConference == null) {
            throw new IllegalArgumentException("In constructor Conference class apply String aboutTheConference is null");
        }
        this.quantityPraticipant = quantity;
        this.aboutTheConference = aboutTheConference;
        barrier = new CyclicBarrier(quantity);
    }

    public void startStreaming() {
        System.out.println("Translation begin!");
    }
}
