
import java.util.Scanner;



public class Main {
    static Scanner sc = new Scanner(System.in);

    static int partition(Student arr[], int low, int high) {
        String pivot = arr[high].code; // using the code of last element as pivot
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {
            // If current element is greater than or equal to pivot
            if (arr[j].code.compareTo(pivot) >= 0) {
                i++;
                // swap arr[i] and arr[j]
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i + 1] and arr[high]
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(Student arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static void printArray(Student arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println("Code: " + arr[i].code + ", Name: " + arr[i].name + ", Age: " + arr[i].age);
    }

    public static void main(String args[]) {
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        Student arr[] = new Student[n];

        System.out.println("Enter the details of each student: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter code, name and age for student " + (i+1));
            String code = sc.next();
            String name = sc.next();
            int age = sc.nextInt();
            arr[i] = new Student(code, name, age);
        }

        System.out.println("List of students before sorting: ");
        printArray(arr);

        sort(arr, 0, n-1);

        System.out.println("List of students after sorting: ");
        printArray(arr);
    }
}
