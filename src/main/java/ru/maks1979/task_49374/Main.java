package ru.maks1979.task_49374;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        playThread.start();
        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();
        Thread skipThread = new Thread(player::skip);
        skipThread.start();
        Thread previosThread = new Thread(player::previous);
        previosThread.start();
    }
}
