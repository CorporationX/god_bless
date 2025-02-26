package school.faang.task61978;

import school.faang.task61978.service.Music;

public class Main {
    public static void main(String[] args) {
        Music music = new Music();
        music.simulatePlayer();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
