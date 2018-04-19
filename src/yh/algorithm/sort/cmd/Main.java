package yh.algorithm.sort.cmd;

import yh.algorithm.sort.merge.*;
import yh.algorithm.sort.quick.*;
import yh.algorithm.sort.util.SortTestHelper;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        quickSort();
        basicSort();
        advanceSort();
    }

    // 比较Merge Sort, MergeSortBU; 优化过的MergeSort和MergeSortBU
    // 以及三种快速排序算法的性能
    private static void quickSort()
    {
        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        SortTestHelper.testSort(MergeSortO.class.getName(), arr2);
        SortTestHelper.testSort(MergeSortBU.class.getName(), arr3);
        SortTestHelper.testSort(MergeSortBUO.class.getName(), arr4);
        SortTestHelper.testSort(QuickSort.class.getName(), arr5);
        SortTestHelper.testSort(QuickSort2Ways.class.getName(), arr6);
        SortTestHelper.testSort(QuickSort3Ways.class.getName(), arr7);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        SortTestHelper.testSort(MergeSortO.class.getName(), arr2);
        SortTestHelper.testSort(MergeSortBU.class.getName(), arr3);
        SortTestHelper.testSort(MergeSortBUO.class.getName(), arr4);
        SortTestHelper.testSort(QuickSort.class.getName(), arr5);
        SortTestHelper.testSort(QuickSort2Ways.class.getName(), arr6);
        SortTestHelper.testSort(QuickSort3Ways.class.getName(), arr7);

        System.out.println();


        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.testSort(MergeSort.class.getName(), arr1);
        SortTestHelper.testSort(MergeSortO.class.getName(), arr2);
        SortTestHelper.testSort(MergeSortBU.class.getName(), arr3);
        SortTestHelper.testSort(MergeSortBUO.class.getName(), arr4);
        // 在包含大量重复元素的情况下, QuickSort会退化成O(n^2)算法, 在这里不做执行
        //SortTestHelper.testSort(QuickSort.class.getName(), arr5);
        SortTestHelper.testSort(QuickSort2Ways.class.getName(), arr6);
        SortTestHelper.testSort(QuickSort3Ways.class.getName(), arr7);
    }

    //排序进阶
    private static void advanceSort()
    {
        int N = 50000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("yh.algorithm.sort.insertion.InsertionSort", arr1);
        SortTestHelper.testSort("yh.algorithm.sort.merge.MergeSort", arr2);
        SortTestHelper.testSort("yh.algorithm.sort.merge.MergeSort2", arr3);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 10;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("yh.algorithm.sort.insertion.InsertionSort", arr1);
        SortTestHelper.testSort("yh.algorithm.sort.merge.MergeSort", arr2);
        SortTestHelper.testSort("yh.algorithm.sort.merge.MergeSort2", arr3);
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
