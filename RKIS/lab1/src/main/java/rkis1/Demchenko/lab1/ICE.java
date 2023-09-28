package rkis1.Demchenko.lab1;

import java.util.Objects;

public class ICE extends Engine
{
    /**
     * Объем двигателя
     */
    private float volume;

    /**
     * Серийный номер двигателя
     */
    private String serialNumber;

    /**
     * Конструктор по-умолчанию
     */
    public ICE()
    {
        super();
        volume = 0.0f;
        serialNumber = null;
    }

    /**
     * Конструктор с параметрами
     *
     * @param power мощность двигателя
     * @param model модель двигателя
     * @param volume объем двигателя
     * @param serialNumber серийный номер двигателя
     */
    public ICE(int power, String model, float volume, String serialNumber)
    {
        super(power, model);
        this.volume = volume;
        this.serialNumber = serialNumber;
    }

    /**
     * Возвращает значение переменной "объем двигателя"
     * @param volume объем двигателя
     */
    public void setVolume(float volume)
    {
        if ((volume < 0.0))
            System.out.println("Объем не может быть меньше нуля! ");
        else
            this.volume = volume;
    }

    /**
     * Возвращает объем двигателя
     * @return Объем
     */
    public float getVolume()
    { return volume; }

    public void setSerialNumber()
    {
        if (serialNumber.isEmpty())
            System.out.println("Серийный номер не может быть пустым! ");
        else
            this.serialNumber = serialNumber;
    }

    /**
     * Возвращает серийный номер
     * @return Серийный номер
     */
    public String getSerialNumber()
    { return serialNumber; }

    /**
     * Сравнение объектов
     * @param obj объект для сравнения
     * @return Результат сравнения
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof ICE)) return false;
        ICE that = (ICE) obj;
        return Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(volume, that.volume);
    }

    /**
     * Возвращает числовое значение фиксированной длины для оюъекта
     * @return Числовое значение
     */
    @Override
    public int hashCode()
    { return Objects.hash(serialNumber, volume); }

    /**
     * Вывод информации об объекте
     * @return Строка информации об объекте
     */
    @Override
    public String toString()
    {
        return String.format(super.toString() +
                        """
                                Серийный номер: %s;
                                Объем: %s;
                                """,
                serialNumber, volume);
    }
}
