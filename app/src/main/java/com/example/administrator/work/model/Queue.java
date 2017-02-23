package com.example.administrator.work.model;

/**
 * Created by Administrator on 2017/2/22.
 * 队列，先进先出，谁先来谁先走
 * 数据重复使用
 * 
 */
public class Queue {
    long []value;
    int max;
    int front_point;
    int end_point;
    int total;
    public Queue(int max){
        this.max=max;
        value=new long[max];
        front_point=0;
        end_point=-1;
        total=0;
    }

    /*插入*/
    public void insert(long number){
        if(!isFull()){
            total++;
            if(end_point<max-1)
            value[++end_point]=number;
            else {
                value[0]=number;
                end_point=0;
            }
        }
    }

    /*读取*/
    public long remove(){
        if(!isEmpty()){
            total--;
            long v=value[front_point];
            if(front_point<max-1)
                front_point++;
            else front_point=0;
            return v;
        }
        return 0;
    }

    /*查看*/
    public  long peek(){
        if(!isEmpty()){
            return value[front_point];
        }
        return 0;
    }

    public boolean isEmpty() {

        return (total==0);
    }

    public boolean isFull() {

        return (total==max);
    }

}
