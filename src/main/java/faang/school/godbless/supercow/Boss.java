package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Boss {
    private String name;
    private int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public void setCurrentPlayers(Player currentPlayers) {
        if (currentPlayers == null) {
            System.out.println("Передаваемое имя игрока имеет null");
            throw new NullPointerException();
        }
        this.currentPlayers.add(currentPlayers);
    }

    public void unJoinPlayer(Player player) {
        this.currentPlayers.remove(player);
    }
}