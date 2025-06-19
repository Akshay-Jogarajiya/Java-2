import java.util.*;

public class DataStructures {
    public static void main(String[] args) {
        //Array
        int[] number = {1,2,3,4,5};
        number[0] = 0;

        for (int n : number) {
            System.out.print(n +" ");
        }
        System.out.println();
        //List
        //ArrayList
        List<String> list = new ArrayList<>(Arrays.asList("Akshay", "Paresh", "Hitesh"));
        System.out.println(list.get(2));
        list.add("Prince");
        System.out.println(list);

        //LinkedList
        List<String> language = new ArrayList<>();
        language.add("Java");
        language.add("Python");
        System.out.println(language);

        //Stack (LIFO)
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        //Queue (FIFO)
        Queue<String> queue = new LinkedList<>();
        queue.offer("Java");
        queue.offer("Python");
        queue.offer("JavaScript");
        System.out.println(queue.peek());

        //Deque
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque); // [1, 2]

        //HashMap
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 95);
        map.put("C++", 85);
        System.out.println(map.get("Java"));

        //HashSet
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Java"); // ignore
        System.out.println(set);

        //Priority Queue (Smallest First)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        System.out.println(pq.poll());

        //TreeSet (Sorted)
        Set<Integer> set1 = new TreeSet<>();
        set1.add(5);
        set1.add(1);
        set1.add(3);
        System.out.println(set1);

        //TreeMap (Sorted by keys)
        Map<Integer, String> set2 = new TreeMap<>();
        set2.put(5, "Paresh");
        set2.put(1, "Akshay");
        set2.put(3, "Hitesh");
        System.out.println(set2);
    }
}
