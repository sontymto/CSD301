public class main {
    public static void main(String[] args) {
        kthSmallest kth = new kthSmallest();
        Date []dates = new Date[5];
        dates[0] = new Date(2019, 1, 1);
        dates[1] = new Date(2020, 4, 2);
        dates[2] = new Date(2010, 1, 3);
        dates[3] = new Date(2019, 5, 4);
        dates[4] = new Date(2022, 1, 5);
        Date ksmallest = kth.findKthOrderUsingHeap(dates, 6);
        System.out.println(ksmallest);
    }
}
