package faang.school.godbless.block_spotify;

public class Player {
    private Object track = new Object();
    private boolean isPlaying = false;

    public void play(){
        synchronized (track){
            if (!isPlaying){
                System.out.println("Трэк начал играть");
                isPlaying = true;
            }
            else {
                System.out.println("Трэк уже играет");
            }
        }
    }

    public void pause(){
        synchronized (track){
            if (isPlaying){
                System.out.println("Трэк на паузе");
                isPlaying = false;
            }
            else {
                System.out.println("Трэк ещё не играет");
            }
        }
    }

    public void skip(){
        synchronized (track){
            if (isPlaying){
                System.out.println("Переключение на следующий трэк");
            }
            else {
                System.out.println("Трэк на паузе, невозможно переключить");
            }
        }
    }

    public void previous(){
        synchronized (track){
            if (isPlaying){
                System.out.println("Переключение на предыдущий трэк");
            }
            else {
                System.out.println("Трэк на паузе, невозможно переключить");
            }
        }
    }
}

