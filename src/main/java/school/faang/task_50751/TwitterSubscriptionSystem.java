package school.faang.task_50751;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    private CompletableFuture<TwitterAccount> addFollower(TwitterAccount account, User user) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(String.format("Begin of adding user %s to account %s...",
                        user.getName(), account.getUsername()));
                Thread.sleep(1000);
                account.addUserToAccount(user);
                System.out.println(String.format("End of adding user %s add to account %s",
                        user.getName(), account.getUsername()));
                return account;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void followAccount(TwitterAccount account, List<User> usersToAdd) {
        List<CompletableFuture<TwitterAccount>> futureList = new ArrayList<>();
        usersToAdd.stream().map(user -> addFollower(account, user)).forEach(futureList::add);
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(futureList
                .toArray(new CompletableFuture[futureList.size()]));
        allTasks.join();
        System.out.println(String.format("Total amount of twitter account %s : %d", account.getUsername(),
                account.getUsers().size()));
        System.out.println(account.getUsers());
    }
}