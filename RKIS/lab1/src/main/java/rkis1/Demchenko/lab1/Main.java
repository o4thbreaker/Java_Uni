package rkis1.Demchenko.lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    /**
     * Основное меню программы
     */
    private static void printMenu()
    {
        System.out.print("""
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            ┃                МЕНЮ                ┃
            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
            1 — Добавить двигатель
            2 — Удалить двигатель
            3 — Вывести список всех двигателей
            4 — Сравнить два двигателя (по индексам)

            5 — Выход \n \n""");
    }

    /**
     * Меню выбора двигателя
     */
    private static void printEngineMenu()
    {
        System.out.print("""
            ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
            ┃        Выбор двигателя             ┃
            ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
            1 — Двигатель
            2 — Двигатель внутреннего сгорания
            3 — Реактивный двигатель
            4 — Дизельный двигатель
            
            5 — Отмена \n \n""");
    }

    /**
     * Функция преобразования введенной строки в целое число
     * @return Целое число
     */
    private static int getIntInput()
    {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        int userInt = 0;
        boolean allowedInput = false;
        do
        {
            try
            {
                userInt = Integer.parseInt(userInput);
                allowedInput = true;
            }
            catch (NumberFormatException ex)
            {
                System.out.print("Неккоректный ввод! Введите только целое число: ");
                userInput = input.nextLine();
            }
        }while (!allowedInput);

        return (userInt);
    }

    /**
     * Функция проверки введенной строки на соответствие целочисленному ограничению
     * @param lowerLimit верхняя граница
     * @param upperLimit нижняя граница
     * @return Целое число
     */
    public static int getParamsIntInput(int lowerLimit, int upperLimit)
    {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        int userInt = 0;
        boolean allowedInput = false;
        do
        {
            try
            {
                userInt = Integer.parseInt(userInput);
                if (userInt < lowerLimit || userInt > upperLimit)
                {
                    System.out.print("Число не в заданном диапазоне! Введите число " +
                            "(от " + lowerLimit + " до " + upperLimit + "): ");
                    userInput = input.nextLine();
                }
                else
                    allowedInput = true;
            }
            catch (NumberFormatException ex)
            {
                System.out.print("┃ Неверный ввод. Введите число: ");
                userInput = input.nextLine();
            }
        }
        while (!allowedInput);
        return userInt;
    }

    /**
     * Функция для получения строки от пользователя
     * @return Строка
     */
    private static String getStringInput()
    {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        while (userInput.isEmpty())
        {
            System.out.print("Ввод не может быть пустым! Повторите ввод: ");
            userInput = input.nextLine();
        }
        return userInput;
    }

    /**
     * Функция преобразования введенной строки в вещественное число
     * @return Вещественное число
     */
    private static float getFloatInput()
    {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        float userFloat = 0;
        boolean allowedInput = false;
        do
        {
            try
            {
                userFloat = Float.parseFloat(userInput);
                allowedInput = true;
            }
            catch (NumberFormatException ex)
            {
                System.out.print("Неккоректный ввод! Введите только вещественное число: ");
                userInput = input.nextLine();
            }
        }
        while (!allowedInput);
        return (userFloat);
    }

    /**
     * Функция проверки введенной строки на соответствие вещественному ограничению
     * @param lowerLimit верхняя граница
     * @param upperLimit нижняя граница
     * @return Вещественное число
     */
    public static float getParamsFloatInput(float lowerLimit, float upperLimit)
    {

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        float userFloat = 0;
        boolean allowedInput = false;
        do
        {
            try
            {
                userFloat = Float.parseFloat(userInput);
                if (userFloat < lowerLimit || userFloat > upperLimit)
                {
                    System.out.print("Число не в заданном диапазоне! введите число " +
                            "(от " + lowerLimit + " до " + upperLimit + "): ");
                    userInput = input.nextLine();
                }
                else
                    allowedInput = true;
            }
            catch (NumberFormatException ex)
            {
                System.out.print("┃ Неверный ввод. Введите число: ");
                userInput = input.nextLine();
            }
        }
        while (!allowedInput);
        return userFloat;
    }

    /**
     * Функция возвращает мощность двигателя
     * @return Мощность двигателя
     */
    private static int getPower()
    {
        System.out.print("Введите мощность двигателя (от 0 до 5000 л.с.): ");
        return getParamsIntInput(0, 5000);
    }

    /**
     * Функция возвращает модель двигателя
     * @return Модель двигателя
     */
    private static String getModel()
    {
        System.out.print("Введите модель двигателя: ");
        return getStringInput();
    }

    /**
     * Функция возвращает объем двигателя
     * @return Объем двигателя
     */
    private static float getVolume()
    {
        System.out.print("Введите объем двигателя (от 0 до 150 л.): ");
        return getParamsFloatInput(0, 150);
    }

    /**
     * Функция возвращает серийный номер двигателя
     * @return Серийный номер
     */
    private static String getSerialNumber()
    {
        System.out.print("Введите серийный номер двигателя: ");
        return getStringInput();
    }

    /**
     * Функция возвращает силу тяги двигателя
     * @return Сила тяги
     */
    private static int getThrust()
    {
        System.out.print("Введите силу тяги двигателя (от 0 до 1500 тн.): ");
        return getParamsIntInput(0, 1500);
    }

    /**
     * Функция возвращает название страны производителя двигателя
     * @return Страна-производитель
     */
    private static String getCountry()
    {
        System.out.print("Введите название страны производителя двигателя: ");
        return getStringInput();
    }

    /**
     * Функция возвращает расход топлива двигателя
     * @return Расход топлива
     */
    private static float getFuelConsumption()
    {
        System.out.print("Введите расход топлива (на 100 км.) двигателя (от 0 до 250 л.): ");
        return getParamsFloatInput(0, 250);
    }

    /**
     * Функция возвращает вид системы охлаждения двигателя
     * @return Вид системы охлаждения
     */
    private static String getCoolingType()
    {
        System.out.print("Введите вид системы охлаждения двигателя: ");
        return getStringInput();
    }

    /**
     * Функция возвращает корректный индекс элемента массива
     * @param engineStack массив двигателей
     * @return Индекс элемента массива
     */
    private static int getValidIndex(ArrayList<Engine> engineStack)
    {
        int index = getIntInput();
        while (index < 1 || index > engineStack.size())
        {
            System.out.print("Введите корректный индекс! (от 1 до " +
                    engineStack.size() + "): ");
            index = getIntInput();
        }
        return index;
    }

    /**
     * Функция выводит информацию о всех двигателях в массиве
     * @param engineStack массив двигателей
     */
    private static void printAllEngines(ArrayList<Engine> engineStack)
    {
        int count = 1;
        if (engineStack.isEmpty())
            System.out.println("Объекты отсутствуют. ");
        else
        {
            for(Engine i: engineStack)
            {
                System.out.println("№" + count + "\n" + i.toString());
                count++;
            }
        }
    }

    /**
     * Функция удаляет двигатель из массива
     * @param engineStack массив двигателей
     */
     private static void deleteEngine(ArrayList<Engine> engineStack)
     {
         printAllEngines(engineStack);
         if (!engineStack.isEmpty())
         {
             System.out.println("Введите номер двигателя для удаления");
             int numToDelete = getIntInput();

             if (numToDelete < 1 || numToDelete > engineStack.size())
                System.out.println("Выберите корректный номер двигателя для удаления! (от 1 до " + engineStack.size() + ")");
             else
             {
                engineStack.remove(numToDelete - 1);
                System.out.println("Двигатель №" + numToDelete + " удален!");
             }
         }
     }

    /**
     * Функция реализует работу выбора класса для создания определенного двигателя
     * @param engineStack массив двигателей
     */
    public static void createEngine(ArrayList<Engine> engineStack)
    {
        printEngineMenu();
        System.out.println("\n");
        System.out.print("Выберите номер двигателя: ");
        int engineChoice = getIntInput();
        switch (engineChoice)
        {
            case 1 -> engineStack.add(createNewEngine());
            case 2 -> engineStack.add(createNewICE());
            case 3 -> engineStack.add(createNewJet());
            case 4 -> engineStack.add(createNewDiesel());
            case 5 -> System.out.println("Отменяем...");
            default -> System.out.println("Такого пункта нет в меню!");
        }
    }

    /**
     * Функция создает новый двигатель
     * @return Созданный двигатель
     */
    private static Engine createNewEngine()
    {
        int enginePower = getPower();
        String engineModel = getModel();

        System.out.println("Двигатель создан!");
        return new Engine(enginePower, engineModel);
    }

    /**
     * Функция создает новый двигатель ДВС
     * @return Созданный двигатель ДВС
     */
    private static Engine createNewICE()
    {
        int enginePower = getPower();
        String engineModel = getModel();
        float engineVolume = getVolume();
        String engineSerialNumber = getSerialNumber();

        System.out.println("Новый двигатель внутреннего сгорания создан! ");
        return new ICE(enginePower, engineModel, engineVolume, engineSerialNumber);
    }

    /**
     * Функция создает новый реактивный двигатель
     * @return Созданный реактивнвый двигатель
     */
    private static Engine createNewJet()
    {
        int enginePower = getPower();
        String engineModel = getModel();
        float engineVolume = getVolume();
        String engineSerialNumber = getSerialNumber();
        String engineCountry = getCountry();
        int engineThrust = getThrust();

        System.out.println("Новый реактивный двигатель создан! ");
        return new Jet(enginePower, engineModel, engineVolume, engineSerialNumber, engineCountry, engineThrust);
    }

    /**
     * Функция создает новый дизельный двигатель
     * @return Созданный дизельный двигатель
     */
    private static Engine createNewDiesel()
    {
        int enginePower = getPower();
        String engineModel = getModel();
        float engineVolume = getVolume();
        String engineSerialNumber = getSerialNumber();
        float engineFuelConsumption = getFuelConsumption();
        String engineCoolingType = getCoolingType();

        System.out.println("Новый дизельный двигатель создан! ");
        return new Diesel(enginePower, engineModel, engineVolume, engineSerialNumber, engineFuelConsumption, engineCoolingType);
    }

    /**
     * Функция проверяет два двигателя на равенство (по индексам)
     * @param engineStack массив двигателей
     */
    private static void compareEngines(ArrayList<Engine> engineStack)
    {
        printAllEngines(engineStack);
        if (!engineStack.isEmpty())
        {
            System.out.println("Введите номер первого двигателя для сравнения:");
            int index1 = getValidIndex(engineStack) - 1;

            System.out.println("Введите номер второго двигателя для сравнения:");
            int index2 = getValidIndex(engineStack) - 1;

            if (!(index2 == index1))
            {
                if (engineStack.get(index1).equals(engineStack.get(index2)))
                    System.out.println("Двигатели равны (хэш-коды равны, операция равенства верна)");
                else
                    System.out.println("Двигатели не равны");
            }
            else
                System.out.println("Индексы одинаковы! ");
        }
    }

    /**
     * Основная функция программы, которая реализует работу алгоритма (и вывод информации)
     * @param args массив последовательности строк, которые передаются в main
     */
    public static void main(String[] args)
    {
        ArrayList<Engine> engineStack = new ArrayList<>();
        int menuChoice;
        do {
            printMenu();
            System.out.print("Введите Ваш выбор: ");
            menuChoice = getIntInput();
            switch (menuChoice)
            {
                case 1 -> createEngine(engineStack);
                case 2 -> deleteEngine(engineStack);
                case 3 -> printAllEngines(engineStack);
                case 4 -> compareEngines(engineStack);
                case 5 -> System.out.println("Завершение работы...");
                default -> System.out.print("Такого номера не предусмотрено! Попробуйте еще раз: ");
            }
        } while (menuChoice != 5);
    }
}