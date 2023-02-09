import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        InputData ip = new InputData();
        int n = ip.input_int("Enter n rhombuses: ", sc);
        Rhombuses [] arr = new Rhombuses[n];
        // arr[0] = new Rhombuses(1, 2, "red");
        // arr[4] = new Rhombuses(2, 3, "blue");
        // arr[3] = new Rhombuses(3, 4, "green");
        // arr[2] = new Rhombuses(4, 5, "yellow");
        // arr[1] = new Rhombuses(5, 6, "black");

        // input data
        for (int i = 0; i < arr.length; i++) {
            double d1 = ip.input_double("Enter d1: ", sc);
            double d2 = ip.input_double("Enter d2: ", sc);
            String color = ip.input_string("Enter color: ", sc);
            arr[i] = new Rhombuses(d1, d2,color);
        }

        int k = ip.input_int("Enter k: ", sc);
        
        
        // find kth order
        Rhombuses kthOrder = FindKth.findKthOrderUsingQuickSort(arr, k);
        System.out.println("Kth order: " + kthOrder);

        //Show array
        for (Rhombuses rhombuses : arr) {
            System.out.println(rhombuses);
        }
       
    }
}
