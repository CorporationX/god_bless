package faang.school.godbless.spotify;


//я решил убрать объект лок, чтобы не писать много кода и не порождать лишних сущностей,
//я могу так сделать, потому что в качестве лока у меня выступает объект this.
public class Player {
    private boolean isPlaying = false;

    public synchronized void play() {
        if (isPlaying){
            System.out.println("музыка и так играет");
        } else {
            System.out.println("музыка включена " + Thread.currentThread().getName());
            isPlaying = true;
        }
    }

    public synchronized void pause() {
        if (!isPlaying){
            System.out.println("музыка и так не играет");
        } else {
            System.out.println("музыка выключена " + Thread.currentThread().getName());
            isPlaying = false;
        }
    }

    public synchronized void skip() {
        System.out.println("музыка переключена далее " + Thread.currentThread().getName());
    }

    public synchronized void previous() {
        System.out.println("музыка переключена назад " + Thread.currentThread().getName());
    }
}
