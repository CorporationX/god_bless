package faang.school.godbless.Heroes.UI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;


@AllArgsConstructor
@Getter
@Setter
public class Battlefield {
    private static final int DRAW = 0;
    private static final int PLAYER1_WIN = 1;
    private static final int PLAYER2_WIN = 2;
    private static final int GAME_CONTINUE = 3;


    private Hero player1;
    private Hero player2;

    public int battle(){
        boolean isPlayer1Attack = true;
        while(isWin()==3){
            if (isPlayer1Attack){
                player1.attack(player2);
            }else {
                player2.attack(player1);
            }
        }
        return isWin();
    }


    private int isWin(){
        if (player1.getArmy().isEmpty()){
            if (player2.getArmy().isEmpty()){
                return DRAW;
            }
            return PLAYER2_WIN;
        } else if (player2.getArmy().isEmpty()) {
            return PLAYER1_WIN;
        } else {
            return GAME_CONTINUE;
        }
    }

    private void printWinner(int index){
        if (index == 1){
            System.out.println(player1.getName() + " is winner!!!");
        } else if (index == 2) {
            System.out.println(player2.getName() + " is winner!!!");
        } else if (index == 3){
            System.out.println("draw");
        } else {
            throw new IllegalArgumentException("в функции Battlefield.printWinner" +
                    " аргументами могут быть только числа 1, 2, 3 ");
        }
    }

}
