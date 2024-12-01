package school.faang.bjs2_37212;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player player = new Player("Player1", 3, 4, 9);

        List<Npc> npcList = new ArrayList<>();

        Npc npc = new Npc("NPC #1",5);
        Npc npc2 = new Npc("NPC #2",5);
        Npc npc3 = new Npc("NPC #3",10);
        Npc npc4 = new Npc("NPC #4",12);
        Npc npc5 = new Npc("NPC #5",14);

        npcList.add(npc);
        npcList.add(npc2);
        npcList.add(npc3);
        npcList.add(npc4);
        npcList.add(npc5);

        Game game = new Game(npcList, player);
        game.fight();
    }
}
