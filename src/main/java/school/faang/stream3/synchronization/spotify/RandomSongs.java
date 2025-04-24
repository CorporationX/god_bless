package school.faang.stream3.synchronization.spotify;

import java.util.LinkedList;

public class RandomSongs {
    LinkedList<Song> playList = new LinkedList<>();

    public RandomSongs(int playListSize) {
        for (int i = 0; i < playListSize; i++) {
            playList.add(new Song());
        }
    }
}
