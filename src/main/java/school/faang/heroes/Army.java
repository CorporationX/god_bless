package school.faang.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> warriors = new ArrayList<>();

    public void addUnit(Unit unit) {
        warriors.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<Account> accountList = new ArrayList<>();

        for (Unit unit : warriors) {
            Account account = new Account(unit);
            accountList.add(account);
            Thread thread = new Thread(account);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        for (Account account : accountList) {
            totalPower += account.getPower();
        }

        return totalPower;
    }
}
