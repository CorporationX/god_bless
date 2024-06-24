package BJS2_12016;

record Location(int x, int y) {
    public int distanceTo(Location other) {
        return (int) Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}