
public class Car {
    
    public String brand;
    public String model;
    public String color;
    private int buildYear;
    
    public int getbuildYear () {
        return this.buildYear;
    }
    
    public Car(String brand, String model, String color, int buildYear) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.buildYear = buildYear;  
    }
    
    public void printAttributes() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Color: " + this.color);
        System.out.println("Build year:" + this.getbuildYear());
    }
    
}
    

