package yh.algorithm.sort.insertion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import yh.algorithm.sort.util.SortTestHelper;

/**
 * Insertion-Sort-Advance
 */

/**
 * 第一趟排序： 原始数据：0 11 3 20 9
 * 排序结果：0 11 3 20 9
 *
 * 第二趟排序： 原始数据：0 11 3 20 9
 * 排序结果：0 3 11 20 9
 *
 * 第三趟排序： 原始数据：0 3 11 20 9
 * 排序结果：0 3 9 11 20
 *
 * 第四趟排序： 原始数据：0 3 9 11 20
 * 排序结果：0 3 9 11 20
 */
public class InsertionSort
{
    // 我们的算法类不允许产生任何实例
    private InsertionSort()
    {
    }

    public static <T extends Comparable<T>> void sort(T[] arr)
    {

        int n = arr.length;
        for (int i = 0; i < n; i++)
        {

            // 寻找元素arr[i]合适的插入位置

            // 写法1
            //            for( int j = i ; j > 0 ; j -- )
            //                if( arr[j].compareTo( arr[j-1] ) < 0 )
            //                    swap( arr, j , j-1 );
            //                else
            //                    break;

            // 写法2
            //            for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
            //                swap(arr, j, j-1);

            // 写法3
            T e = arr[i];//保存当前位置i的元素，其中[0,i-1]已经有序
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(e) > 0; j--)
            {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }


    // 测试InsertionSort
    public static void main(String[] args)
    {

        int N = 5;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 20);
        //SortTestHelper.testSort("yh.algorithm.sort.insertion.InsertionSort", arr);

        // 测试排序算法辅助函数
        sort(arr);
        SortTestHelper.printArray(arr);
//        List<Integer> list = new ArrayList<>();
//
//        list.add(12);
//        //这里直接添加会报错
//        //list.add("a");
//        Class<? extends List> clazz = list.getClass();
//
//        //但是通过反射添加，是可以的
//        try
//        {
//            Method add = clazz.getDeclaredMethod("add", Object.class);
//            add.invoke(list, "kl");
//        }
//        catch (IllegalAccessException e)
//        {
//            e.printStackTrace();
//        }
//        catch (InvocationTargetException e)
//        {
//            e.printStackTrace();
//        }
//        catch (NoSuchMethodException e)
//        {
//            e.printStackTrace();
//        }
//
//        System.out.println(list);
    }
}
