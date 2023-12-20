package Demchenko.computer.models;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "computer")
public class Computer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, max = 20)
    @Column(name = "gpu")
    private String gpu;

    @Size(min = 2, max = 20)
    @Column(name = "cpu")
    private String cpu;

    @Size(min = 2, max = 20)
    @Column(name = "monitor")
    private String monitor;

    @Min(value = 0)
    @Column(name = "ram_amount")
    private int ramAmount;

    @Min(value = 1)
    @Column(name = "price")
    private int price;

    @Min(value = 0)
    @Column(name = "quantity")
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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