package school.faang_sprint_3.iron_throne_in_any_cost;

public enum Role {
    KING(true), LORD(true), KNIGHT(true), MAGE(true);

    private boolean isAvailable;

    Role(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
