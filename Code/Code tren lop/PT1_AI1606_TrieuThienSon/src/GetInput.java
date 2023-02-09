import java.util.Scanner;

public class GetInput {

    Scanner sc = new Scanner(System.in);

    public String inputString(String msg) {
        while (true) {
            System.out.print(msg);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Invalid input. Input cannot be empty.");
            } else {
                return result;
            }
        }
    }

    public String inputName(String msg) {
        return inputString(msg);
    }

    public String inputCategory(String msg) {
        return inputString(msg);
    }

    private boolean checkExistedCode(String code, Food[] foods, int inputIndex) {
        for (int i = 0; i < inputIndex; i++) {
            if (code.equals(foods[i].code)) {
                return true;
            }
        }
        return false;
    }

    public String inputCode(String msg, Food[] foods, int inputIndex) {
        while (true) {
            try {
                String code = inputString(msg);
                if (!checkExistedCode(code, foods, inputIndex) || inputIndex == 0) {
                    return code;
                }
                System.out.println("Code is existed");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Input must be integer.");
            }
        }
    }

    public int inputPrice(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < 0) {
                    System.out.println("Invalid input. Price cannot be negative.");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Input must be integer.");
            }
        }
    }

    public int inputPositiveNumber(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    System.out.println("Invalid input. Input must be positive number.");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Input must be integer.");
            }
        }
    }

    public int inputKth(String msg, int n) {
        while (true) {
            try {
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    System.out.println("Invalid input. Input must be positive number.");
                } else if (result > n) {
                    System.out.println("Invalid input. Input must be in of range [1, " + n + "].");
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Input must be integer.");
            }
        }
    }
}
