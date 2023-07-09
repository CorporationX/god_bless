package faang.school.godbless.sprint_3.multithreading.super_cow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                System.out.printf("%s присоединяется к битве!%n", player.getName());
            } else {
                System.out.println("Сейчас нету свободных слотов....");
                this.wait();
                System.out.println("Появился свободный слот");
            }
        }
    }

    public void leaveFight() {
        synchronized (this) {
            currentPlayers--;
            this.notify();
        }
    }
}
