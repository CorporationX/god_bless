package school.faang.task_48926;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Имя потока: %s\n"
                            + "Письмо с номером: <%d> отправлено получателю!\n",
                    Thread.currentThread().getName(), i);
        }
    }
}
