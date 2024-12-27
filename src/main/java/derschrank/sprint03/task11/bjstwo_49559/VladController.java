package derschrank.sprint03.task11.bjstwo_49559;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class VladController {
    private final List<TamagotchiInterface> tamos;

    public VladController() {
        tamos = new ArrayList<>();
    }

    public void addTamo(TamagotchiInterface tamo) {
        synchronized (tamos) {
            tamos.add(tamo);
            printMsg(tamo, "added in list");
        }
    }

    public void removeTamo(TamagotchiInterface tamo) {
        synchronized (tamos) {
            tamos.remove(tamo);
            printMsg(tamo, "removed from list");
        }
    }

    public void feedAll() {
        doActionForAll(TamagotchiInterface::feed);
    }

    public void playAll() {
        doActionForAll(TamagotchiInterface::play);
    }

    public void cleanAll() {
        doActionForAll(TamagotchiInterface::clean);
    }

    public void sleepAll() {
        doActionForAll(TamagotchiInterface::sleep);
    }

    public void statusAll() {
        doActionForAll(TamagotchiInterface::status);
    }

    private synchronized void doActionForAll(Consumer<TamagotchiInterface> action) {
        synchronized (tamos) {
            for (TamagotchiInterface tamo : tamos) {
                action.accept(tamo);
            }
        }
    }

    private void printMsg(TamagotchiInterface tamo, String msg) {
        System.out.printf("%s -> Tamo %s was %s%n",
                Thread.currentThread().getName(),
                tamo,
                msg);
    }

}
