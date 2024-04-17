package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run(){
        System.out.println("The "+ trialName+ " is running by " + knightName);
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
