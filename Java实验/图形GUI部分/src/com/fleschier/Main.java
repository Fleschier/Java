package com.fleschier;

import java.util.*;  //引入scanner类

public class Main {
    public static void main(String args[]){
        System.out.println("欢迎选购商品！以下是所有商品的列表：");
        System.out.print("1.电吹风\n" + "2.电水壶\n" + "3.空气净化器\n" + "4.电风扇\n");

        //初始化商品信息
        elecDryer ed = new elecDryer(1000,"白色",54,9.1);
        elecFan ef = new elecFan(120,"黑色",240,8.9);
        elecKettle ek= new elecKettle(1500,"不锈钢",120,9.5);
        airCleaner ac = new airCleaner(300,"白色",3450,8.4);

        Scanner scan = new Scanner(System.in);
        System.out.print("如果要查看详细信息请输入1,如果要购买请输入2,如果要退出请输入0：");
        int tmp = scan.nextInt();
        while (tmp != 0){
            if (tmp == 1){
                System.out.print("请输入要查看的商品编号：");
                int n = scan.nextInt();
                myUtils.showInfo(ef,ek,ed,ac,n);
                System.out.print("如果要再次查看详细信息请输入1,如果要购买请输入2,如果要退出请输入0：");
            }
            if(tmp == 2){
                System.out.print("请输入要购买的商品编号以及购买数量，中间以空格间隔：");
                int id = scan.nextInt();
                int num = scan.nextInt();
                myUtils.showPrice(ef,ek,ed,ac,id,num);
                System.out.print("如果要查看详细信息请输入1,如果要继续购买请输入2,如果要退出请输入0：");
            }

            tmp = scan.nextInt();
        }
    }
}

class myUtils{
    static void showInfo(elecFan ef, elecKettle ek, elecDryer ed, airCleaner ac, int n){
        if(n == 1) ed.showDetail();
        if(n == 2) ek.showDetail();
        if(n == 3) ac.showDetail();
        if(n == 4) ef.showDetail();
    }

    static void showPrice(elecFan ef, elecKettle ek, elecDryer ed, airCleaner ac, int id, int num){
        if(id == 1) ed.showPrice(num);
        if(id == 2) ek.showPrice(num);
        if(id == 3) ac.showPrice(num);
        if(id == 4) ef.showPrice(num);
    }
}

interface machine{
    void setPower(double p);
    void setColor(String s);
    void setPrice(double p);
    void setJudge(double j);
    double getPower();
    String getColor();
    double getPrice();
    double getJudge();

}

class elecMachine implements machine{
    private double power = 0;
    private String color = "";
    private double price = 0;
    private double judgement = 0;

    public void setPower(double p){
        power = p;
    }
    public void setColor(String s){
        color = s;
    }
    public void setPrice(double p){
        price = p;
    }
    public void setJudge(double j){
        judgement = j;
    }
    public double getPower(){
        return power;
    }
    public String getColor(){
        return color;
    }
    public double getPrice(){
        return price;
    }
    public double getJudge(){
        return judgement;
    }
    public void showInfo(){
        System.out.println("功率:" + power + " w");
        System.out.println("颜色:" + color);
        System.out.println("价格:" + price + " 元");
        System.out.println("用户评分:" + judgement);
        System.out.println("使用说明详细见说明书 " );
    }
}

//电吹风
class elecDryer extends elecMachine{
    elecDryer(double p, String s, double pr, double j){  //默认构造函数
        setPower(p);
        setPrice(pr);
        setColor(s);
        setJudge(j);
    }

    public void showPrice(int n){
        System.out.println("品名: 电吹风");
        System.out.println("购买的数量:" + n);
        System.out.println("总价：" + n * this.getPrice());
    }
    public void showDetail(){
        System.out.println("品名: 电吹风");
        showInfo();
    }
}

//电水壶
class elecKettle extends elecMachine{
    elecKettle(double p, String s, double pr, double j){  //默认构造函数
        setPower(p);
        setPrice(pr);
        setColor(s);
        setJudge(j);
    }
    public void showPrice(int n){
        System.out.println("品名: 电水壶");
        System.out.println("购买的数量:" + n);
        System.out.println("总价：" + n * this.getPrice());
    }
    public void showDetail(){
        System.out.println("品名: 电水壶");
        showInfo();
    }
}

//空气净化器
class airCleaner extends elecMachine{
    airCleaner(double p, String s, double pr, double j){  //默认构造函数
        setPower(p);
        setPrice(pr);
        setColor(s);
        setJudge(j);
    }
    public void showPrice(int n){
        System.out.println("品名: 空气净化器");
        System.out.println("购买的数量:" + n);
        System.out.println("总价：" + n * this.getPrice());
    }
    public void showDetail(){
        System.out.println("品名: 空气净化器");
        showInfo();
    }
}

//电风扇
class elecFan extends elecMachine{
    elecFan(double p, String s, double pr, double j){  //默认构造函数
        setPower(p);
        setPrice(pr);
        setColor(s);
        setJudge(j);
    }
    public void showPrice(int n){
        System.out.println("品名: 电风扇");
        System.out.println("购买的数量:" + n);
        System.out.println("总价：" + n * this.getPrice());
    }
    public void showDetail(){
        System.out.println("品名: 电风扇");
        showInfo();
    }
}