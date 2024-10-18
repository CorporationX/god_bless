package school.faang.Multithreading.sprint_3.Supercow;

import lombok.Getter;

@Getter
public class Player {
    private final String name;

    public Player(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("У игрока должно быть имя");
        }

        this.name = name;
    }

    public void startBattle(Boss boss){
           boss.joinBattle(this);

           try {
               Thread.sleep(1000 * 3);
           } catch (InterruptedException e) {
               System.out.println("Операция была прервана " + e.getMessage());
               e.printStackTrace();
           }

           boss.leaveBattle(this);
    }
}