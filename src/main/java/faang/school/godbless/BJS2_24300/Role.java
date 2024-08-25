package faang.school.godbless.BJS2_24300;

public enum Role {
    KNIGHT(2), MAGE(2), LORD(1), TECH_LEAD(3);

    private int maxCount;
    private int countAvailable;

    Role(int maxCount) {
        this.maxCount = maxCount;
        this.countAvailable = maxCount;
    }

    public synchronized void takeRole() {
        while (countAvailable == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        countAvailable--;
    }

    public synchronized void releaseRole() {
        countAvailable++;
        notifyAll();
    }
}