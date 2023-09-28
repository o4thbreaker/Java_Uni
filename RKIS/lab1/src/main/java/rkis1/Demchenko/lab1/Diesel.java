package rkis1.Demchenko.lab1;

import java.util.Objects;

public class Diesel extends ICE
{
    /**
     * Вид системы охлаждения двигателя
     */
    private String coolingType;

    /**
     * Расход топлива двигателя
     */
    private float fuelConsumption;

    /**
     * Констурктор по-умолчанию
     */
    public Diesel()
    {
        super();
        fuelConsumption = 0.0f;
        coolingType = null;
    }

    /**
     * Конструктор с параметрами
     *
     * @param power мощность двигателя
     * @param model модель двигателя
     * @param volume объем двигателя
     * @param serialNumber серийный номер двигателя
     * @param fuelConsumption расход топлива двигателя
     * @param coolingType вид системы охлаждения двигателя
     */
    public Diesel(int power, String model, float volume, String serialNumber, float fuelConsumption, String coolingType)
    {
        super(power, model, volume, serialNumber);
        this.fuelConsumption = fuelConsumption;
        this.coolingType = coolingType;
    }

    /**
     * Возвращает значение переменной "расход топлива двигателя"
     * @param fuelConsumption расход топлива двигателя
     */
    public void setFuelConsumption(float fuelConsumption)
    {
        if ((fuelConsumption < 0.0))
            System.out.println("Расход топлива не может быть меньше нуля! ");
        else
            this.fuelConsumption = fuelConsumption;
    }

    /**
     * Возвращает расход топлива двигателя
     * @return Расход топлива двигателя
     */
    public float getFuelConsumption()
    { return fuelConsumption; }

    /**
     * Возвращает значение переменной "вид системы охлаждения двигателя"
     * @param coolingType вид системы охлаждения
     */
    public void setCoolingType(String coolingType)
    {
        if (coolingType.isEmpty())
            System.out.println("Поле \"Система охлаждения\" не может быть пустым! ");
        else
            this.coolingType = coolingType;
    }

    /**
     * Возвращает вид системы охлаждения двигателя
     * @return Вид системы охлаждения
     */
    public String getCoolingType()
    { return coolingType; }

    /**
     * Сравнение объектов
     * @param obj объект для сравнения
     * @return Результат сравнения
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Diesel)) return false;
        Diesel that = (Diesel) obj;
        return Objects.equals(coolingType, that.coolingType) && Objects.equals(fuelConsumption, that.fuelConsumption);
    }

    /**
     * Возвращает числовое значение фиксированной длины для оюъекта
     * @return Числовое значение
     */
    @Override
    public int hashCode()
    { return Objects.hash(coolingType, fuelConsumption); }

    /**
     * Вывод информации об объекте
     * @return Строка информации об объекте
     */
    @Override
    public String toString()
    {
        return String.format(super.toString() +
                        """
                                Система охлаждения: %s;
                                Расход топлива (на 100 км): %s;
                                """,
                coolingType, fuelConsumption);
    }
}
