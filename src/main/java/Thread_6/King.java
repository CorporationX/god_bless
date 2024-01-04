package Thread_6;

import java.util.concurrent.TimeUnit;

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

        johnKnight.startTrials();
        defaultKnight.startTrials();

        System.out.println("All knights done your trials");
    }
}
