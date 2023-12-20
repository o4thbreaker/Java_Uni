package Demchenko.computer.rest;

public class Computer {

    private int id;

    private String gpu;

    private String cpu;

    private String monitor;

    private int ramAmount;

    private int price;

    private int quantity;

    public Computer() {
        this.gpu = "Default GPU";
        this.cpu = "Default CPU";
        this.monitor = "Default monitor";
        this.ramAmount = 2;
        this.price = 1;
        this.quantity = 1;
    }

    public Computer(String gpu, String cpu, String monitor, int ramAmount, int price, int quantity) {
        this.gpu = gpu;
        this.cpu = cpu;
        this.monitor = monitor;
        this.ramAmount = ramAmount;
        this.price = price;
        this.quantity = quantity;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
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
                ", quantity: " + quantity +
                '}';
    }
}