package faang.school.godbless;

record ResourceRequest(double load) {
    ResourceRequest(double load) {
        if (load < 0) load = 0;
        this.load = load;
    }
}
