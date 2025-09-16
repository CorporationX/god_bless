package school.faang.bjs2_89585;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    //Так и не нашел информацию, как можно запустить в 1 потоке run 200 раз без использования пула потоков
    //Я правильно понял, что это можно реализовать только тут? В задаче написано:
    //"...Каждый поток должен работать только со своими письмами (по 200 писем на поток)..."
    public void run() {
        for (int letter = startIndex; letter < endIndex; letter++) {
            System.out.printf("Отправлено письмо № %d%n", letter);
        }
    }
}
