package Demchenko.computer;

public class Computer {
    private int id;
    private String gpu;
    private String cpu;
    private String monitor;
    private int ramAmount;
    private int price;

    public Computer() {
        this.gpu = "Default GPU";
        this.cpu = "Default CPU";
        this.monitor = "Default monitor";
        this.ramAmount = 2;
        this.price = 1;
    }

    public Computer(String gpu, String cpu, String monitor, int ramAmount, int price) {
        this.gpu = gpu;
        this.cpu = cpu;
        this.monitor = monitor;
        this.ramAmount = ramAmount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getGpu() {
        return gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public double getRamAmount() {
        return ramAmount;
    }

    public void setRamAmount(int ramAmount) {
        this.ramAmount = ramAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computers {" +
                "id:" + id +
                ", gpu: '" + gpu + '\'' +
                ", cpu: '" + cpu + '\'' +
                ", monitor: '" + monitor + '\'' +
                ", ramAmount: " + ramAmount +
                ", price: " + price +
                '}';
    }
}