package school.faang.bjs2_90409;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TamagotchiVlad {
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
    private final int ACTION_DURATION = 7000;
    private String name;
    private final Object lock = new Object();
    private boolean isReplete;
    private boolean isTired;
    private boolean isClean;
    private boolean isRested;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public void feed() {
        synchronized (lock) {
            try {
                System.out.printf("%s кушает.%n", name);
                Thread.sleep(ACTION_DURATION);
                setReplete(true);
                setClean(false);
                System.out.printf("%s наелся. Теперь он хочет, чтобы его почистили.%n", name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("%s не успел доесть.%n", name);
            }
        }
    }

    public void play() {
        synchronized (lock) {
            try {
                System.out.printf("%s играет.%n", name);
                Thread.sleep(ACTION_DURATION);
                setTired(true);
                setRested(false);
                System.out.printf("%s наигрался, он хочет спать.%n", name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("%s не наигрался, он хочет еще.%n", name);
            }
        }
    }

    public void clean() {
        synchronized (lock) {
            try {
                System.out.printf("%s чистится.%n", name);
                Thread.sleep(ACTION_DURATION);
                setClean(true);
                setTired(false);
                System.out.printf("%s вычистился до блеска, он хочет поиграть.%n", name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("%s прервали, когда он чистился.%n", name);
            }
        }
    }

    public void sleep() {
        synchronized (lock) {
            try {
                System.out.printf("%s спит.%n", name);
                Thread.sleep(ACTION_DURATION);
                setRested(true);
                setReplete(false);
                System.out.printf("%s только проснулся, он хочет кушать.%n", name);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("%s не выспался, его разбудили раньше времени.%n", name);
            }
        }
    }
}
