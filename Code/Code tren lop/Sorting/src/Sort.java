public class Sort {

    // Method to swap two elements in an array
    public static void swap(int[] arr, int i, int j) {
        // Check if both indices are within the bounds of the array
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            int temp = arr[i]; // Store the value of arr[i] in a temporary variable
            arr[i] = arr[j]; // Swap arr[i] with arr[j]
            arr[j] = temp; // Store the value of arr[i] in arr[j]
        }
    }

    // Quick Sort method
    public static void quickSort(int arr[], int first, int last) {
        // Check if first index is less than last index and both are within the bounds
        // of the array
        if (first >= 0 && first < last && last < arr.length) {
            int PivIndex;
            if (first < last) {
                // Get the pivot index
                PivIndex = partition(arr, first, last);
                // Recursively sort the elements on the left of the pivot
                quickSort(arr, first, PivIndex - 1);
                // Recursively sort the elements on the right of the pivot
                quickSort(arr, PivIndex + 1, last);
            }
        }
    }

    // Partition method to get the pivot index
    public static int partition(int[] arr, int left, int right) {
        if (left >= 0 && left <= right && right < arr.length) {
            // // Random pivot index
            // int pivotIndex = (int) (Math.random() * (right - left + 1) + left);
            // swap(arr, pivotIndex, left);
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

    /*
     * Merge Sort
     */
    public static void mergeSort(int[] arr, int first, int last) {
        // Check if the first and last indices are within bounds of the array and first
        // is less than last
        if (first >= 0 && first < last && last < arr.length) {
            // Calculate the middle index
            int mid = (first + last) / 2;
            // Recursively sort the left half of the array
            mergeSort(arr, first, mid);
            // Recursively sort the right half of the array
            mergeSort(arr, mid + 1, last);
            // Merge the sorted left and right halves
            merge(arr, first, mid, last);
        }
    }

    public static void merge(int[] arr, int first, int mid, int last) {
        // Check if the first, mid, and last indices are within bounds of the array and
        // first <= mid < last
        if (first >= 0 && (first <= mid) && (mid < last) && last < arr.length) {

            // Initialize a temporary array to store the merged values
            int[] b = new int[last - first + 1];
            // Indexes for the left and right halves of the array
            int index1 = first;
            int index2 = mid + 1;
            // Index for the temporary array
            int i = 0;
            // Merge the two sorted halves into the temporary array
            while (index1 <= mid && index2 <= last) {
                if (arr[index1] < arr[index2]) {
                    b[i] = arr[index1];
                    i++;
                    index1++;
                } else {
                    b[i] = arr[index2];
                    i++;
                    index2++;
                }
            }
            // Add any remaining elements from the left half to the temporary array
            if (index2 > last) {
                while (index1 <= mid) {
                    b[i] = arr[index1];
                    i++;
                    index1++;
                }
            }
            // Add any remaining elements from the right half to the temporary array
            if (index1 > mid) {
                while (index2 <= last) {
                    b[i] = arr[index2];
                    i++;
                    index2++;
                }
            }
            // Copy the elements from the temporary array back to the original array
            for (i = first; i <= last; i++) {
                arr[i] = b[i - first];
            }
        }
    }

    /*
     * Heap Sort
     */
    public static void heapSort(int[] arr) {
        // Initialize heap structure
        heapify(arr);
        // Sort elements from the heap
        sortFromHeap(arr);
    }

    public static void heapify(int[] arr) {
        // Create a heap structure from the array
        int i, son, parent;
        for (i = 1; i < arr.length; i++) {
            // Start from the last element and move towards the first element
            son = i;
            // Get the parent of the current element
            parent = (son - 1) / 2;
            // Keep swapping the current element with the parent until it is greater than
            // the parent
            while (son > 0 && arr[son] > arr[parent]) {
                swap(arr, son, parent);
                son = parent;
                parent = (son - 1) / 2;
            }
        }
    }

    public static void sortFromHeap(int[] arr) {
        // Sort elements from the heap
        int i, parent, maxSon;
        for (i = arr.length - 1; i > 0; i--) {
            // Swap the first and the last element
            swap(arr, i, 0);
            // Set the current parent to the first element
            parent = 0;
            // Get the left son
            maxSon = parent * 2 + 1;
            // Check if right son is greater than left son and set the maxSon accordingly
            if (maxSon + 1 < i && arr[maxSon] < arr[maxSon + 1]) {
                maxSon++;
            }
            // Keep swapping the parent with the maxSon until the maxSon is less than or
            // equal to the parent
            while (maxSon < i && arr[maxSon] > arr[parent]) {
                swap(arr, maxSon, parent);
                parent = maxSon;
                maxSon = parent * 2 + 1;
                // Check if right son is greater than left son and set the maxSon accordingly
                if (maxSon + 1 < i && arr[maxSon] < arr[maxSon + 1]) {
                    maxSon++;
                }
            }
        }
    }

}
