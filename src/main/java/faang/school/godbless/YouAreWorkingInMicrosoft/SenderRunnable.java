package faang.school.godbless.YouAreWorkingInMicrosoft;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.IntStream;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex,endIndex)
                .forEach(i -> System.out.println("Letter number " + i + "sent by tread: "
                        + Thread.currentThread().getName()));
    }
}
