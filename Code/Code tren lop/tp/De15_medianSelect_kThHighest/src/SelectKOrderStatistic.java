//  Find kth order with O(n) time complexity
public class SelectKOrderStatistic {
    void swap(Course []a,int i, int j){
        Course temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void insertionSort(Course []a,int firstIndex,int lastIndex){
        if(0 <= firstIndex && firstIndex < lastIndex && lastIndex < a.length){
            for(int i = firstIndex + 1;i <= lastIndex;i++){
                Course x = a[i];
                int j = i- 1;
                while(j >= firstIndex && a[j].compareTo(x) > 0){
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1] = x;
            }
        }
       
    }
    public Course findMedian(Course [] a, int firstIndex, int lastIndex){
        if(firstIndex < 0 || lastIndex >= a.length || firstIndex > lastIndex){
            System.out.println("Input valid");
            return null;
        }else{
            int phanDu = (lastIndex-firstIndex+1) %5;
            int groups = (phanDu==0)?(lastIndex-firstIndex+1)/5:((lastIndex-firstIndex+1)/5 + 1);
            Course[] medians = new Course[groups];
            if(phanDu == 0){
                for (int i = 0; i < groups; i++) {
                    insertionSort(a, firstIndex+i*5, lastIndex+i*5+4);
                    medians[i] = a[firstIndex+i*5+2];
                }
            }else{
                for (int i = 0; i < groups-1; i++) {
                    insertionSort(a, firstIndex+i*5, lastIndex+i*5+4);
                    medians[i] = a[firstIndex+i*5+2];
                }
                insertionSort(a, firstIndex-phanDu+1, lastIndex);
                if(phanDu%2 == 0){
                    medians[groups-1] = a[lastIndex-phanDu/2+1];
                }else{
                    medians[groups-1] = a[lastIndex-phanDu/2];
                }
            }

            if(groups == 1){
                return medians[0];
            }else{
                return findMedian(medians, 0, groups-1);
            }
        }
    }
    public int partition(Course[] arr, int left, int right, Course pivot) {
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
                while (left < right && arr[right].compareTo(pivot) <= 0) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left].compareTo(pivot) >= 0) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = pivot;
            return left;
        }
        return -1;
    }
    public Course SelectKOrderHighest(Course [] a, int first, int last, int k){
        if(k > first && k <= last +1){
            if(first == last){
                return a[first];
            }else{
               Course median = findMedian(a, first, last);
                int pivotIndex = partition(a, first, last, median);
                
                if(pivotIndex + 1 == k){
                    return a[pivotIndex];
                }else if(k < pivotIndex + 1){
                        return SelectKOrderHighest(a, first, pivotIndex - 1, k);
                    }else{
                        return SelectKOrderHighest(a, pivotIndex + 1, last, k);
                    }
                }
        }
        return null;
    }

}
