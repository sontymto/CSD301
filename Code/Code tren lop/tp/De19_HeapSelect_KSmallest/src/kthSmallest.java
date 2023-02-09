public class kthSmallest {
    public Date findKthOrderUsingHeap(Date[] arr, int k) {
        if (k > arr.length || k < 1) {
            System.out.println("Invalid k parameter");
            return null;
        } else {
            Date[] temp = arr;
            heapify(temp);
            sortFromHeap(temp, k);
            return temp[0];
        }
    }

    public void swap(Date[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            Date temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void heapify(Date[] arr) {
        int i, son, parent;
        for (i = 1; i < arr.length; i++) {
            son = i;
            parent = (son - 1) / 2;
            while (son > 0 && arr[son].compareTo(arr[parent])<0) {
                swap(arr, son, parent);
                son = parent;
                parent = (son - 1) / 2;
            }
        }
    }

    public void sortFromHeap(Date[] arr, int k) {
        int parent, minSon;
        for (int i = arr.length - 1; i > arr.length - k; i--) {
            swap(arr, i, 0);
            parent = 0;
            minSon = parent * 2 + 1; // left son
            // if right son greater than left son
            if (minSon + 1 < i && arr[minSon].compareTo(arr[minSon + 1])>0) {
                minSon++;
            }
            while (minSon < i && arr[minSon].compareTo(arr[parent])<0) {
                swap(arr, minSon, parent);
                parent = minSon;
                minSon = parent * 2 + 1; // left son
                // if right son greater than left son
                if (minSon + 1 < i &&  arr[minSon].compareTo(arr[minSon + 1])>0) {
                    minSon++;
                }
            }
        }

    }
}
