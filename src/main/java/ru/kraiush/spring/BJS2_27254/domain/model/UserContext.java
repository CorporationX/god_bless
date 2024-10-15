package ru.kraiush.spring.BJS2_27254.domain.model;

public class UserContext {

    private final ThreadLocal<Long> userIdhHolder= new ThreadLocal<>();

    private void setUserIdHold(Long userId) {userIdhHolder.set(userId);}

    private long getUserId() { return userIdhHolder.get(); }

    private void clear() { userIdhHolder.remove();}
}
