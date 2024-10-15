package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {
    private int maxPlayers = 5;
    private int currentPlayers;

    private int timeBetweenAttempts = 50;

    public synchronized void joinBattle(Player player)
                                                 throws InterruptedException {

        //вызывая этот метод, игрок пытается агрить на себя босса
        //если слоты заняты, то поток того игрока, который вызывает этот метод,
        //останавливается на заданное время и разблокирует доступ к боссу,
        //чтобы потоки других игроков могли тоже встать в очередь
        if (!(currentPlayers < maxPlayers)) {
            System.out.println("Слышь, " + player.getName() +
                    ", против босса и так сражается целая пати, " +
                    "подожди, пока он кого-то грохнет");
            this.wait(timeBetweenAttempts);

            System.out.println(player.getName() + " все-таки заагрил босса");
        }

        //а если слот есть, то поток игрока занимает его и выполняется дальше
        else {
            currentPlayers ++;
            System.out.println(player.getName() + " заагрил босса и вступил в битву");
        }
    }

}
