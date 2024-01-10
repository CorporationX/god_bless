package faang.school.godbless.AsynchronyAndFuture;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Card card = new Card();
        card.doAll();
    }
}
