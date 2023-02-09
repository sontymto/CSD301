public class kthOrder {
    // Finds the k-th order value in the given array using heap sort.
    public static int findKthOrderUsingHeap(int[] arr, int k) {
        if (k > arr.length || k < 1) {
            System.out.println("Invalid k parameter");
            return -1; // Invalid k value.
        } else {
            int[] temp = arr; // Temporary array to store the sorted elements.
            heapify(temp); // Heapify the temporary array.
            sortFromHeap(temp, k); // Sort the heapified array.
            return temp[0]; // Return the k-th order value.
        }
    }

    // Swaps two elements of the array.
    public static void swap(int[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Heapify the given array.
    public static void heapify(int[] arr) {
        int i, son, parent;
        for (i = 1; i < arr.length; i++) {
            son = i;
            parent = (son - 1) / 2;
            while (son > 0 && arr[son] > arr[parent]) {
                swap(arr, son, parent);
                son = parent;
                parent = (son - 1) / 2;
            }
        }
    }

    // Sorts the k largest elements from the heapified array.
    public static void sortFromHeap(int[] arr, int k) {
        int i, parent, maxSon;
        for (i = arr.length - 1; i > arr.length - k; i--) {
            swap(arr, i, 0);
            parent = 0;
            maxSon = parent * 2 + 1; // left son
            // if right son greater than left son
            if (maxSon + 1 < i && arr[maxSon] < arr[maxSon + 1]) {
                maxSon++;
            }
            while (maxSon < i && arr[maxSon] > arr[parent]) {
                swap(arr, maxSon, parent);
                parent = maxSon;
                maxSon = parent * 2 + 1; // left son
                // if right son greater than left son
                if (maxSon + 1 < i && arr[maxSon] < arr[maxSon + 1]) {
                    maxSon++;
                }
            }
        }
    }

    /* 
    * findKthOrderUsingQuickSort function finds the kth smallest element in an
    * array "arr"
    * using quick sort. If the input k is greater than the length of the array or
    * less than 1,
    * it prints "Invalid k parameter" and returns -1. Otherwise, it sorts the array
    * using
    * quickSort function, and returns the kth smallest element.
    */
    public static int findKthOrderUsingQuickSort(int[] arr, int k) {
        if (k > arr.length || k < 1) {
            System.out.println("Invalid k parameter");
            return -1;
        } else {
            int[] temp = arr;
            quickSort(temp, 0, temp.length - 1, k);
            return temp[k - 1];
        }
    }

    /*  
    * quickSort function sorts an array "arr" between left and right indices.
    * The k parameter represents the kth smallest element to find. The function
    * only sorts the elements between left and right indices that are necessary to
    * find the kth smallest element.
    */
    public static void quickSort(int[] arr, int left, int right, int k) {
        if (left >= 0 && left <= right && right < arr.length && left < k && right >= k - 1) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == k - 1) {
                // If the pivotIndex is equal to k - 1, then the pivot is the kth smallest
                // element
                return;
            } else if (pivotIndex > k - 1) {
                // If the pivotIndex index is greater than k - 1, the kth smallest element is in the
                // left partition
                quickSort(arr, left, pivotIndex - 1, k);
            } else {
                // If the pivotIndex index is less than k - 1, the kth smallest element is in the
                // right partition
                quickSort(arr, pivotIndex + 1, right, k);
            }
        }
    }

    /* 
    * partition function partitions the array "arr" between left and right indices
    * around a pivot
    * It returns the final index of the pivot element 
    */
    public static int partition(int[] arr, int left, int right) {
        if (left >= 0 && left <= right && right < arr.length) {
            int pivot = arr[left];
            // pivot is taken as the first element
            while (left < right) {
                // move the right pointer to the left until a smaller element than pivot is
                // found
                while (left < right && arr[right] >= pivot) {
                    right--;
                }
                arr[left] = arr[right];
                // move the left pointer to the right until a larger element than pivot is found
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = pivot;
            // put pivot at its final position
            return left;
        }
        return -1;
    }

}
