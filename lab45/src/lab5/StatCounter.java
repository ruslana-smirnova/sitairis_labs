package lab5;

class StatCounter {
    private static StatCounter instance;

    private int storeCount = 0;
    private int brandCount = 0;

    // Приватный конструктор для Singleton
    private StatCounter() {
    }

    public static synchronized StatCounter getInstance() {
        if (instance == null) {
            instance = new StatCounter();
        }
        return instance;
    }

    public void incrementStoreCount() {
        storeCount++;
    }

    public void incrementBrandCount() {
        brandCount++;
    }

    public void displayStatistics() {
        System.out.println("Количество магазинов: " + storeCount);
        System.out.println("Количество брендов: " + brandCount);
    }
}
