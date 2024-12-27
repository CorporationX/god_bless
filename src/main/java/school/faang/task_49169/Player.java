package school.faang.task_49169;

class Player {
    private final Object lock = new Object();

    private boolean isPlaying = false;

    private void changeState(boolean newState, String actionMessage, String alreadyMessage) {
        synchronized (lock) {
            if (isPlaying != newState) {
                isPlaying = newState;
                System.out.println(actionMessage);
            } else {
                System.out.println(alreadyMessage);
            }
        }
    }

    public void play() {
        changeState(true, "Music is playing!", "The music is already playing!");
    }

    public void pause() {
        changeState(false, "Music paused!", "The music is already on pause!");
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Track missed!");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Back to the previous track!");
        }
    }
}