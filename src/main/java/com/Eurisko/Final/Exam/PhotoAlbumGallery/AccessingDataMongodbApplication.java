//package com.Eurisko.Final.Exam.PhotoAlbumGallery;
//
//import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.MyUser;
//import com.Eurisko.Final.Exam.PhotoAlbumGallery.repository.MyUserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//
//public class AccessingDataMongodbApplication implements CommandLineRunner {
//
//    private final MyUserRepository myUserRepository;
//     public AccessingDataMongodbApplication(MyUserRepository myUserRepository) {
//         this.myUserRepository = myUserRepository;
//     }
//
//    public static void main(String[] args) {
//        SpringApplication.run(AccessingDataMongodbApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        myUserRepository.deleteAll();
//
//        // save a couple of users
//        myUserRepository.save(new MyUser("Alice", "Smith"));
//        myUserRepository.save(new MyUser("Bob", "Smith"));
//
//        // fetch all users
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (MyUser customer : myUserRepository.findAll()) {
//            System.out.println(customer);
//        }
//        System.out.println();
//
//        // fetch an individual user
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(myUserRepository.findByFirstName("Alice"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (MyUser user : myUserRepository.findByLastName("Smith")) {
//            System.out.println(user);
//        }
//
//    }
//
//}
//
