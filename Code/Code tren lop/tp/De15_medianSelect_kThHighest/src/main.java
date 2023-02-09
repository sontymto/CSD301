import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputData input = new InputData();
        // int n = input.input_int("Enter number of courses: ", sc);
        SelectKOrderStatistic select = new SelectKOrderStatistic();
        Course[] courses = new Course[5];

        courses[0] = new Course("CSE1001", "A", 3);
        courses[1] = new Course("CSE1002", "B", 4);
        courses[2] = new Course("CSE1003", "C", 3);
        courses[3] = new Course("CSE1004", "D", 6);
        courses[4] = new Course("CSE1005", "E", 5);
        // for (int i = 0; i < args.length; i++) {
        //     int credit = input.input_int("Enter credit: ", sc);
        //     String code = input.input_string("Enter code: ", sc);
        //     String name = input.input_string("Enter name: ", sc);
        //     courses[i] = new Course(code, name, credit);
        // }
        
        int kOrder = input.input_int("Enter k order: ", sc);
        Course kOrderHighst = select.SelectKOrderHighest(courses,0 ,courses.length-1,kOrder);
        System.out.println(kOrderHighst);
}
}