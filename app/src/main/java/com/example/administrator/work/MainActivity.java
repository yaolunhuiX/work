package com.example.administrator.work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.work.model.MathSqrt;
import com.example.administrator.work.model.Queue;
import com.example.administrator.work.model.StackX;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {


                long [] ln={11,12,13,14,8,9,6,8,2,1,168,153};
                Queue queue=new Queue(12);
                for(long _ln:ln)
                queue.insert(_ln);
                long []__ln=new long[12];
                int m=0;
                while(!queue.isEmpty())__ln[m++]=queue.remove();
                for(int n=0;n<m;n++)System.out.println(__ln[n]);


                char ch[]={'a','b','c','d','e','f','g','h','i'};
                StackX stackX=new StackX();
                for (char _ch:ch)
                {
                    stackX.push(_ch);

                }

                char [] cm=new char[100];
                int j=0;

                while(!stackX.isEmpty()){
                    cm[j++]=stackX.pop();
                }
                for(int z=0;z<j;z++)System.out.println(cm[z]);

                int [] num=new int[100000];
                int [] num1=new int[num.length];//数组备份

                Random random=new Random();
                for(int i=0;i<num.length;i++){
                    num[i]=Math.abs(random.nextInt()%100);
                    num1[i]=num[i];
                }

                long front_time=System.currentTimeMillis();
                MathSqrt.Sort_bubble(num);
                long current_time=System.currentTimeMillis();
                long diff=current_time-front_time;
                System.out.println("冒泡排序时间为: "+diff+"毫秒");

                System.arraycopy(num1, 0, num, 0, num.length);//重新初始化num
                front_time=System.currentTimeMillis();

                MathSqrt.Sort_select(num);
                current_time=System.currentTimeMillis();
                diff=current_time-front_time;
                System.out.println("选择排序时间为: "+diff+"毫秒");


                System.arraycopy(num1, 0, num, 0, num.length);//重新初始化num
                front_time=System.currentTimeMillis();

                MathSqrt.Sort_insert(num);
                current_time=System.currentTimeMillis();
                diff=current_time-front_time;
                System.out.println("插入排序时间为: "+diff+"毫秒");

            //    for(int i=0;i<num.length;i++)System.out.println("num["+i+"]= "+num[i]);
            }
        }).start();






        new Thread(new Runnable() {
            @Override
            public void run() {



                //10万个数,30秒
                int num[]=new int[100000];
                Random random=new Random();
                for(int i=0;i<100000;i++){
                    num[i]=Math.abs(random.nextInt()%10000);
                }


                long front_time=System.currentTimeMillis();
                MathSqrt.Sort_bubble(num);
                long curent_time=System.currentTimeMillis();
                Log.e("冒泡排序时间毫秒: ",curent_time-front_time+"毫秒");

                for(int i=0;i<100000;i++){
                    num[i]=Math.abs(random.nextInt()%10000);
                }

                front_time=System.currentTimeMillis();
                MathSqrt.Sort_insert(num);
                curent_time=System.currentTimeMillis();
                Log.e("插入排序时间毫秒: ",curent_time-front_time+"毫秒");

                for(int i=0;i<100000;i++){
                    num[i]=Math.abs(random.nextInt()%10000);
                }

                front_time=System.currentTimeMillis();
                MathSqrt.Sort_select(num);
                curent_time=System.currentTimeMillis();
                Log.e("选择排序时间毫秒: ",curent_time-front_time+"毫秒");


                //for(int i=0;i<num.length;i++)Log.e("num: ","num["+i+"]="+num[i]);


                for(int i=0;i<num.length;i++){
                    num[i]= Math.abs(random.nextInt()%10000);
                }

                front_time=System.currentTimeMillis();
                MathSqrt.Sort_recursion(num);
                curent_time=System.currentTimeMillis();
                Log.e("选择归并时间毫秒: ",curent_time-front_time+"毫秒");
                for(int i=0;i<num.length;i++){
                    num[i]= Math.abs(random.nextInt()%10000);
                }
                front_time=System.currentTimeMillis();
                MathSqrt.Sort_quick(num);
                curent_time=System.currentTimeMillis();
                Log.e("选择快速时间毫秒: ",curent_time-front_time+"毫秒");

               for(int i=0;i<num.length;i++)Log.e("num: ","num["+i+"]="+num[i]);

                int dex=MathSqrt.find_num(num,num[1000]);
                if(dex!=num.length)
                Log.e("num ","1000位置是: num["+dex+"]"+"值为 "+num[dex]);
                else Log.e("num ","没有找到");
            }
        });//.start();



    }

}
