package faang.school.godbless.trackingsys;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public enum Status {

    FREE("free"),
    BUSY("busy");

    private static final Random RANDOM = new Random();
    private String status;

    public static Status getRandomStatus() {
        boolean isFree = RANDOM.nextBoolean();
        if (isFree) {
            return FREE;
        } else {
            return BUSY;
        }
    }
}
