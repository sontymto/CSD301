public class HeapSort {
    public static void heapSort(Circle[] arr) {
        heapify(arr);
        sortFromHeap(arr);
    }
    public static void swap(Circle[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            Circle temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public static void heapify(Circle[] arr) {
        int i, son, parent;
        for (i = 1; i < arr.length; i++) {
            son = i;
            parent = (son-1) / 2;
            while (son > 0 && arr[son].compareTo(arr[parent]) > 0) {
                swap(arr, son, parent);
                son = parent;
                parent = (son-1) / 2;
            }
        }
    }

    public static void sortFromHeap(Circle[] arr) {
        int i, parent, maxSon;
        for (i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            parent = 0;
            maxSon = parent * 2 + 1; // assume left son is greater right son
            
            // if right son greater than left son
            if (maxSon + 1 < i && arr[maxSon].compareTo(arr[maxSon + 1])<0) {
                maxSon++;
            }
            while (maxSon < i && arr[maxSon].compareTo(arr[parent]) > 0) {
                swap(arr, maxSon, parent);
                parent = maxSon;
                maxSon = parent * 2 + 1; // left son
                // if right son greater than left son
                if (maxSon + 1 < i && arr[maxSon].compareTo(arr[maxSon + 1])<0) {
                    maxSon++;
                }
            }
        }

    }
}
