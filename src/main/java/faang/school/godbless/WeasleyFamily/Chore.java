package faang.school.godbless.WeasleyFamily;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Chore implements Runnable{
    private String Chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(threadName + " был прерван при выполнении задания");
            return;
        }
        System.out.println(threadName + " завершил выполнение задания: ");
    }



}
