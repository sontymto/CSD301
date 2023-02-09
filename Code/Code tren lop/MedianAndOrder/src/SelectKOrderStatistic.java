public class SelectKOrderStatistic {
    public static void swap(int[] a, int i, int j) {
        if (i >= 0 && i < a.length && j >= 0 && j < a.length) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void insertionSort(int[] a, int firstIndex, int lastIndex) {
        if (0 <= firstIndex && firstIndex < lastIndex && lastIndex < a.length)
            for (int i = firstIndex + 1; i <= lastIndex; i++) {
                int x = a[i];
                int j = i - 1;
                while (j >= firstIndex && a[j] > x) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = x;
            }
    }

    public static int findMedian(int[] a, int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= a.length || firstIndex > lastIndex)
            return -1;
        else {
            int phanDu = (lastIndex - firstIndex + 1) % 5;
            int groups = (lastIndex - firstIndex + 1) / 5 + (phanDu == 0 ? 0 : 1);
            int[] medians = new int[groups];
            if (phanDu == 0) {
                for (int i = 0; i < groups; i++) {
                    insertionSort(a, firstIndex + i * 5, firstIndex + i * 5 + 4);
                    medians[i] = a[firstIndex + i * 5 + 2];
                }
            } else {
                // groups - 1 nhom dau tien
                for (int i = 0; i < groups - 1; i++) {
                    insertionSort(a, firstIndex + i * 5, firstIndex + i * 5 + 4);
                    medians[i] = a[firstIndex + i * 5 + 2];
                }
                // nhom cuoi cung
                insertionSort(a, lastIndex - phanDu + 1, lastIndex);
                if (phanDu % 2 == 0) {
                    medians[groups - 1] = a[lastIndex - (phanDu / 2) + 1];
                } else {
                    medians[groups - 1] = a[lastIndex - (phanDu / 2)];
                }
            }
            if (groups == 1)
                return medians[0];
            else
                return findMedian(medians, 0, groups - 1);
        }
    }

    // partition
    public static int partition(int[] arr, int left, int right, int pivot) {
        if (left >= 0 && left <= right && right < arr.length) {
            // find pivot index
            int pivotIndex = -1;
            for (int i = left; i <= right; i++) {
                if (arr[i] == pivot) {
                    pivotIndex = i;
                    break;
                }
            }
            swap(arr, pivotIndex, left);
            while (left < right) {
                while (left < right && arr[right] >= pivot) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= pivot) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = pivot;
            return left;
        }
        return -1;
    }

    // Quickselect
    public static int selectKOrder(int[] a, int first, int last, int k) {
        if (k > first && k <= (last + 1)) {
            if (first == last)
                return a[first];
            else {
                int median = findMedian(a, first, last);
                int pivotIndex = partition(a, first, last, median);
                if ((pivotIndex + 1) == k)
                    return a[pivotIndex];
                else if (k < pivotIndex + 1)
                    return selectKOrder(a, first, pivotIndex - 1, k);
                else
                    return selectKOrder(a, pivotIndex + 1, last, k);

            }

        }
        return -1;
    }

}
