package Demchenko.car;

import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Главный класс
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Main {
    /**
     * Точка входа в программу
     *
     * @param args Аргументы коммандной строки
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Driver stateController = (Driver) context.getBean("stateController");

        stateController.drive();
    }
}
