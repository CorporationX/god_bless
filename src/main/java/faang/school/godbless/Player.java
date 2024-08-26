package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public class Player implements Runnable{
   private Game game;
   private  String name;
   private int lives = 9;

   @Override
   public void run() {
      while (true){
         try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500,1500));
            boolean playerLostLife = ThreadLocalRandom.current().nextBoolean();
            game.update(playerLostLife,this);
            if (game.getLives()<=0){
               break;
            }
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      }
   }
}
