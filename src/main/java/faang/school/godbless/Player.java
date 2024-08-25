package faang.school.godbless;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final BluetoothPlayer lock ;
    private Boolean isPlaying = false;
    public void play(){
        synchronized (lock) {
            isPlaying = true;
            lock.play(isPlaying);
        }
    }
    public void pause(){
        synchronized (lock) {
            isPlaying = false;
            lock.pause(isPlaying);
        }
    }
    public void skip(){
        synchronized (lock){
            lock.skip(isPlaying);
        }
    }
    public void previous(){
        synchronized (lock){
            lock.previous(isPlaying);
        }
    }

}
