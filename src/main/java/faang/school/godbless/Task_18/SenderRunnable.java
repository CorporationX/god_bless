package faang.school.godbless.Task_18;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        System.out.println("Bunch of letters from " + startIndex + " to " + endIndex + " are send!");
    }
}
