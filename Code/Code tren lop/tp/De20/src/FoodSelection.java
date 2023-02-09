/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Scanner;

public class FoodSelection {

    static class Food implements Comparable<Food> {

        String name;
        String category;
        int price;

        Food(String name, String category, int price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        @Override
        public int compareTo(Food food) {
            // If the categories are different, compare the categories
            int categoryCompare = this.category.compareTo(food.category);
            if (categoryCompare != 0) {
                return categoryCompare;
            }
            // If the categories are the same, compare the prices
            return Integer.compare(this.price, food.price);
        }

        @Override
        public String toString() {
            return name + " (" + category + ", " + price + ")";
        }
    }

    static Food select(Food[] foods, int k) {
        // Quickselect algorithm
        int left = 0;
        int right = foods.length - 1;
        while (left <= right) {
            int pivotIndex = partition(foods, left, right);
            if (pivotIndex == k) {
                return foods[k];
            }
            if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return null;
    }

    static int partition(Food[] foods, int left, int right) {
        Food pivot = foods[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (foods[j].compareTo(pivot) <= 0) {
                i++;
                swap(foods, i, j);
            }
        }
        swap(foods, i + 1, right);
        return i + 1;
    }

    static void swap(Food[] foods, int i, int j) {
        Food temp = foods[i];
        foods[i] = foods[j];
        foods[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of foods: ");
        int n = sc.nextInt();
        Food[] foods = new Food[n];
        sc.nextLine(); // consume the remaining newline character
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of food " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter the category of food " + (i + 1) + ": ");
            String category = sc.nextLine();
            System.out.print("Enter the price of food " + (i + 1) + ": ");
            int price = sc.nextInt();
            sc.nextLine(); // consume the remaining newline character
            foods[i] = new Food(name, category, price);
        }
        System.out.print("Enter k: ");
    }
}

