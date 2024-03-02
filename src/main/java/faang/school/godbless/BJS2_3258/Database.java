package faang.school.godbless.BJS2_3258;

import lombok.NonNull;

import java.util.*;

public class Database {
    private final Map<User, List<Chat>> usersChats = new HashMap<>();
    private final Queue<User> waitingQueue = new ArrayDeque<>();

    public synchronized User createUser(@NonNull String name) {
        try {
            getUser(name);
        } catch (IllegalArgumentException e) {
            User newUser = new User(name, true);
            System.out.println(Thread.currentThread().getName() + ": " + "Create: " + newUser);
            usersChats.put(newUser, new ArrayList<>());
            return newUser;
        }
        throw new IllegalArgumentException("The user already exists");
    }

    public synchronized void validateUser(@NonNull User user) {
        if (!usersChats.containsKey(user)) {
            throw new IllegalArgumentException("The user does not exist");
        }
    }

    public synchronized User getUser(@NonNull String name) {
        Optional<User> optionalUser = usersChats.keySet().stream().filter(user -> name.compareTo(user.getName()) == 0).findFirst();
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("The user does not exist");
        } else {
            return optionalUser.get();
        }
    }

    public synchronized List<User> getOnlineUsers(@NonNull User currentUser) {
        validateUser(currentUser);
        return usersChats.keySet().stream().filter(user -> user.getOnline() && user != currentUser).toList();
    }

    public synchronized List<User> getWaitingUsers() {
        return waitingQueue.stream().toList();
    }

    public synchronized List<Chat> getUserChats(@NonNull User currentUser) {
        validateUser(currentUser);
        return usersChats.get(currentUser);
    }

    public synchronized Chat createChat() {
        return new Chat();
    }

    public synchronized void joinChat(User user, Chat chat) {
        validateUser(user);
        usersChats.get(user).add(chat);
        chat.addUser(user);
        chat.sendMessage(user.getName() + " joined");
    }

    public synchronized void leaveChat(User user, Chat chat) {
        validateUser(user);
        if (usersChats.get(user).remove(chat)) {
            chat.removeUser(user);
            chat.sendMessage(user.getName() + " leaved");
        } else {
            throw new IllegalArgumentException("This chat is not in the users chats");
        }
    }


    public synchronized void addWaitingUser(@NonNull User user) {
        validateUser(user);
        waitingQueue.add(user);
        System.out.println(Thread.currentThread().getName() + ": " + "Waiting queue add: " + user);
        this.notifyAll();
    }

    public synchronized void deleteWaitingUser(@NonNull User user) {
        validateUser(user);
        if (waitingQueue.remove(user)) {
            System.out.println(Thread.currentThread().getName() + ": " + "Waiting queue delete: " + user);
        } else {
            throw new IllegalArgumentException("This user is not in the waiting queue");
        }
    }
}
