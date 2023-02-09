import java.util.Scanner;

public class InputData {
    public String input_string(String msg,Scanner sc){
        System.out.println(msg);
        String result = sc.nextLine().trim();

        // Check valid string
        if(result.length() == 0){
            System.out.println("Invalid input");
            return input_string(msg,sc);
        }
        return result;
    }
    public int input_int(String msg,Scanner sc){
        int result = -1;
        while(true){
            try {
                result = Integer.parseInt(input_string(msg, sc));
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        return result;
    }
    public double input_double(String msg,Scanner sc){
        double result = -1;
        while(true){
            try {
                result = Double.parseDouble(input_string(msg, sc));
                break;
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        return result;
    }
}
