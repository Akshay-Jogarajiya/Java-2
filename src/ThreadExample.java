public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Workers w1 = new Workers();
        Workers w2 = new Workers();
        w1.start();
        w1.join();
        w2.start();
    }
}
class Workers extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Finished :" +Thread.currentThread().getName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}