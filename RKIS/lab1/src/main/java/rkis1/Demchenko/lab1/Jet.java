package rkis1.Demchenko.lab1;

import java.util.Objects;

public class Jet extends ICE
{
    /**
     * Страна-производитель двигателя
     */
    private String country;

    /**
     * Сила реактивной тяги двигателя
     */
    private int thrust;

    /**
     * Конструктор по-умолчанию
     */
    public Jet()
    {
        super();
        country = null;
        thrust = 0;
    }

    /**
     * Конструктор с параметрами
     * @param power мощность двигателя
     * @param model модель двигателя
     * @param volume объем двигателя
     * @param serialNumber серийный номер двигателя
     * @param country страна-производитель двигателя
     * @param thrust сила реактивной тяги двигателя
     */
    public Jet(int power, String model, float volume, String serialNumber, String country, int thrust)
    {
        super(power, model, volume, serialNumber);
        this.country = country;
        this.thrust = thrust;
    }

    /**
     * Возвращает значение переменной "сила реактивной тяги двигателя"
     * @param thrust сила тяги
     */
    public void setThrust(int thrust)
    {
        if ((thrust < 0))
            System.out.println("Тяга не может быть меньше нуля! ");
        else
            this.thrust = thrust;
    }

    /**
     * Возвращает силу тяги двигателя
     * @return Сила тяги
     */
    public int getThrust()
    { return thrust; }

    /**
     * Возвращает значение переменной "страна-производитель"
     * @param country Страна-производитель
     */
    public void setCountry(String country)
    {
        if (country.isEmpty())
            System.out.println("Поле \"Страна производитель\" не может быть пустой! ");
        else
            this.country = country;
    }

    /**
     * Возвращает страну-производителя двигателя
     * @return Страна-производитель
     */
    public String getCountry()
    { return country; }

    /**
     * Сравнение объектов
     * @param obj объект для сравнения
     * @return Результат сравнения
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Jet)) return false;
        Jet that = (Jet) obj;
        return Objects.equals(country, that.country) && Objects.equals(thrust, that.thrust);
    }

    /**
     * Возвращает числовое значение фиксированной длины для оюъекта
     * @return Числовое значение
     */
    @Override
    public int hashCode()
    { return Objects.hash(country, thrust); }

    /**
     * Вывод информации об объекте
     * @return Строка информации об объекте
     */
    @Override
    public String toString()
    {
        return String.format(super.toString() +
                        """
                                Страна производитель: %s;
                                Реактивная тяга: %s;
                                """,
                country, thrust);
    }
}
