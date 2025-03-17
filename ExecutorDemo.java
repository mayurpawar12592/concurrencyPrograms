import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //it has fix no of threads in pool
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            for (int i = 0; i < 10; i++) {
                executor.execute(new Task1(i));
            }
            executor.shutdown();
            System.out.println("TIme taken " + (System.currentTimeMillis() - startTime));
        }


        //========================================================
        System.out.println("newCachedThreadPool:-");
        //it We don't know how many threads are require we use this
        long startTime1 = System.currentTimeMillis();
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedExecutor.execute(new Task1(i));
        }
        cachedExecutor.shutdown();
        System.out.println("Tme taken " + (System.currentTimeMillis() - startTime1));


        //============================================================
        //used for secheduling jobs
        System.out.println("ScheduledExecutorService:-");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(new Task(9),
                0,
                5,
                TimeUnit.SECONDS);

        ScheduledExecutorService scheduledExecutorService1=Executors.newScheduledThreadPool(1);
        scheduledExecutorService1.scheduleWithFixedDelay(new Task1(1),
                5,
                5,
                TimeUnit.SECONDS);
    }

}

class Task1 implements Runnable {
    private int taskId;

    public Task1(int taskId) {
        this.taskId = taskId;
    }

    public void run() {
        System.out.println("Task " + taskId + " is Running on " + Thread.currentThread().getName());
    }
}
