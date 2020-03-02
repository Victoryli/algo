package com.sort;


import java.util.Arrays;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-03-02 22:59
 */
public class HeapSort {

    public static void swap(int[] arr, int m, int n) {
        int temp;
        temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static void heapify(int[] heap, int i,int heapLength) {
        int c1 = 2 * i + 1; // 第 i 个节点的左子节点的索引位置
        int c2 = 2 * i + 2; // 第 i 个节点的右子节点的索引位置
        int max = i; // 先定义第 i 个节点的值最大
        int len = heapLength;
        // 如果左子树大于第 i 个节点，那么就交换二者的值
        if (c1 <= len - 1 && heap[c1] > heap[i]) {
            max = c1;
            swap(heap, max, i);
        }
        // 如果右子树大于第 i 个节点，那么就交换二者的值
        if (c2 <= len - 1 && heap[c2] > heap[i]) {
            max = c2;
            swap(heap, max, i);
        }

    }
    // 建大顶堆
    public static void buildMaxHeap(int[] heap, int i,int heapLength) {
        // 如果该节点没有叶子节点，则直接返回
        if ((2 * i + 1) > heapLength-1) {
            return;
        }
        // 遍历每个节点做 heapify
        for (int j = 0; j < heapLength-1; j++) {
            heapify(heap, j,heapLength);
        }

    }

    public static void sortHeap(int[] heap){
        int len = heap.length ;
        // 建大顶堆
        buildMaxHeap(heap,0,len);

        for (int i = 0; i < heap.length; i++) {
            // 交换堆顶和最后一个元素的值
            swap(heap,0,len - 1);
            // 去掉最后一个元素，再次构建大顶堆
            buildMaxHeap(heap,0,--len);


        }

    }

    public static void main(String[] args) {
        int[] heap = {22, 33, 99, 88, 66};
        sortHeap(heap);
        System.out.println(Arrays.toString(heap));

    }

}
