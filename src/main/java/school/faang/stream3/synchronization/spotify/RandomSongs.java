package school.faang.stream3.synchronization.spotify;

import java.util.LinkedList;

public class RandomSongs {
    LinkedList<Song> playList;

    public RandomSongs(int playListSize) {
        for (int i = 0; i < playListSize; i++) {
            playList.add(new Song());
        }
    }

    public void showNextSongs(int amount, int positionPlaying) {
        for (int i = positionPlaying; i < amount; i++) {
            if (i == positionPlaying) {
                System.out.println(playList.get(i) + "is playing now");
            }
            else {
                System.out.println(playList.get(i));
            }
        }
    }
}
