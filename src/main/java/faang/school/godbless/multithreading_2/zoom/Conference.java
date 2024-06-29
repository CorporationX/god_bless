package faang.school.godbless.multithreading_2.zoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Conference {
    private String name;
    private int amount;
    private final CyclicBarrier BARRIER;
    private final List<Participant> participants = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public Conference(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.BARRIER = new CyclicBarrier(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conference that = (Conference) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void startStreaming() {
        System.out.println("Трансляция началась");
    }

    public void join(Participant participant) {
        try {
            BARRIER.await();
            lock.lock();
            participants.add(participant);
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void showParticipants() {
        lock.lock();
        System.out.println("Список участников");
        participants.forEach(participant -> System.out.println("\t" + participant.name()));
        lock.unlock();
    }
}
