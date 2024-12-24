package school.faang.task_50704;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount tailorSwift = new TwitterAccount("tailorpfficial", 100);
        TwitterAccount timothyShalomet = new TwitterAccount("shalometTim", 200);

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<CompletableFuture<TwitterAccount>> TailorFollowers = Arrays.asList(
                system.followAccount(tailorSwift),
                system.followAccount(tailorSwift)
        );

        List<CompletableFuture<TwitterAccount>> TimothyFollowers = Arrays.asList(
                system.followAccount(timothyShalomet),
                system.followAccount(timothyShalomet),
                system.followAccount(timothyShalomet)
        );

        CompletableFuture<Void> allTailorFollowers
                = CompletableFuture.allOf(TailorFollowers.stream().toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    try {
                        system.shutdownExecutor();
                        System.out.println("Всего фолловеров у Tailor " + tailorSwift.getFollowers());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        CompletableFuture<Void> allTimothyFollowers
                = CompletableFuture.allOf(TimothyFollowers.stream().toArray(CompletableFuture[]::new))
                .thenRun(() -> {
                    try {
                        system.shutdownExecutor();
                        System.out.println("Всего фолловеров у Tailor " + timothyShalomet.getFollowers());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
