package Demchenko.computer;
// DAO -  средства чтения и записи данных в базу данных
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;

/**
 * Консольное приложение для работы с базой данных
 */
@Component
public class Application {
    /**
     * Сервис для работы с компьютером
     */
    private final ComputerService computerService;

    /**
     * Конструктор приложения
     * @param computerService сервис для работы с компьютером
     */
    public Application(ComputerService computerService) {
        this.computerService = computerService;
    }

    /**
     * Запускает консольное приложение
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Добавить новый компьютер");
            System.out.println("2 - Вывести информацию об имеющихся компьютерах");
            System.out.println("3 - Изменить информацию о компьютере");
            System.out.println("4 - Найти компьютер");
            System.out.println("5 - Удалить компьютер");
            System.out.println("6 - Завершить работу");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addComputer(scanner);
                case "2" -> showAllComputers();
                case "3" -> editComputer(scanner);
                case "4" -> searchComputers(scanner);
                case "5" -> deleteComputer(scanner);
                case "6" -> {
                    System.out.println("Завершение работы");
                    return;
                }
                default -> System.out.println("Некорректный ввод!");
            }
        }
    }

    /**
     * Считывает данные объекта из коммандной строки
     * @param scanner Объект класса Scanner
     * @return Новый компьютер
     */
    private Computer getComputer(Scanner scanner){
        System.out.print("Введите модель видеокарты: ");
        String gpu = scanner.nextLine();
        System.out.print("Введите модель процесса: ");
        String cpu = scanner.nextLine();
        System.out.print("Введите модель монитора: ");
        String monitor = scanner.nextLine();
        System.out.print("Введите количество оперативной памяти: ");
        int ramAmount = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите стоимость: ");
        int price = Integer.parseInt(scanner.nextLine());
        return new Computer(gpu, cpu, monitor, ramAmount, price);
    }

    /**
     * Добавляет новый компьютер в базу данных
     * @param scanner Объект класса Scanner
     */
    private void addComputer(Scanner scanner) {
        Computer computer = getComputer(scanner);
        computerService.addComputer(computer);
        System.out.println("Новый компьютер был успешно добавлен!");
    }

    /**
     * Выводит в консоль информацию обо всех имеющихся компьютерах
     */
    private void showAllComputers() {
        List<Computer> computerList = computerService.getAllComputers();
        if (computerList.isEmpty()) {
            System.out.println("Компьютеров нет.");
        } else {
            for (Computer computer : computerList) {
                System.out.println(computer);
            }
        }
    }

    /**
     * Изменяет информацию о компьютере
     * @param scanner Объект класса Scanner
     */
    private void editComputer(Scanner scanner) {
        showAllComputers();
        System.out.println("Введите id объекта для редактирования: ");
        int id = Integer.parseInt(scanner.nextLine());
        Computer updatedComputer = getComputer(scanner);
        computerService.updateComputer(id, updatedComputer);
        System.out.println("Данные о компьютере были успешно обновлены!");
    }

    /**
     * Удаляет компьютер по id
     * @param scanner Объект класса Scanner
     */
    private void deleteComputer(Scanner scanner) {
        System.out.println("Введите id компьютера для удаления:");
        int id = Integer.parseInt(scanner.nextLine());
        computerService.deleteComputer(id);
        System.out.println("Компьютер удален!");
    }

    /**
     * Ищет компьютер по одному из полей
     * @param scanner Объект класса Scanner
     */
    private void searchComputers(Scanner scanner) {
        System.out.println("Выберите критерий поиска: ");
        System.out.println("1 - По видеокарте");
        System.out.println("2 - По процессору");
        System.out.println("3 - По количеству оперативной памяти");
        String field;
        switch (scanner.nextLine()) {
            case "1" -> field = "gpu";
            case "2" -> field = "cpu";
            case "3" -> field = "ramAmount";
            default -> {
                System.out.println("Некорректный ввод :(");
                return;
            }
        }
        System.out.println("Введите значение для поиска: ");
        String value = scanner.nextLine();
        List<Computer> computerList = computerService.searchComputer(field, value);
        if (computerList.isEmpty()) {
            System.out.println("Данных о компьютерах нет");
        } else {
            for (Computer computer : computerList) {
                System.out.println(computer);
            }
        }
    }
}