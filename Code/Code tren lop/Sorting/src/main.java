/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class main {
    public static void main(String args[]) {
        int [] data = {5,1,7,8,12,4,7,9};
        Sort.quickSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

}
