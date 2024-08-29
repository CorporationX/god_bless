package faang.school.godbless.celeba;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account) {
        try {
            Thread.sleep(2000);//проверка на многопоточность(все выполняется за 2 с)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        account.addFollowers(1);
    }
}
