import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockExample {
    public static void main(String[] args) {

    }
}

class Greeting {
    ReentrantLock lock =new ReentrantLock();
    public void wish(String name) {
        lock.lock();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("Hello : " + name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        lock.unlock();
    }

}

class MyThread extends Thread {
    Greeting greet;

    String name;
    MyThread(Greeting greet,String name){
        this.greet=greet;
        this.name=name;
    }
    public void run() {
        greet.wish(name);
    }
}