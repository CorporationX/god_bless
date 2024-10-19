package mod1sp3.tamagotchiVlad;

public class TamagotchiVlad {
    private static int globalIndex = 0;
    private final int index;
    private boolean isFeed = false;
    private boolean isPlay = false;
    private boolean isClean = false;
    private boolean isSleep = false;

    public TamagotchiVlad() {
        ++globalIndex;
        index = globalIndex;
    }

    public synchronized void feed() {
        isFeed = true;
        System.out.println("Влад ест!");
    }

    public synchronized void play() {
        isPlay = true;
        System.out.println("Влад играет!");
    }

    public synchronized void clean() {
        isClean = true;
        System.out.println("Влад моется!");
    }

    public synchronized void sleep() {
        isSleep = true;
        System.out.println("Влад спит!");
    }

    public synchronized void updateStatus() {
        if (isFeed) {
            System.out.println("Влад-" + index + " - сыт");
        } else {
            System.out.println("Влад-"  + index + " - голоден");
        }
        if (isSleep) {
            System.out.println("Влад-"  + index + " - выспался");
        } else {
            System.out.println("Влад-"  + index + " - устал");
        }
        if (isClean) {
            System.out.println("Влад-"  + index + " - чистый");
        } else {
            System.out.println("Влад-"  + index + " - грязный");
        }
        if (isPlay) {
            System.out.println("Влад-"  + index + " - наигрался");
        } else {
            System.out.println("Влад-"  + index + " - хочет играть");
        }
    }
}
