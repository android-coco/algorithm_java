package yh.algorithm.sort.optional;

import java.util.Arrays;

/**
 * 逆序对 归并
 */
public class ReverseByMerge
{
    private int count = 0;     //逆数对的数量

    public <T extends Comparable<T>> void reverse(T[] arr)
    {
        int r = arr.length;
        reverse(arr, 0, r - 1);
    }

    //内部使用排序
    //递归使用归并排序,对arr[l...r]的范围进行排序
    private <T extends Comparable<T>> void reverse(T[] arr, int l, int r)
    {
        if (l >= r)
        {
            return;
        }
        int mid = (r + l) / 2;
        reverse(arr, l, mid);
        reverse(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
        {
            merge(arr, l, mid, r);
        }
    }


    private <T extends Comparable<T>> void merge(T[] arr, int l, int mid, int r)
    {
        //副本
        T[] aux = Arrays.copyOfRange(arr, l, r + 1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;

        for (int k = l; k <= r; k++)
        {
            if (i > mid)
            {   // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r)
            {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0)
            {
                count += mid - i + 1;
                // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else
            {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args)
    {
        ReverseByMerge reverseByMerge = new ReverseByMerge();
        Integer[] arr = {5,7,10,10,11,12,7,8,1,3,6,8};
        reverseByMerge.reverse(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(reverseByMerge.count);
    }

}
