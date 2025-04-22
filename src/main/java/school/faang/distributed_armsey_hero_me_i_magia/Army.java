package school.faang.distributed_armsey_hero_me_i_magia;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(Squad squad){
        squads.add(squad);

    }

    public int calculateSquadPower() throws InterruptedException {

        Thread[] threads = new Thread[3];
        int totalPower = 0;

//        for (Squad squad: squads) {
//            Thread thread = new Thread(() -> );
//        }

    }


}
