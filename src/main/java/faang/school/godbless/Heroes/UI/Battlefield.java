package faang.school.godbless.Heroes.UI;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Battlefield {

    private Hero player1;
    private Hero player2;


    public void battle(){
        if (player1.summaryPower() > player2.summaryPower()){
            System.out.println(player1.getName() + " is winner!!!");
        }else if (player1.summaryPower() < player2.summaryPower()){
            System.out.println(player2.getName() + " is winner!!!");
        }else{
            System.out.println("draw");
        }
    }

}
