public class Main {
    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[5];
        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 0; i < 5; i++) {
            Chopstick c = new Chopstick("0");
            chopsticks[i] = c;
        }

        philosophers[0] = new Philosopher("P 0", chopsticks[0], chopsticks[1]);
        philosophers[1] = new Philosopher("P 1", chopsticks[1], chopsticks[2]);
        philosophers[2] = new Philosopher("P 2", chopsticks[2], chopsticks[3]);
        philosophers[3] = new Philosopher("P 3", chopsticks[3], chopsticks[4]);
        philosophers[4] = new Philosopher("P 4", chopsticks[0], chopsticks[4]);

        for (int i = 0; i < philosophers.length; i++) {
            Thread t = new Thread(philosophers[i]);
            t.start();
        }


    }
}
