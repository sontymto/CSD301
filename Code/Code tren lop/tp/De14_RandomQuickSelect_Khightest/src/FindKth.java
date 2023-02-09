import java.util.Random;

public class FindKth {
    public static void swap(Rhombuses [] arr, int i, int j){
        Rhombuses temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static Rhombuses findKthOrderUsingQuickSort(Rhombuses [] arr, int k) {
        if (k > arr.length || k < 1) {
            System.out.println("Invalid k parameter");
            return null;
        } else {
            Rhombuses [] temp = arr;
            quickSort(temp, 0, temp.length - 1, k);
            return temp[k - 1];
        }
    }

    // quick sort
    public static void quickSort(Rhombuses [] arr, int left, int right, int k) {
        Random rand = new Random();
        int rand_index =rand.nextInt(right - left + 1) + left;
        
        
        swap(arr, left, rand_index);
        if (left >= 0 && left <= right && right < arr.length && left < k && right >= k - 1) {
            int pivot = partition(arr, left, right);
            if (pivot == k - 1) {
                return;
            } else if (pivot > k - 1) {
                quickSort(arr, left, pivot - 1, k);
            } else {
                quickSort(arr, pivot + 1, right, k);
            }
        }
    }

    // partition
    public static int partition(Rhombuses[] arr, int left, int right) {
        
        if (left >= 0 && left <= right && right < arr.length) {
            Rhombuses pivot = arr[left];
            while (left < right) {
                while (left < right && arr[right].compareTo(pivot) <= 0) {
                    right--;
                }
                while (left < right && arr[left].compareTo(pivot) >= 0) {
                    left++;
                }
                if (left < right) {
                    swap(arr, left, right);
                }
            }
            arr[left] = pivot;
            return left;
        }
        return -1;
    }
}
