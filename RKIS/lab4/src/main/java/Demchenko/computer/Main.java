package Demchenko.computer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Главный класс
 */
public class Main {
    /**
     * Точка входа в программу
     *
     * @param args Аргументы коммандной строки
     */
    public static void main(String[] args){
        ApplicationContext context =
                new AnnotationConfigApplicationContext("Demchenko.computer");

        Application consoleApplication = context.getBean(Application.class);

        consoleApplication.run();
    }
}
