package derschrank.sprint03.task10.bjstwo_48849;

public interface HouseInterface {
    Role getRole(User user);

    Role releaseRole(User user);

    int getAvailableRoleCount();
}
