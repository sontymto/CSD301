public class App {
    public static void main(String args[]) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int [] results = new int[2];
        MinMax minmax = new MinMax();
        minmax.FindMinMax(arr, results);
        System.out.printf("Minimum element is %d", results[0]);
        System.out.printf("\nMaximum element is %d\n", results[1]);

        SelectKOrderStatistic finOrder = new SelectKOrderStatistic();
        int k = 7;
            int result = finOrder.selectKOrder(arr, 0, arr.length - 1, k);
            System.out.println("The kth order is: " + result);
    }
}
