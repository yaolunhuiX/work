package com.example.administrator.work.model;

/**
 * Created by Administrator on 2017/2/22.
 * 栈,先进后出，先处理新的，最后处理旧的
 */
public class StackX {
    private char ch[];
    private  int pos;
   public  StackX(){
        ch=new char[100];
        pos=-1;
    }
    public void push(char ch){
        if(!isFull()){
            this.ch[++pos]=ch;
        }
    }

    public char pop(){
        if(!isEmpty()){
            return ch[pos--];
        }
        return '0';
    }

    public char watch(){
        if(!isEmpty()){
            return ch[pos];
        }
        return '0';
    }
    public boolean isEmpty() {
        return (pos==-1);
    }

    public boolean isFull() {
       return (pos==99);
    }

}
