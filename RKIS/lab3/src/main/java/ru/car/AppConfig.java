package ru.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

/**
 *  Класс конфигурации
 */
@Configuration
@ComponentScan("ru.car")
public class AppConfig {
    /**
     * Минимальная громкость
     */
    @Value("${minVolume}")
    private int minVolume;

    /**
     * Максимальная громкость
     */
    @Value("${maxVolume}")
    private int maxVolume;

    /**
     * Модель автомобиля
     */
    @Value("BMW")
    private String model;

    /**
     * Определяет bean Car и внедряет значения из внешних свойств
     *
     * @return Bean Car
     */
    @Bean
    public IStateController car() {
        Car car = new Car(minVolume, maxVolume);
        car.setModel(model);
        return car;
    }

    /**
     * Определяет bean Driver, зависящий от bean Car
     *
     * @return Bean Driver
     */
    @Bean
    public Driver stateController() {
        return new Driver(car());
    }

}