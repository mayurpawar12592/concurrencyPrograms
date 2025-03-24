import java.util.concurrent.ConcurrentHashMap;
// This class explains methods like remove,replace,putIfAbsent usage

public class ConCurrentHashMapMethods {
    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        System.out.println("Map :" + map);

        //putIfAbsent method works when the element is not present in the map, in below example FOur is present so it will not add
        Integer result = map.putIfAbsent("Four", 5);
        System.out.println("Result of putIfAbsent  when element is present:" + result);
        System.out.println("After putIfAbsent :" + map);

        // if element is not present it will add this element and return null
        Integer result1 = map.putIfAbsent("Five", 5);
        System.out.println("Result of putIfAbsent when element is not present :" + result1);
        System.out.println("After putIfAbsent :" + map);


        //replace method is used to replace element
        Integer result2 =map.replace("Five",55);
        System.out.println("Result of replace when element is present :" + result2);
        System.out.println("After replace :" + map);

        //replace method is used to replace element
        Integer result3 =map.replace("Six",5);
        System.out.println("Result of replace when element is not present :" + result3);
        System.out.println("After replace :" + map);


    }
}
