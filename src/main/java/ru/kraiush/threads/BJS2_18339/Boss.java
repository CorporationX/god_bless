package ru.kraiush.threads.BJS2_18339;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Boss {

    private String name;
    private int maxPlayers;
    private List<Player> currentPlayers;

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    public  synchronized void joinBattle(Player player) {

        if (maxPlayers == currentPlayers.size()) {


        } else {
            currentPlayers.add(player);
        }
    })
}
