import java.util.logging.Logger;

public class ThreadDemo {
    Logger log = Logger.getLogger(String.valueOf(ThreadDemo.class));
    public static void main(String[] args) {

        for(int i=0; i<10;i++){
            Thread t = new Thread(new Task(i));
            t.start();
        }

    }
}


class Task implements Runnable{
 private int taskId;

 public Task(int taskId){
     this.taskId =taskId;
 }
    public void run(){
        System.out.println("Task "+taskId+" is Running on "+Thread.currentThread().getName());
    }
}
