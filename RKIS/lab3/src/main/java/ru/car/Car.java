package ru.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Класс машины
 */
@Component("car")
public class Car implements IStateController {

    /**
     * Заведен ли двигатель
     */
    private boolean isEngineStarted;

    /**
     * Включено ли радио
     */
    private boolean isRadioOn;

    /**
     * Едет ли машина
     */
    private boolean isCarMoving;

    /**
     * Громкость
     */
    private int volume;

    /**
     * Минимальная громкость
     */
    private final int minVolume;

    /**
     * Максимальная громкость
     */
    private final int maxVolume;


    private String model;

    /**
     * Конструктор класса машины
     * @param minVolume минимальная громкость
     * @param maxVolume максимальная громкость
     */
    public Car(int minVolume, int maxVolume) {
        if (minVolume > maxVolume) {
            throw new IllegalArgumentException("Min volume is bigger than max");
        }

        this.isEngineStarted = false;
        this.isRadioOn = false;
        this.isCarMoving = false;

        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.volume = 0;
    }

    /**
     * Завести двигатель
     */
    @Override
    public void startEngine() {
        isEngineStarted = true;
        System.out.println("Vroom-vroom! The engine has started!");
    }

    /**
     * Заглушить двигатель
     */
    @Override
    public void killEngine() {
        isEngineStarted = false;
        isCarMoving = false;
        System.out.println("The engine has stopped working...");
    }

    /**
     * Включить радио
     */
    @Override
    public void turnOnRadio() {
        isRadioOn = true;
        System.out.println("Radio is on!");
    }

    /**
     * Выключить радио
     */
    @Override
    public void turnOffRadio() {
        isRadioOn = false;
        System.out.println("Radio is off :(");
    }

    /**
     * Установить громкость
     * @param volume громкость
     */
    @Override
    public void setVolume(int volume) {
        if (isRadioOn) {
            if (volume < minVolume) {
                System.out.println("The MINIMUM volume should be at least " + minVolume
                        + " and the maximum volume should be not over " + maxVolume);
                this.volume = minVolume;
                System.out.println("The volume is set to minimum.");
            }
            else if (volume > maxVolume) {
                System.out.println("The minimum volume should be at least " + minVolume
                        + " and the MAXIMUM volume should be not over " + maxVolume);
                this.volume = maxVolume;
                System.out.println("The volume is set to maximum.");
            }
            else {
                this.volume = volume;
                System.out.println("The volume is set to " + volume +
                        ". \"Kavinsky - Nightcall\" is playing");
            }
        }
        else {
            System.out.println("The radio is off.");
        }
    }

    /**
     * Получить текущую громкость
     * @return текущая громкость
     */
    @Override
    public int getVolume() {
        if (isRadioOn) {
            System.out.println("Current volume level is " + this.volume);
            return this.volume;
        } else {
            System.out.println("The radio is off.");
            return 0;
        }
    }

    /**
     * Нажать на педаль газа
     */
    @Override
    public void pressGasPedal() {
        if (isEngineStarted) {
            isCarMoving = true;
            System.out.println("The car is moving");
        }
        else {
            System.out.println("The engine has not been started yet");
        }
    }

    /**
     * Нажать на педаль тормоза
     */
    @Override
    public void pressBreakPedal() {
        if (isEngineStarted) {
            isCarMoving = false;
            System.out.println("The car has stopped");
        }
        else {
            System.out.println("The engine has not been started yet, so there is seems to be no effect");
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    /**
     * Инициализация объекта Car
     */
    @PostConstruct
    public void init(){
        System.out.println("Initialization car object");
    }

    /**
     * Уничтожение объекта Car
     */
    @PreDestroy
    public void destroy(){
        System.out.println("Destroying car object");
    }
}
