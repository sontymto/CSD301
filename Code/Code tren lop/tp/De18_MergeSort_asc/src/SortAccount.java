public class SortAccount {
    public static void mergeSort(Account [] arr, int first, int last) {
        if (first >= 0 && first < last && last < arr.length) {
            int mid = (first + last) / 2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid + 1, last);
            merge(arr, first, mid, last);
        }
    }

    public static void merge(Account [] arr, int first, int mid, int last) {
        if (!(first >= 0 && (first <= mid) && (mid < last) && last < arr.length)) {
            return;
        }
        Account [] b = new Account[last - first + 1];
        int index1 = first;
        int index2 = mid + 1;
        int i = 0;
        while (index1 <= mid && index2 <= last) {
            if (arr[index1].compareTo(arr[index2]) < 0) {
                b[i] = arr[index1];
                i++;
                index1++;
            } else {
                b[i] = arr[index2];
                i++;
                index2++;
            }
        }
        if (index2 > last) {
            while (index1 <= mid) {
                b[i] = arr[index1];
                i++;
                index1++;
            }
        }
        if (index1 > mid) {
            while (index2 <= last) {
                b[i] = arr[index2];
                i++;
                index2++;
            }
        }
        for (i = first; i <= last; i++) {
            arr[i] = b[i - first];
        }
    }
}
