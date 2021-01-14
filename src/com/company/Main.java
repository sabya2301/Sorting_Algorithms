package com.company;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
	// write your code here
//        int[] arr = {15, 2, 30,-4, 75, 16};

        int[] arr = new int[7];
        Random random = new Random();
        for(int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(90);
        }
        printArray(arr);
        shellSort(arr);
//        printArray(arr);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = 0;

        if(i == j) return;

        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr){
        for (int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\n");
    }

    public static void bubbleSort(int[] a){
        for(int i=a.length-1; i>0; --i){
            for(int j=0; j<i; ++j){
                if(a[j] > a[j+1])
                    swap(a, j, j+1);
            }
        }
    }

    public static void selectionSort(int[] a){
        int lasrgest =0;
        for(int i=a.length-1; i>0; i--){
            lasrgest=0;
            for(int j=1; j<=i; j++){
                if(a[j] > a[lasrgest])
                    lasrgest = j;
            }
            swap(a, lasrgest,i);
        }
    }


    /**
     * Insertion Sort is an inplace sorting(meaning the sorting takes place within the same array). We consider
     * two parts of the array, one sorted and one unsorted. Initially the element at index 0 is considered to be
     * the sorted part of the array(as it has only one element, it is by default sorted). Now, traverse the
     * unsorted part(from index 1 to the last index), and with each iteration, increase the sorted array length
     * (while decreasing the unsorted array length).
     */
    public static void insertionSort(int[] a){
        for(int i=1; i<a.length; i++){
            int n = a[i];

            int j;
            for(j=i; j>0 && a[j-1]>n; j--){
                a[j] = a[j-1];
            }
            a[j] = n;
        }
    }



    /**
The following is Shell Sort. It is an algorithm which is used to improve the performance of insertion sort
     (primarily used for this, but can be used to amplify other sorting techniques too). Insertion sort has a
     time complexity of about O(n^2). However, when the array is moderately sorted, it can be reduced to
     almost O(n) or O(nlog n). This, to moderately achieve the sorted array, is done by shell sort.

     In Insertion Sort, the adjacent elements(gap = 1) are only compared and then changed. However, if we increase
     the gap, the array becomes more sorted. Now, the gap is calculated by the formula 3^g - 1 <= 2n/3
     However, we are simply using n/2 in this implementation(n being the length of the array).
     So, eventually, the gap comes to 1, wherein this basically converts to insertion sort.
     In each iteration, we compare the element at the index j to j-gap, and keep on inserting them
     in the sorted part. Hence, one part of the array gets sorted before we achieve gap=1.
     */

    public static void shellSort(int[] a){
        for(int gap = a.length/2; gap>0; gap /= 2 ){            //gap is initially 3
            for(int i=gap; i<a.length; i++){
                int n= a[i];                                    //storing the value at ith index, incase it gets overwritten
                int j=i;

                while(j>= gap && a[j-gap]> n){                  //this is our sorted array part. So, basically, from index 3, our array gets sorted
                    a[j] = a[j-gap];
                    j -= gap;
                }
//                printArray(a);
                a[j] = n;                                       //inserting the element into the correct position into the sorted array
            }
        }
    }
}
