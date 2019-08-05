package com.wzq.lib;

import java.util.Arrays;

/**
 * 模拟考试
 * 作弊
 * 错题
 * 改题
 * 作弊
 * 备课
 */
public class MyClass {

    public static void main(String[] args) {

//        Print99();
//        reverseArr();   //数组反转
//        zhiJie();// 直接排序,也叫选择排序
//        maopao();
//        kuaiSu();
        erFen();


    }

    /**
     * 数组反转
     */
    private static void reverseArr() {
        int[] arr = {7, 3, 6, 8, 5, 4};
        System.out.println(Arrays.toString(arr));

        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        System.out.println(Arrays.toString(arr));


    }

    /**
     * 直接排序（选择排序）
     * 两层循环,两两比较,相互交换;
     */
    private static void zhiJie() {
        int[] arr = {7, 3, 6, 8, 5, 4};
        System.out.println(Arrays.toString(arr));
        //每次用1个元素与所有元素比较


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 二分查找（需要先对数组排序）
     */
    private static void erFen() {
        int[] arr = {7, 3, 6, 8, 5, 4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(halfSearch(arr, 5));

    }

    public static int halfSearch(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        int mid = (min + max) / 2;
        while (arr[mid] != key) {
            if (key > arr[mid]) {
                min = mid + 1;
            } else if (key < arr[mid]) {
                max = mid - 1;
            }
            if (min > max) {
                return -1;
            }
        }
        return mid;
    }

    /**
     * 将一个序列,排列成两个非空子序列
     * 一个子序列的元素都小于另外一个序列
     * 递归
     * 合并序列;
     */
    private static void kuaiSu() {

        int[] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};

        //算法开始
        sort(a, 0, a.length - 1);

        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }


    }

    public static void sort(int[] array, int low, int high) {
        int i, j;
        int index;
        if (low >= high) {
            return;
        }
        i = low;
        j = high;
        index = array[i]; // 下标为0的数;
        while (i < j) {
            while (i < j && array[j] >= index) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }

            while (i < j && array[i] < index) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = index;
        sort(array, low, i - 1);
        sort(array, i + 1, high);
    }

    /**
     * 第 0 趟：	1	5	4	3	2
     * <p>
     * 第 1 趟：	1	2	5	4	3
     * <p>
     * 第 2 趟：	1	2	3	5	4
     * <p>
     * 第 3 趟：	1	2	3	4	5
     * <p>
     * 最终排序  1	2	3	4	5
     */
    private static void maopao() {
        int[] array = {5, 4, 3, 2, 1};

        int temp = 0; // 用来交换的临时数


        // 要遍历的次数
        for (int i = 0; i < array.length - 1; i++) {
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = array.length - 1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];    //
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }

            //测试输出
            System.out.format("第 %d 趟：\t", i);
            for (int intTemp : array) {
                System.out.print(intTemp + "\t");
            }
            System.out.println("\n");

        }

        System.out.print("最终排序  ");

        for (int intTemp : array) {
            System.out.print(intTemp + "\t");
        }
    }

    private static void Print99() {

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }

            System.out.print("\n");
        }

    }
}
