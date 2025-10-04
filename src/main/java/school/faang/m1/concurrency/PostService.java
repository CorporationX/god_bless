package school.faang.m1.concurrency;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PostService {

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock postsLock = new ReentrantReadWriteLock();

    private final AtomicInteger idGenerator = new AtomicInteger(0);

    public Post addPost(String title, String content, String author) {
        int id = idGenerator.incrementAndGet();
        Post p = new Post(id, title, content, author);
        var w = postsLock.writeLock();
        w.lock();
        try {
            posts.put(id, p);
            return p;
        } finally {
            w.unlock();
        }
    }

    public Optional<Post> getPost(int id) {
        var r = postsLock.readLock();
        r.lock();
        try {
            return Optional.ofNullable(posts.get(id));
        } finally {
            r.unlock();
        }
    }

    public List<Post> getAllPosts() {
        var r = postsLock.readLock();
        r.lock();
        try {
            return List.copyOf(posts.values());
        } finally {
            r.unlock();
        }
    }

    /*
     читаем пост под read-lock постов, сами комментарии защищены отдельным локом внутри Post
     */
    public void addComment(int postId, Comment comment) {
        var r = postsLock.readLock();
        r.lock();
        try {
            Post p = posts.get(postId);
            if (p == null) {
                throw new NoSuchElementException("Post " + postId + " not found");
            }
            p.addComment(comment);
        } finally {
            r.unlock();
        }
    }

    public boolean deleteComment(int postId, String requestor, LocalDateTime ts, String text) {
        var r = postsLock.readLock();
        r.lock();
        try {
            Post p = posts.get(postId);
            if (p == null) {
                return false;
            }
            return p.deleteComment(requestor, ts, text);
        } finally {
            r.unlock();
        }
    }

    public boolean deletePost(int postId, String requestor) {
        var w = postsLock.writeLock();
        w.lock();
        try {
            Post p = posts.get(postId);
            if (p == null) {
                return false;
            }
            if (!p.getAuthor().equals(requestor)) {
                return false;
            }
            posts.remove(postId);
            return true;
        } finally {
            w.unlock();
        }
    }

    private static void await(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PostService service = new PostService();
        ExecutorService pool = Executors.newFixedThreadPool(Math.max(4, Runtime.getRuntime().availableProcessors()));

        List<String> users = List.of("alice", "bob", "carol", "bave");

        // create posts in parallel ..
        List<Future<Post>> created = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int idx = i;
            final String author = users.get(i % users.size());
            created.add(pool.submit(() -> service.addPost("Post " + idx, "Context of " + idx, author)));
        }

        // wait for Future results, read IDs
        List<Integer> postIds = created.stream().map(f -> {
            try {
                return f.get().getId();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();

        // write comments in parallel ... different and same posts ...
        CountDownLatch startGun = new CountDownLatch(1);
        List<Future<?>> commentTasks = new ArrayList<>();
        for (int t = 0; t < 20; t++) {
            final int ti = t;
            commentTasks.add(pool.submit(() -> {
                await(startGun);
                String author = users.get(ti % users.size());
                int postId = (ti % 2 == 0) ? postIds.get(0) : postIds.get(ti % postIds.size());
                Comment c = new Comment("Hi from " + author + " #" + ti, author, LocalDateTime.now());
                service.addComment(postId, c);
            }));
        }

        // one time start all comments
        startGun.countDown();
        for (Future<?> f : commentTasks) {
            try {
                f.get();
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // demo: remove post not author (must return false)
        int victimPost = postIds.get(1);
        boolean deletedByStranger = service.deletePost(victimPost, "mallory");
        System.out.println("Delete post# " + victimPost + " by not author, is successfully: " + deletedByStranger);

        // demo: remove post by author (true)
        service.getPost(victimPost).ifPresent(p -> {
            boolean ok = service.deletePost(p.getId(), p.getAuthor());
            System.out.println("Delete post#" + p.getId() + " by author " + p.getAuthor() + ", is successfully: " + ok);
        });

        // demo: delete comment - allowed for author
        // we search random comment and try delete
        service.getPost(postIds.get(0)).ifPresent(p -> {
            List<Comment> snap = p.getCommentsSnapshot();
            if (!snap.isEmpty()) {
                Comment target = snap.get(0);
                boolean byStranger = service.deleteComment(p.getId(),
                        "mallory", target.getTimestamp(), target.getText());
                boolean byAuthor = service.deleteComment(p.getId(), target.getAuthor(),
                        target.getTimestamp(), target.getText());
                System.out.println("Delete comment by stranger: " + byStranger + ", by author: " + byAuthor);
            }
        });

        // print final state

        System.out.println("\n === FINAL STATE ===");
        for (Post p : service.getAllPosts()) {
            System.out.println(p);
            service.getPost(p.getId()).ifPresent(pp -> {
                for (Comment c : pp.getCommentsSnapshot()) {
                    System.out.println("  - " + c);
                }
            });
        }

        pool.shutdown();
        Boolean ignored = pool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
