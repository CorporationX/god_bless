package faang.school.godbless.synchronization;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Boss {
    private Integer maxPlayers;
    private List<Players> currentPlayers;

    public Boss() {
        this.maxPlayers = 3;
        this.currentPlayers = new ArrayList<>();
    }

    @SneakyThrows
    void joinBattle(Players players){
        synchronized (currentPlayers){
            if (currentPlayers.size() >= maxPlayers){
                currentPlayers.wait(0);
            }
            currentPlayers.add(players);
            System.out.println(currentPlayers);
        }
    }

    public void endBattle(Players players){
        synchronized (currentPlayers){
            currentPlayers.remove(players);
            currentPlayers.notifyAll();
        }
    }


}
