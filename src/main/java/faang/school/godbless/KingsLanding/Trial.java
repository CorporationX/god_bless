package faang.school.godbless.KingsLanding;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial{
    private String knightName;
    private String trialName;

    public void run() {
        try{
            System.out.println(knightName + " выполняет " + trialName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }






}
