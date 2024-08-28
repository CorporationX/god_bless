package faang.school.godbless.Trial;

import lombok.Getter;

@Getter
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(" Рыцарь " + knightName + " проходит испытание: " + trialName);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Испытание было прервано для рыцаря " + knightName);
        }
        System.out.println("Рыцарь " + knightName + " завершил испытание: " + trialName);
    }


}
