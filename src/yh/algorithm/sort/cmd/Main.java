package yh.algorithm.sort.cmd;

import yh.algorithm.sort.util.SortTestHelper;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        basicSort();
        advanceSort();
    }

    //排序进阶
    private static void advanceSort()
    {

    }

    //普通排序
    private static void basicSort()
    {
        int N = 20000;

        // 比较SelectionSort和InsertionSort两种排序算法的性能效率
        // 此时，插入排序比选择排序性能略低
        System.out.println("插入排序优化前 Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("yh.algorithm.sort.selection.SelectionSort", arr1);
        SortTestHelper.testSort("yh.algorithm.sort.insertion.InsertionSort", arr2);


        // 比较SelectionSort和InsertionSort两种排序算法的性能效率
        // 优化后，插入排序比选择排序性能略好
        // 对于有序性强的数组，插入排序远远优于选择排序

        // 测试1 一般测试
        System.out.println("一般测试 Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr3 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr4 = Arrays.copyOf(arr3, arr3.length);
        Integer[] arr5 = Arrays.copyOf(arr3, arr3.length);
        Integer[] arr6 = Arrays.copyOf(arr3, arr3.length);

        SortTestHelper.testSort("yh.algorithm.sort.selection.SelectionSort", arr3);
        SortTestHelper.testSort("yh.algorithm.sort.insertion.InsertionSort", arr4);
        SortTestHelper.testSort("yh.algorithm.sort.bubble.BubbleSort", arr5);
        SortTestHelper.testSort("yh.algorithm.sort.shell.ShellSort", arr6);

        System.out.println();


        // 测试2 有序性更强的测试
        System.out.println("有序性更强的测试 Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr3 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr4 = Arrays.copyOf(arr3, arr3.length);
        arr5 = Arrays.copyOf(arr3, arr3.length);
        arr6 = Arrays.copyOf(arr3, arr3.length);

        SortTestHelper.testSort("yh.algorithm.sort.selection.SelectionSort", arr3);
        SortTestHelper.testSort("yh.algorithm.sort.insertion.InsertionSort", arr4);
        SortTestHelper.testSort("yh.algorithm.sort.bubble.BubbleSort", arr5);
        SortTestHelper.testSort("yh.algorithm.sort.shell.ShellSort", arr6);

        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr3 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr4 = Arrays.copyOf(arr3, arr3.length);
        arr5 = Arrays.copyOf(arr3, arr3.length);
        arr6 = Arrays.copyOf(arr3, arr3.length);

        SortTestHelper.testSort("yh.algorithm.sort.selection.SelectionSort", arr3);
        SortTestHelper.testSort("yh.algorithm.sort.insertion.InsertionSort", arr4);
        SortTestHelper.testSort("yh.algorithm.sort.bubble.BubbleSort", arr5);
        SortTestHelper.testSort("yh.algorithm.sort.shell.ShellSort", arr6);
    }
}
