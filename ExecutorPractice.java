import java.util.concurrent.*;

public class ExecutorPractice {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> {
            System.out.println("hello Executos");
        });
        executorService.shutdown();

        ExecutorService cacheExecutorService = Executors.newCachedThreadPool();
        cacheExecutorService.submit(() -> {
            System.out.println("calling cachedTradePool");
        });
        cacheExecutorService.shutdown();

        ExecutorService signleTheadExecutorService = Executors.newSingleThreadExecutor();
        signleTheadExecutorService.submit(() -> {
            System.out.println("Calling Single Threade");
        });
        signleTheadExecutorService.shutdown();


        Callable<Integer> callable1 = () -> {
            System.out.println("Calling call1");
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            System.out.println("calling call2");
            return 2;
        };
        try {
            ExecutorService service1 = Executors.newFixedThreadPool(3);
            Future<Integer> result = service1.submit(callable1);
            System.out.println(result.get());
            service1.shutdown();
        } catch (InterruptedException | ExecutionException ex) {

        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.schedule(() -> System.out.println("Calling schedule"), 0, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();

        ScheduledExecutorService schedulor = Executors.newScheduledThreadPool(2);
        schedulor.scheduleAtFixedRate(() -> System.out.println("calling scheduling"),
                5,
                5,
                TimeUnit.SECONDS);

        schedulor.schedule(() -> schedulor.shutdown(),
                20,
                TimeUnit.SECONDS);

        ScheduledExecutorService scheduleWithDelay = Executors.newScheduledThreadPool(3);
        scheduleWithDelay.scheduleWithFixedDelay(() -> System.out.println("calling delay"),
                0,
                5,
                TimeUnit.SECONDS);

    }
}
