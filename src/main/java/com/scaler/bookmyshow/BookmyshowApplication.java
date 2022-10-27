package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.ModuleController;
import com.scaler.bookmyshow.controllers.StudentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

class GunFight {
    private int bullets = 40;

    // This method fires the number of bullets that are
    // passed it. When the bullet in magazine becomes zero,
    // it calls the wait() method and releases the lock.
    synchronized public void fire(int bulletsToBeFired)
    {
        for (int i = 1; i <= bulletsToBeFired; i++) {
            if (bullets == 0) {
                System.out.println(i - 1
                        + " bullets fired and "
                        + bullets + " remains");
                System.out.println(
                        "Invoking the wait() method");
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(
                        "Continuing the fire after reloading");
            }

            bullets--;
        }
        System.out.println(
                "The firing process is complete");
    }

    // reload() increases the bullets by 40 everytime it is
    // invoked and calls the notify() method which wakes up
    // the thread that was sent to sleep using wait() inside
    // of fire() method
    synchronized public void reload()
    {
        System.out.println(
                "Reloading the magazine and resuming "
                        + "the thread using notify()");
        bullets += 40;
        notify();
    }
}

@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {



    private StudentController studentController;
    private ModuleController moduleController;

    @Autowired
    public BookmyshowApplication(StudentController studentController,ModuleController moduleController) {
        this.studentController = studentController;
        this.moduleController = moduleController;
    }

    public void finalize() throws Exception{
        try{
            //super.finalize();
        }
        finally{

        }


    };

    public static void main(String[] args) throws InterruptedException {

        String toreverse = "reverse";

        int mid = (toreverse.length() /2) -1;

        char[] temparray = toreverse.toCharArray();

        for(int i=0;i<=mid; i++){

            var temp = temparray[i];
            temparray[i] = temparray[toreverse.length()-i-1];
            temparray[toreverse.length()-i-1] = temp;


        }

        String newString = String.valueOf(temparray);
//        for(char c:temparray){
//            System.out.println(c);
//        }

        System.out.println(newString);
        System.out.println("done");
        String somename = "sarik";

        System.out.println(somename.charAt(3));

        var t = somename.charAt(3);

        somename += t;

        System.out.println(somename);

        Map<String,String> namesmap = new TreeMap<>();
        namesmap.put("sarik","siddiqui");
        namesmap.put("sajda","zafar");
        namesmap.put("silky","khatoon");

        Set<String> keys = namesmap.keySet();

        for(String key:keys)
            System.out.println(key);


        Set<Map.Entry<String,String>> entryset = namesmap.entrySet();
        for(Map.Entry<String,String> entry:entryset){
            System.out.println("key is "+ entry.getKey()+" with value"+ entry.getValue());
        }


        String name = new String("sarik");
        String name2 = new String("sarik");
        System.out.println(name2.getClass());

        System.out.println(name2.equals(name));

        List<Laptop> lappies = new ArrayList<Laptop>();
        lappies.add(new Laptop("HP","very bad",23000));
        lappies.add(new Laptop("Mac","very good",223000));
        lappies.add(new Laptop("Acer","ok",113000));

        Collections.sort(lappies);

        System.out.println(lappies);

        Comparator<Laptop> com = new Comparator<Laptop>() {
            @Override
            public int compare(Laptop o1, Laptop o2) {
                return -1*(o1.getName().length() - o2.getName().length());
            }
        };

        Collections.sort(lappies,com);

        System.out.println(lappies);


        Count count = new Count();

        System.out.println(count.getClass());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<10000;i++){
                    count.increment();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<10000;i++){
                    count.incrementwithoutsync(count);
                }

            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.getCount());

        Boolean[][] memoPalindrome = new Boolean[4][4];


        System.out.println(memoPalindrome[1][1]);

        boolean bool[][] = new boolean[10][10];

        System.out.println(bool[1][1]);

        System.out.println("just chekcing");
        Integer memoCuts[][] = new Integer[3][3];
        System.out.println(memoCuts[1][1]);

        int[] A = new int[]{1, 2, 3,4,5};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);

        for (int i = 1; i < A.length; ++i)
            pq.add(new int[]{0, i});


        int[] curr = pq.poll();
        System.out.println(A[curr[0]]);
        System.out.println(A[curr[1]]);


        GunFight gf = new GunFight();

        // Creating a new thread and invoking
        // our fire() method on it
        new Thread() {
            @Override public void run() { gf.fire(60); }
        }.start();

        // Creating a new thread and invoking
        // our reload method on it
        new Thread() {
            @Override public void run() { gf.reload(); }
        }.start();

        List<Integer> someList = new ArrayList<>();
        someList.add(10);
        someList.add(20);
        someList.add(30);
        someList.add(40);
        someList.add(60);
        someList.add(60);
        System.out.println(someList);

        someList.remove(Integer.valueOf(60));
        System.out.println(someList);

        var myList = List.of(1,2,3,4,5,6,7);

        String[] names = {"sarik","sajda","silky"};

        System.out.println("here");

        Stream.of(names).forEach(x ->  System.out.println(x));

        myList.stream().forEach(x ->  System.out.println(x));
        System.out.println(String.valueOf(myList.stream().count())+"total counts");

       // Paths.

        System.out.println("check");
        myList.stream().forEach(System.out::println);
        System.out.println("check");
        Arrays.stream(new int[] {1,2,3,4,5,6}).map(x -> x*x).average().ifPresent(System.out::println);

        var y = Arrays.stream(new int[] {1,2,3,4,5,6}).map(x -> x*x).average();

        System.out.println(y);
        System.out.println("y");



        SpringApplication.run(BookmyshowApplication.class, args);

        var counter = new Counter();

        var adder = new Adder(counter);
        var subtracter = new Subtracter(counter);
//        var t1 = new Thread(adder);
//        var t2 = new Thread(subtracter);
//
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();

        //System.out.println(counter.getCount());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

       Future<?> adderReturn = executorService.submit(adder);
       Future<?> subtracterReturn =  executorService.submit(subtracter);

       try{
           adderReturn.get();
           subtracterReturn.get();

       }

       catch(Exception e){
           //System.out.println("Found following issue");
           e.printStackTrace();
       }

        System.out.println("counter value::"+ counter.getCount());
        System.out.println("Main function done");

        //executorService.shutdown();
        //if(!executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        //}



    }

    @Override

    public void run(String... args) throws Exception {



        }




    }






