package Supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Player {
    private String name;

    public void startBattle(@NonNull Boss boss, Player player) {
        try {
            boss.joinBattle(player);
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
        }
    }
}
