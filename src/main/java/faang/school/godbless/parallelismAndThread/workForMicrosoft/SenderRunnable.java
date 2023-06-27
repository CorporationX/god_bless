package faang.school.godbless.parallelismAndThread.workForMicrosoft;

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
        //Упражняюсь в стримах :)
        IntStream.rangeClosed(startIndex, endIndex).forEach(number -> System.out.println("Письмо №" + number + " успешно отправлено!"));
    }
}
