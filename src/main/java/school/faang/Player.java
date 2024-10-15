package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int timeOfBeingInBattle = 700;

    public Player(String name) {
        this.name = name;
    }

    public void startBattle(Boss boss) throws InterruptedException {
        synchronized (boss) {

            //делаем попытку агрить босса на игрока
            System.out.println(this.name + " пытается агрить босса");
            boss.joinBattle(this);

            //останавливаем поток на заданное время, типа игрок ведет битву,
            //и на это время разблокируем доступ к боссу,
            //чтобы другие игроки могли проверять, не освободился ли слот
            boss.wait(timeOfBeingInBattle);

            //время нахождения в битве закочилось
            //сообщаем, что игрок погиб и освобождаем слот
            System.out.println(this.name + " расчленен и выпотрошен");
            int quantityOfPlayersInDungeon = boss.getCurrentPlayers();
            quantityOfPlayersInDungeon --;
            boss.setCurrentPlayers(quantityOfPlayersInDungeon);

            //место освободилось, сообщаем об этом сразу всем игрокам в очереди
            boss.notifyAll();
        }
    }

}
