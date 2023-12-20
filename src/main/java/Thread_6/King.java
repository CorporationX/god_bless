package Thread_6;

import java.util.concurrent.ExecutorService;

public class King {
    public static void main(String[] args) {
        Knight johnKnight = new Knight("Ivan Snow");
        Knight defaultKnight = new Knight("Ivan Ivanov");
        Trial trialJohnFirst = new Trial(johnKnight.getName(), "Kill blonde woman");
        Trial trialJohnSecond = new Trial(johnKnight.getName(), "Kill dragon");
        Trial trialDefaultFirst = new Trial(defaultKnight.getName(), "Change name");
        Trial trialDefaultSecond = new Trial(defaultKnight.getName(), "Change surname");
        johnKnight.addTrial(trialJohnFirst);
        johnKnight.addTrial(trialJohnSecond);
        defaultKnight.addTrial(trialDefaultFirst);
        defaultKnight.addTrial(trialDefaultSecond);

        ExecutorService executorService1 = johnKnight.startTrials();
        ExecutorService executorService2 = defaultKnight.startTrials();

        while (!executorService1.isTerminated() || !executorService2.isTerminated()) {
            executorService1.shutdown();
            executorService2.shutdown();
        }

        System.out.println("All knights done your trials");
    }
}
