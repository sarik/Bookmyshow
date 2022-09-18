package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.ModuleController;
import com.scaler.bookmyshow.controllers.StudentController;
import com.scaler.bookmyshow.dtos.StudentCreationRequestDTO;
import com.scaler.bookmyshow.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {

    private StudentController studentController;
    private ModuleController moduleController;

    @Autowired
    public BookmyshowApplication(StudentController studentController,ModuleController moduleController) {
        this.studentController = studentController;
        this.moduleController = moduleController;
    }

    public static void main(String[] args) throws InterruptedException {

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






