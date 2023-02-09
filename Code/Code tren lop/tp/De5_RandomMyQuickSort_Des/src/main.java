public class main {
    
    public static void main(String[] args) {
        Car[] cars = new Car[6];
        // Fill the array with random cars
        cars[0] = new Car("Audi", "A4", "A1234AA");
        cars[1] = new Car("BMW", "X5", "A1234AB");
        cars[2] = new Car("Mercedes", "C200", "A1234AC");
        cars[3] = new Car("Toyota", "Corolla", "A1234AD");
        cars[4] = new Car("Honda", "Civic", "A1234AE");
        cars[5] = new Car("Volkswagen", "Golf", "A1234AF");

        // display the array before sorting
        System.out.println("Before sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // sort the array
        RandomQuickSort.quickSort(cars, 0, cars.length - 1);

        // display the array after sorting
        System.out.println("After sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
