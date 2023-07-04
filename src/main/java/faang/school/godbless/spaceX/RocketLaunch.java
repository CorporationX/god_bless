package faang.school.godbless.spaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class RocketLaunch implements Runnable{
    @NonNull
    private String name;
    private long time;

    @Override
    public void run() {
            try {
                Thread.sleep(time - new Date().getTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            launch();
    }

    public synchronized void launch(){
        System.out.println("Подготовка запуска" + name);
        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("Запуск ракеты " + name + " произведён!");
    }
}
