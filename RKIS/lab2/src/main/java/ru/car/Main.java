package ru.car;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Главный класс
 */
public class Main {
    /**
     * Точка входа в программу
     *
     * @param args Аргументы коммандной строки
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Driver stateController = (Driver) context.getBean("stateController");

        stateController.drive();
    }
}
