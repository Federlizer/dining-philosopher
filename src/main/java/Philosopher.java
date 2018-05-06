public class Philosopher implements Runnable {

    private String name;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private State state;

    public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.name = name;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.state = State.THINKING;
    }

    private void eat() {
        this.state = State.EATING;
    }

    private void think() {
        while(leftChopstick.isUsed() || rightChopstick.isUsed()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

    }
}
