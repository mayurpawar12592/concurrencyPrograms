import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections {
    public static void main(String[] args) {

        // we will get concurrentModificationException when using Arraylist
        //List<String> list=new ArrayList<>();
        List<String> list=new CopyOnWriteArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        Thread readTread= new Thread(()->{
            System.out.println("Reading Thread Data:-");
            for(String str:list){
                System.out.println("Read: "+str);
            }
        });

        Thread writeTread= new Thread(()->{
            System.out.println("Writing Thread Data:-");
            list.add("Six");
        });

        readTread.start();
        writeTread.start();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            throw new RuntimeException();
        }
        System.out.println("after:-" +list);
    }
}
