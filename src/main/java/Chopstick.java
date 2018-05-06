public class Chopstick {
    private String name;
    private boolean isBeingUsed;

    public Chopstick(String name) {
        this.name = name;
        isBeingUsed = false;
    }

    public synchronized void take() {
        System.out.printf("Chopstick %s taken", this.name);
        isBeingUsed = true;
    }

    public synchronized void release() {
        System.out.printf("Chopstick %s is released", this.name);
        isBeingUsed = false;
    }

    public synchronized boolean isUsed() {
        return isBeingUsed;
    }
}
