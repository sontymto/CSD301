public class MinMax {
    // results[0] luu min, results[1] luu max
    public void FindMinMax(int [] arr, int [] results){
        if(arr.length > 0){
            int min, max, i;
            if(arr.length % 2 == 0){
                if(arr[0] > arr[1]){
                    max = arr[0];
                    min = arr[1];
                }else{
                    max = arr[1];
                    min = arr[0];
                }
                i = 2;
            }else{
                max = min = arr[0];
                i = 1;
            }
            while(i < arr.length - 1){
                if(arr[i] > arr[i + 1]){
                    if(arr[i] > max){
                        max = arr[i];
                    }
                    if(arr[i + 1] < min){
                        min = arr[i + 1];
                    }
                }else{
                    if(arr[i + 1] > max){
                        max = arr[i + 1];
                    }
                    if(arr[i] < min){
                        min = arr[i];
                    }
                }
                i += 2;
            }
            results[0] = min;
            results[1] = max;

        }

    }
}
