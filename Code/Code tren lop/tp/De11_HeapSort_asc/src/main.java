public class main {
    public static void main(String[] args) {
        Circle[] arr = new Circle[10];
        arr[0] = new Circle("red", 1, 1, 1);
        arr[1] = new Circle("blue", 2, 1, 1);
        arr[2] = new Circle("green", 3, 1, 1);
        arr[3] = new Circle("pink", 4, 1, 1);
        arr[4] = new Circle("black", 5, 1, 1);
        arr[5] = new Circle("white", 6, 1, 1);
        arr[6] = new Circle("puple", 7, 1, 1);
        arr[7] = new Circle("red", 8, 1, 1);
        arr[8] = new Circle("red", 9, 1, 1);
        arr[9] = new Circle("orange", 10, 1, 1);
        HeapSort.sortFromHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
