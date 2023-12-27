package Synchronization_1;

public class Player {

    private int isPlaying = 0;
    private String[] lock = {"Rise, Rise", "Mann Gegen Mann", "Klavier", "Benzin"};

    public void play() {
        synchronized (lock) {
            if (isPlaying < 4)
                System.out.println("Play track " + lock[isPlaying]);
            else
                System.out.println("Want you refresh list of tracks?");
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying < 4)
                System.out.println("Pause track " + lock[isPlaying]);
            else
                System.out.println("Want you refresh list of tracks?");
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying < 3)
                isPlaying++;
            else
                isPlaying = 0;
            System.out.println("Next track is " + lock[isPlaying]);
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying < 4)
                System.out.println("Track of Germany music group 'Rammstein' " + lock[isPlaying]);
            else
                System.out.println("Want you refresh list of tracks?");
        }
    }

}
