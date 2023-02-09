public class Car {
    String number;
    String model;
    String color;

    public Car(String number, String model, String color) {
        this.number = number;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return number   + " " + 
               model    + " " + 
               color    + " ";
    }

}
