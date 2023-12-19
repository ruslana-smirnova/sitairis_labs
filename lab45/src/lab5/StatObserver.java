package lab5;

class StatObserver implements Observer {
    private StatCounter statisticsCounter;

    public StatObserver() {
        this.statisticsCounter = StatCounter.getInstance();
    }

    @Override
    public void update(String event) {
        if ("store".equals(event)) {
            statisticsCounter.incrementStoreCount();
        } else if ("brand".equals(event)) {
            statisticsCounter.incrementBrandCount();
        }
    }
}
