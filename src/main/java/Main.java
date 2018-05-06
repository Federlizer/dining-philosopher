public class Main {
    public static void main(String[] args) {
        Chopstick[] chopsticks = new Chopstick[5];
        Philosopher[] philosophers = new Philosopher[5];

        for (int i = 1; i <= 5; i++) {
            Chopstick c = new Chopstick(i);
            chopsticks[i-1] = c;
        }

        philosophers[0] = new Philosopher("P 1", chopsticks[0], chopsticks[4]);
        philosophers[1] = new Philosopher("P 2", chopsticks[1], chopsticks[0]);
        philosophers[2] = new Philosopher("P 3", chopsticks[2], chopsticks[1]);
        philosophers[3] = new Philosopher("P 4", chopsticks[3], chopsticks[2]);
        philosophers[4] = new Philosopher("P 5", chopsticks[4], chopsticks[3]);

        for (Philosopher philosopher : philosophers) {
            Thread t = new Thread(philosopher);
            t.start();
        }
    }
}
