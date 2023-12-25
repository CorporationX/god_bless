package faang.school.godbless.BroForce;

import lombok.Getter;

@Getter
public class Game {
    private int score;      // счётчик набранных очков за игру всеми участниками
    private int lives;      // количество потерянных всеми участниками жизней
    private Object lockScore = new Object();
    private Object lockLives = new Object();

     public void update(){
         synchronized (lockScore){

         }
         synchronized (lockLives){

         }

    }

}
