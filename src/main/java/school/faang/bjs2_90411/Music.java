package school.faang.bjs2_90411;

public class Music {
    public static void main(String [] args) {
        Player player = new Player();

        Thread [] exampleThreads = {
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        };

        for (Thread thread : exampleThreads) {
            thread.start();
        }

    }
}
