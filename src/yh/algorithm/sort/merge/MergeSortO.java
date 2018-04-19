package yh.algorithm.sort.merge;

import yh.algorithm.sort.insertion.InsertionSort;
import yh.algorithm.sort.util.SortTestHelper;


import static yh.algorithm.sort.merge.MergeSort.merge;

// 优化的Merge Sort算法
// 在课程中, 主要向大家介绍了归并排序的两个优化点
// 关于归并排序的更多优化, 请参考本章节后续的补充内容
public class MergeSortO
{
    // 我们的算法类不允许产生任何实例
    private MergeSortO() {}

    //外部调用排序
    public static <T extends Comparable<T>> void sort(T[] arr)
    {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    //内部使用排序
    //递归使用归并排序,对arr[l...r]的范围进行排序
    protected static <T extends Comparable<T>> void sort(T[] arr, int l, int r)
    {
        // 优化2: 对于小规模数组, 使用插入排序
        if (r - l <= 15)
        {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        //排序[l...mid]
        sort(arr, l, mid);
        //排序[mid+1.....r]
        sort(arr, mid + 1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
        {
            merge(arr, l, mid, r);
        }
    }


    // 测试MergeSort
    public static void main(String[] args)
    {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);
        SortTestHelper.testSort("yh.algorithm.sort.merge.MergeSortO", arr);
        sort(arr);
    }


}
