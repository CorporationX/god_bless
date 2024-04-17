package faang.school.godbless.theywereverynice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;

    public void run(){
        System.out.println("Execute task: " + chore + " in " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
