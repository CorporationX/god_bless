package ru.kraiush.BJS2_37298;


public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public Player() {
        this.isPlaying = false;
    }

    public void play() {
        synchronized(lock) {
            if (!this.isPlaying) {
                this.isPlaying = true;
                System.out.println("The method Play was called, the player is now playing? - " + isPlaying);
            } else {
                System.out.println("The Player is already playing? - " + isPlaying);
            }
        }
    }

    public void pause() {
        synchronized(lock) {
            if (this.isPlaying) {
                this.isPlaying = false;
                System.out.println("The method Pause was called, the player is now playing? - " + isPlaying);
            } else {
                System.out.println("The player was already paused - " + isPlaying);
            }
        }
    }

    public void skip() {
        synchronized(lock) {
            System.out.println("The method Skip was called");
        }
    }

    public void previous() {
        synchronized(lock) {
            System.out.println("The method Previous was called");
        }
    }
}
