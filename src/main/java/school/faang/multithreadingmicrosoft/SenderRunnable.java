package school.faang.multithreadingmicrosoft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.stream.IntStream;

@Getter
@Setter
@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(i -> System.out.println("Mail sent: " + i));
    }
}
