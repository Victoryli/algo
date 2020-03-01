package com.sort;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-03-01 13:36
 */
public class MergeSortInversePairs {

    private static int count = 0; //逆序对计数

    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr,temp,0,arr.length - 1);
    }

    public static void  sort(int[] arr,int[] temp,int left,int right){
        if (left < right){
            int mid = left + (right - left) / 2;
            sort(arr,temp,left,mid);
            sort(arr,temp,mid + 1,right);
//            System.out.println(left + " " + right + " mid:" + mid);
            merge(arr,temp,left,mid,right);

        }
    }

    public static void  merge(int[] arr,int[] temp,int left,int mid,int right){

        int i = mid; // 将 i 指针指向 mid，即左边数组的最后一个元素
        int j = right; // 将 j 指针指向 right，即右边数组的最后一个元素
        int t = right - left;
//        System.out.println("t:" + t);
        while (i >= left && j >= mid+1){
            if (arr[i] > arr[j] ){
                count += j-mid; //逆序对计数
                temp[t--] = arr[i--];
            }

            else if (arr[j] >= arr[i]){
                temp[t--] = arr[j--];
            }
        }

        while (i >= left){
            temp[t--] = arr[i--];
        }

        while (j >= mid+1){
            temp[t--] = arr[j--];
        }
        t = right - left ;
        while (right >= left){
            arr[right--] = temp[t--];
        }
    }
    public static void main(String[] args) {
        int[] arr = {7,5,6,4,1,10};
        sort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println("共有逆序对： "+ count + " 个");
    }
}
