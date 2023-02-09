public class RandomQuickSort {
    // quick sort algorithm
    public static void quickSort(Car[] arr, int first, int last) {
        if (first >= 0 && first < last && last < arr.length) {
            int PivIndex;
            if (first < last) {
                PivIndex = partition(arr, first, last);
                quickSort(arr, first, PivIndex - 1);
                quickSort(arr, PivIndex + 1, last);
            }
        }
    }

    public static void swap(Car[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            Car temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int partition(Car [] arr, int left, int right) {
        if (left >= 0 && left <= right && right < arr.length) {
            int pivotIndex = (int) (Math.random() * (right - left + 1) + left);
            swap(arr, pivotIndex, left);
            Car pivot = arr[left];
            while (left < right) {
                while (left < right && arr[right].number.compareTo(pivot.number) <= 0) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left].number.compareTo(pivot.number) >= 0) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = pivot;
            return left;
        }
        return -1;
    }
}   
