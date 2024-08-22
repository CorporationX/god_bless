package faang.school.godbless.BJS224057;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + " выполняет работу по дому: " + chore);
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
