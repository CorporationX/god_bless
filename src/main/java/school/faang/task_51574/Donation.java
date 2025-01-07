package school.faang.task_51574;


public record Donation(int id, double amount) {
    public Donation {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Donation donation)) {
            return false;
        }
        return id == donation.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}
