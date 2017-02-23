package com.example.administrator.work.model;

import android.util.Log;

/**
 * Created by Administrator on 2017/2/21.
 * 排序算法
 */
public class MathSqrt  {

    /**冒泡排序*/
    /**比较次数N*(N-1)/2=N²/2
     * 交换次数N²/4,比较的一半
     * 排序从小到大
     * */
    public static void Sort_bubble(int a[]){
        int temp;
       int length=a.length;
        int compare_total;
        for(int i=0;i<length;i++){
           compare_total=length-i;
            for(int j=1;j<compare_total;j++){
                if(a[j-1]>a[j]){
                    temp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }


    /**选择排序
     * 比较次数N²/2
     * 交换次数N
     * */

    public static void Sort_select(int a[]){
        //每次找出最小值
        int length=a.length;
        int temp;//最小值
        int dex;//位置
        for(int i=0;i< length-1;i++){
            temp=a[i];
            dex=i;

            for(int j=i+1;j<length;j++){
                if(temp>a[j]){
                    temp=a[j];
                    dex=j;
                }
            }
            a[dex]=a[i];
            a[i]=temp;
        }


    }
    /**插入排序
     * 比较次数N²/4
     * 最坏交换N²/2,最快N
     * */
    public static void Sort_insert(int a[])
    {
        //从小到大
          int length=a.length;
        int temp;
        for(int i=1;i<length;i++)
        {
            for(int j=0;j<i;j++){
                if(a[i]<a[j]){
                    temp=a[i];
                    //只插入一次，不多次移动,大家一起退
                    //移动数据,从j到i移动全部移动,a[i]需要保存i>j
                    System.arraycopy(a,j,a,j+1,i-j);//数据挪动
                    a[j]=temp;
                    break;//只交换一次
                }
            }
        }

    }







    /**归并排序*/
    public static void Sort_recursion(int a[]){
        int c[]=new int[a.length];
        mergesort(a,0,a.length-1,c);

    }

    private static void mergesort(int a[],int first,int last,int temp[]){
        if(first<last){
            int mid=(first+last)/2;
            mergesort(a,first,mid,temp);//左排序
            mergesort(a,mid+1,last,temp);//右排序
            mergeArray(a, first, mid, last,temp);//合并
        }


    }
    /**两个有序数组a[first,mid]和a[mid+1,last]合并到一个数组*/
    private static void mergeArray(int a[],int first,int mid,int last,int temp[]){
        //
        int i=first;
        int j=mid+1;
         int k=0;
        //---遍历所有,谁最小添加谁
        while(i<=mid && j<=last){
            if(a[i]<=a[j]){
              temp[k++]=a[i++];
            }else{
              temp[k++]=a[j++];
            }
        }
        while(i<=mid)temp[k++]=a[i++];
        while(j<=first)temp[k++]=a[j++];
        for( i=0;i<k;i++)a[i+first]=temp[i];
    }


    /**快速排序*/
    //第一步找到小于当前数，更换位置
    public static void Sort_quick(int a[]){
        quick_Sort(a,0,a.length-1);
    }
    private static void quick_Sort(int a[],int start,int end){

        if(start<end){
            int i=start;
            int j=end;
            int min=a[start];
            while(i<j){
                //从左找一个到小于min的 值右到左
                while(min>=a[j]&&i<j)j--;

                if(i<j)a[i++]=a[j];

                //找到一个大于min的值,左到右
                while(min<a[i]&&i<j)i++;

                if(i<j)a[j--]=a[i];
            }

            quick_Sort(a,start,i-1);
            quick_Sort(a,i+1,end);

        }
    }

/**二分查找
 * @value num必须是排序过的
 * @value value需要查找的值
 * */
    public static int find_num(int [] num,int value){
        int length=num.length;
        int upper_num=length-1;
        int lower_num=0;
        int center;
        int mode=num[0]>num[length-1]? 2:1; //1表示升序，2表示降序
        while(true){

            if(lower_num>upper_num)return length;//没找到
            center=upper_num+lower_num>>>1;
            Log.e("center: ","center值: "+center+" upper_num: "+upper_num+" lower_num: "+lower_num);
            Log.e("动态: ","num[center]: "+num[center]+" value: "+value);


            if(num[center]>value)if(mode==1)upper_num=center-1; else lower_num=center+1;
            else if(num[center]<value)if(mode==1)lower_num=center+1;else upper_num=center-1;



            else return center;

        }

    }

}
