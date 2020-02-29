package com.sort;

import java.util.Arrays;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-02-29 21:24
 */
public class MergeSort {



    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr,temp,0,arr.length-1);

    }

    public static void sort(int[] arr,int [] temp,int left,int right){

        if (left < right){

            int mid = left + (right - left) / 2; // 找到左右分割点
            sort(arr,temp,left,mid); // 左边的拆分
            sort(arr,temp,mid+1,right); // 右边的拆分
            merge(arr,temp,left,mid,right); // 左右两边合并
        }



    }

    public static void merge(int[] arr,int[] temp,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        int t = 0;

        while (i <= mid && j <= right){
            if (arr[i] < arr[j]){
                temp[t++] = arr[i++];
            }

            if (arr[j] < arr[i]){
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid){
            temp[t++] = arr[i++];
        }

        while (j <= right){
            temp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,4,2,6,8,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}


