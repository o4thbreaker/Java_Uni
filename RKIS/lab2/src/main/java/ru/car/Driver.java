package ru.car;

/**
 * Класс водителя
 */
public class Driver {

    /**
     * Контроллер состояний
     */
    private final IStateController stateController;

    /**
     * Конструктор водителя
     * @param stateController контроллер состояний
     */
    public Driver(IStateController stateController) {
        this.stateController = stateController;
    }

    /**
     * Процесс езды
     */
    public void drive() {
        stateController.startEngine();
        stateController.turnOnRadio();
        stateController.setVolume(5);
        stateController.pressGasPedal();
        stateController.setVolume(10);
        stateController.pressBreakPedal();
        stateController.turnOffRadio();
        stateController.killEngine();
    }
}

