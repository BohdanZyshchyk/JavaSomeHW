package app;

import app.seeder.SeederDb;
import app.storage.StorageProperties;
import app.storage.StorageService;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Main {

    public static void main(String[] args) {
        System.out.println(Core.VERSION);
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("mat = " + mat.dump());
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService, SeederDb seederDb) {
        return (args) -> {
            //storageService.deleteAll();
            try {
                seederDb.SeedAllTabels();
                storageService.init();
            }
            catch(Exception ex) {
                System.out.println("----problem create folder--------");
            }
        };
    }

}
