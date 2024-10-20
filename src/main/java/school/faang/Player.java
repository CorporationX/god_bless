package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;

   public void startBattle(Boss boss){
       boss.joinBattle(this);
//       System.out.println(name+"come in");
       try {
           Thread.sleep(500);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       boss.leaveBattle(this);
   }
}
