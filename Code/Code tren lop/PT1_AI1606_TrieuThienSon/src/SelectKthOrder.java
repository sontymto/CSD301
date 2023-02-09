public class SelectKthOrder {
    public static void swap(Food[] a, int i, int j) {
        if (i >= 0 && i < a.length && j >= 0 && j < a.length) {
            Food temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void insertionSort(Food[] a, int first, int last) {
        if (0 <= first && first < last && last < a.length)
            for (int i = first + 1; i <= last; i++) {
                Food x = a[i];
                int j = i - 1;
                while (j >= first && a[j].compareTo(x) > 0) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = x;
            }
    }

    public static Food findMedian(Food[] a, int first, int last) {
        if (first < 0 || last >= a.length || first > last){
            System.out.println("Error in findMedian");
            return null;
        }
        else {
            int phanDu = (last - first + 1) % 5;
            int groups = (last - first + 1) / 5 + (phanDu == 0 ? 0 : 1);
            Food[] medians = new Food[groups];
            if (phanDu == 0) {
                for (int i = 0; i < groups; i++) {
                    insertionSort(a, first + i * 5, first + i * 5 + 4);
                    medians[i] = a[first + i * 5 + 2];
                }
            } else {
                // groups - 1 nhom dau tien
                for (int i = 0; i < groups - 1; i++) {
                    insertionSort(a, first + i * 5, first + i * 5 + 4);
                    medians[i] = a[first + i * 5 + 2];
                }
                // nhom cuoi cung
                insertionSort(a, last - phanDu + 1, last);
                if (phanDu % 2 == 0) {
                    medians[groups - 1] = a[last - (phanDu / 2) + 1];
                } else {
                    medians[groups - 1] = a[last - (phanDu / 2)];
                }
            }
            if (groups == 1)
                return medians[0];
            else
                return findMedian(medians, 0, groups - 1);
        }
    }

    // partition
    public static int partition(Food[] arr, int left, int right, Food pivot) {
        if (left >= 0 && left <= right && right < arr.length) {
            // find pivot index
            int pivotIndex = -1;
            for (int i = left; i <= right; i++) {
                if (arr[i].compareTo(pivot) == 0) {
                    pivotIndex = i;
                    break;
                }
            }
            swap(arr, pivotIndex, left);
            while (left < right) {
                while (left < right && arr[right].compareTo(pivot) >= 0) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left].compareTo(pivot) <= 0) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = pivot;
            return left;
        }
        return -1;
    }

    
    public static Food selectKOrder(Food[] a, int first, int last, int k) {
        if (k > first && k <= (last + 1) && first >= 0 && first <= last && last < a.length) {
            if (first == last)
                return a[first];
            else {
                Food median = findMedian(a, first, last);
                int pivotIndex = partition(a, first, last, median);
                if ((pivotIndex + 1) == k)
                    return a[pivotIndex];
                else if (k < pivotIndex + 1)
                    return selectKOrder(a, first, pivotIndex - 1, k);
                else
                    return selectKOrder(a, pivotIndex + 1, last, k);

            }

        }
        System.out.println("Error in selectKOrder");
        return null;
    }
}
