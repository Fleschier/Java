package com;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("欢迎进入学生选课系统！");
        Java java = new Java(60,34,3.0);
        Python py = new Python(90,85,4.5);
        DataStructure ds = new DataStructure(120,80,5.0);
        AdvancedMathmatics am = new AdvancedMathmatics(100,99,5.0);
        System.out.println("所有可选课程如下：\n 1.Java\n 2.Python\n 3.数据结构\n 4.高等数学");
        System.out.print("请选择输入：1.查看课程信息 2.查看课程选课情况 3.选课\n 请输入序号：");

        Scanner scan = new Scanner(System.in);
        int tmp = scan.nextInt();
        while (tmp != 0){

            if(tmp == 1){
                System.out.print("请输入要查看的课程编号： ");
                int id = scan.nextInt();
                myUtils.showInfo(id,py,java,ds,am);
            }

            if(tmp == 2){
                System.out.print("请输入课程编号： ");
                int id = scan.nextInt();
                myUtils.showRemain(id,py,java,ds,am);
            }

            if(tmp == 3){
                System.out.print("请输入要选的课程编号： ");
                int id = scan.nextInt();
                boolean flag = myUtils.update(id,py,java,ds,am);
                if(flag) System.out.println("选课成功！");
                else{
                    System.out.println("选课失败！课程人数已满！");
                    myUtils.rollback(id,py,java,ds,am);  //回退选课人数 +1 的操作
                }
            }

            System.out.print("请选择输入：1.查看课程信息 2.查看课程选课情况 3.选课 0.退出选课\n 请输入序号：");
            tmp = scan.nextInt();
        }
    }
}

class myUtils{
    static  void showInfo(int id, Python py, Java java, DataStructure ds,AdvancedMathmatics am){
        if(id == 1) java.showInfo();
        if(id == 2) py.showInfo();
        if(id == 3) ds.showInfo();
        if(id == 4) am.showInfo();
    }

    static void showRemain(int id,Python py, Java java, DataStructure ds, AdvancedMathmatics am){
        if(id == 1) java.showRemaining();
        if(id == 2) py.showRemaining();
        if(id == 3) ds.showRemaining();
        if(id == 4) am.showRemaining();
    }

    static boolean update(int id,Python py, Java java, DataStructure ds, AdvancedMathmatics am){
        boolean flg = true;
        if(id == 1){
            int n= java.getSelected();
            java.setSelected(n + 1);
            if (java.getSelected() > java.getTotal()) flg = false;
        }
        if(id == 2){
            int n= py.getSelected();
            py.setSelected(n + 1);
            if (py.getSelected() > py.getTotal()) flg = false;
        }
        if(id == 3){
            int n= ds.getSelected();
            ds.setSelected(n + 1);
            if (ds.getSelected() > ds.getTotal()) flg = false;
        }
        if(id == 4){
            int n= am.getSelected();
            am.setSelected(n + 1);
            if (am.getSelected() > am.getTotal()) flg = false;
        }
        return flg;
    }

    static void rollback(int id,Python py, Java java, DataStructure ds, AdvancedMathmatics am){
        if(id == 1){
            int n= java.getSelected();
            java.setSelected(n - 1);
        }
        if(id == 2){
            int n= py.getSelected();
            py.setSelected(n - 1);
        }
        if(id == 3){
            int n= ds.getSelected();
            ds.setSelected(n - 1);
        }
        if(id == 4){
            int n= am.getSelected();
            am.setSelected(n - 1);
        }
    }
}

interface Calsses{
    void showInfo();//显示课程基本信息
    void showRemaining();//显示课程 已选/总量
}

class Lesson implements Calsses{
    private String name = ""; //课程名称
    private int total = 0; //总共
    private int selected = 0; //已选
    private double grade = 0; //学分


    public void setName(String s){
        name = s;
    }
    public void setTotal(int i){
        total = i;
    }
    public void setSelected(int i){
        selected = i;
    }
    public void setGrade(double i){
        grade = i;
    }
    public int getSelected(){
        return selected;
    }
    public int getTotal(){
        return total;
    }

    public void showInfo(){
        System.out.println("课程： " + name);
        System.out.println("总学分：" + grade);
    }
    public void showRemaining(){
        System.out.println("已选人数/开课总人数： " + selected + "/" + total);
    }
}

class Python extends Lesson{
    Python(int total, int selec, double grade){
        setName("Python");
        setGrade(grade);
        setSelected(selec);
        setTotal(total);
    }
}

class DataStructure extends Lesson{
    DataStructure(int total, int selec, double grade){
        setName("数据结构");
        setGrade(grade);
        setSelected(selec);
        setTotal(total);
    }
}

class Java extends Lesson{
    Java(int total, int selec, double grade){
        setName("Java");
        setGrade(grade);
        setSelected(selec);
        setTotal(total);
    }
}


class AdvancedMathmatics extends Lesson{
    AdvancedMathmatics(int total, int selec, double grade){
        setName("高等数学");
        setGrade(grade);
        setSelected(selec);
        setTotal(total);
    }
}
