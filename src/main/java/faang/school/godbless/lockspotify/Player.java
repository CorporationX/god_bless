import lombok.SneakyThrows;

public class Player {
    private final String lock="Lock";
    private boolean isPlaying;

    @SneakyThrows
    public void play(){
        synchronized (lock){
            Thread.sleep(1000);
            System.out.println("Включили трек");
            isPlaying = true;
        }
    }

    @SneakyThrows
    public void pause(){
        synchronized (lock){
            Thread.sleep(1000);
            System.out.println("Поставили трек на паузу");
            isPlaying = false;
        }
    }

    @SneakyThrows
    public void skip(){
        synchronized (lock){
            Thread.sleep(1000);
            System.out.println("Следующий трек");
            isPlaying = true;
        }
    }

    @SneakyThrows
    public void previous(){
        synchronized (lock){
            Thread.sleep(1000);
            System.out.println("Предыдущий трек");
            isPlaying = true;
        }
    }
}
