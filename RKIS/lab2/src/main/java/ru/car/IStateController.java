package ru.car;
/**
 * Интерфейс состояний автомобиля
 */
public interface IStateController {

    /**
     * Завести двигатель
     */
    void startEngine();

    /**
     * Заглушить двигатель
     */
    void killEngine();

    /**
     * Включить радио
     */
    void turnOnRadio();

    /**
     * Выключить радио
     */
    void turnOffRadio();

    /**
     * Установить громкость
     * @param volume громкость
     */
    void setVolume(int volume);

    /**
     * Получить текущую громкость
     * @return текущая громкость
     */
    int getVolume();

    /**
     * Нажать на педаль газа
     */
    void pressGasPedal();

    /**
     * Нажать на педаль тормоза
     */
    void pressBreakPedal();
}
