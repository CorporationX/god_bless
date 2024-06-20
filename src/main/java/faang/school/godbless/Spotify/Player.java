package faang.school.godbless.Spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play(){
        synchronized (lock){
            if(!isPlaying){
                isPlaying = true;
                System.out.println("123грает музика");
            }
            else {
                System.out.println("Music is already playing");
            }
        }
    }

    public void pause(){
        synchronized (lock){
            if(isPlaying){
                isPlaying = false;
                System.out.println("Музыка поставленна на паузу");
            }
            else {
                System.out.println("уже поставленно на паузу");
            }
        }
    }

    public void skip(){
        synchronized (lock){
            if(isPlaying){
                System.out.println("Переключили на другой трек");
            }
            else {
                System.out.println("Музыка не воспроизводится, низя на другой трек");
            }
        }
    }

    public void previous(){
        synchronized (lock){
            if(isPlaying){
                System.out.println("Переключились на предыдущий трек");
            }
            else {
                System.out.println("Не получается воспроизвести предыдущее видео");
            }
        }
    }
}
