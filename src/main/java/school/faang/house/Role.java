package school.faang.house;

public enum Role {
    DRAGON(1),
    MAGE(1),
    MEMBER(2);

    private final int maxMembers;

    Role(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public int getMaxMembers() {
        return maxMembers;
    }
}
