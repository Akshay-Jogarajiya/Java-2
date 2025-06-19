public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread thread1 = new Thread( () -> {
           for (int i = 0; i < 1000; i++) {
               c.increment();
           }
        });

        Thread thread2 = new Thread( () -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(c.count);
    }
}
class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}