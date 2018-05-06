import java.util.concurrent.Semaphore;

public class Chopstick {
    private Semaphore semaphore;

    private int id;

    public Chopstick(int id) {
        this.id = id;

        this.semaphore = new Semaphore(1);
    }

    public int getId() {
        return this.id;
    }

    public void take() {
        try {
            semaphore.acquire();
            System.out.printf("Chopstick %d is taken\n", id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        System.out.printf("Chopstick %d is released\n", id);
        semaphore.release();
    }
}
