package school.faang.sprint3.supercow;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {

    public final Integer maxPlayers;
    private Integer currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        if (maxPlayers.equals(currentPlayers)) {
            System.out.printf("Достигнуто максимальное количество %d. Режим ожидания для %s.\n",
                    maxPlayers, player.getName());
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("Ошибка прерывания ожидания %s\n", e.getMessage());
            }
        }
        System.out.printf("К бою %s! Текущее состояние %d \n", player.getName(), ++currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        this.notify();
        System.out.printf("Игрок %s покинул бой. Текущее состояние %d \n", player.getName(), --currentPlayers);
    }

}
