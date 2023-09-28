package rkis1.Demchenko.lab1;

import java.util.Objects;

public class Engine
{
    /**
     * Мощность двигателя
     */
    private int power;
    /**
     * Модель двигателя
     */
    private String model;

    /**
     * Конструктор по-умолчанию
     */
    public Engine()
    {
        power = 0;
        model = null;
    }

    /**
     * Конструктор с параметрами
     * @param power мощность
     * @param model модель
     */
    public Engine(int power, String model)
    {
        this.power = power;
        this.model = model;
    }

    /**
     * Возвращает значение переменной "мощность двигателя"
     * @param power значение переменной
     */
    public void setPower(int power)
    {
        if (power < 0)
            System.out.println("Поле 'Мощность' не должно быть меньше нуля!");
        else
            this.power = power;
    }

    /**
     * Возвращает значение переменной "модель двигателя"
     * @param model значение переменной
     */
    public void setModel(String model)
    {
        if (model.isEmpty())
            System.out.println("Поле 'Модель' не должно быть пустым!");
        else
            this.model = model;
    }

    /**
     * Возвращает мощность двигателя
     * @return Мощность двигателя
     */
    public int getPower()
    { return power; }

    /**
     * Возвращает модель двигателя
     * @return Модель двигателя
     */
    public String getModel()
    { return model; }

    /**
     * Сравнение объектов
     * @param obj объект для сравнения
     * @return Результат сравнения
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!(obj instanceof Engine)) return false;
        Engine that = (Engine) obj;
        return Objects.equals(model, that.model) && Objects.equals(power, that.power);
    }

    /**
     * Возвращает числовое значение фиксированной длины для оюъекта
     * @return Числовое значение
     */
    @Override
    public int hashCode()
    { return Objects.hash(model, power); }

    /**
     * Вывод информации об объекте
     * @return Строка информации об объекте
     */
    @Override
    public String toString()
    {
        return String.format(
                """
                        Модель: %s;
                        Мощность: %s;
                        """,
                model, power);
    }
}
