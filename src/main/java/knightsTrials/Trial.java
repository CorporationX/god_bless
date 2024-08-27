package knightsTrials;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class Trial {
    private String knightName;
    private String trialName;

    void run (){
        System.out.println("Рыцарь " + knightName+" выполнил испытание: " +trialName);
    }


}
