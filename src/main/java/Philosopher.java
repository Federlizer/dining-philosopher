import java.util.Random;

public class Philosopher implements Runnable {

    private String name;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;

    public Philosopher(String name, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.name = name;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    private void eat() {
        try {
            System.out.println(name + " Eating");
            Thread.sleep(new Random().nextInt(10) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            int leftId = leftChopstick.getId();
            int rightId = rightChopstick.getId();

            if (leftId < rightId) {
                System.out.println(name + " - waiting to get left chopstick");
                leftChopstick.take();
                System.out.println(name + " - got left chopstick");
                System.out.println(name + " - waiting to get right chopstick");
                rightChopstick.take();
                System.out.println(name + " - got right chopstick");
            }
            else {
                System.out.println(name + " - waiting to get right chopstick");
                rightChopstick.take();
                System.out.println(name + " - got right chopstick");
                System.out.println(name + " - waiting to get left chopstick");
                leftChopstick.take();
                System.out.println(name + " - got left chopstick");
            }
            eat();

            System.out.println(name + " - releasing both chopsticks");
            leftChopstick.release();
            rightChopstick.release();
        }
    }
}
