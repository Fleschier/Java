package com.fleschier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.fleschier.GUI_01.*;

public class GUI_02 {
    public static void main(String[] args){
        JFrame frame = new JFrame("用户登录");
        // Setting the width and height of frame
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);

        JFrame lessons = new JFrame("课程信息");
        lessons.setSize(800,500);
        lessons.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel lessP = new JPanel();
        lessons.add(lessP);

        JFrame math = new JFrame("高等数学");
        math.setSize(800,500);
        math.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mathP = new JPanel();
        math.add(mathP);

        JFrame dataStructure = new JFrame("数据结构");
        dataStructure.setSize(800,500);
        dataStructure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel dsP = new JPanel();
        dataStructure.add(dsP);

        JFrame Java = new JFrame("Java语言与程序设计");
        Java.setSize(800,500);
        Java.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel javaP = new JPanel();
        Java.add(javaP);


        JFrame reslt = new JFrame("选课结果");
        reslt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reslt.setSize(400,250);
        JPanel resP = new JPanel();
        reslt.add(resP);

        //自定义布局
        GUI_01.placeComponents(panel,lessons);

        lessnSet(lessP,math,dataStructure,Java);

        commonSet(mathP,"高等数学","4","150",reslt);
        commonSet(dsP,"数据结构","4","78",reslt);
        commonSet(javaP,"Java语言与程序设计","2.5","140",reslt);

        resSet(resP);

        //设置主界面可见
        frame.setVisible(true);
    }

    private static void lessnSet(JPanel panel, JFrame mathF, JFrame dsF, JFrame javaF){
        panel.setLayout(null);

        JLabel pre = new JLabel("可选课程如下：");
        pre.setBounds(50,40,200,20);

        JButton math = new JButton("高等数学");
        math.setBounds(100,100,400,100);
        math.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mathF.setVisible(true);
            }
        });

        JButton datastuc = new JButton("数据结构");
        datastuc.setBounds(100,210,400,100);
        datastuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dsF.setVisible(true);
            }
        });

        JButton Java = new JButton("Java语言与程序设计");
        Java.setBounds(100,320,400,100);
        Java.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                javaF.setVisible(true);
            }
        });

        panel.add(pre);
        panel.add(math);
        panel.add(datastuc);
        panel.add(Java);
    }

    private static void commonSet(JPanel panel, String name, String grade, String total, JFrame res){
        panel.setLayout(null);

        JLabel Jname = new JLabel("课程名称： "+ name);
        Jname.setBounds(50,20,200,50);

        JLabel Jgrade = new JLabel("学分： " + grade);
        Jgrade.setBounds(50,90,200,50);

        JLabel Jtotal = new JLabel("总开课人数： " + total);
        Jtotal.setBounds(50,160,200,50);

        JButton selec = new JButton("确定选课");
        selec.setBounds(250,300,100,30);
        selec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                res.setVisible(true);
            }
        });

        panel.add(Jname);
        panel.add(Jgrade);
        panel.add(Jtotal);
        panel.add(selec);
    }

    private static void resSet(JPanel panel){
        panel.setLayout(null);

        JLabel info = new JLabel("选课成功！");
        info.setBounds(160,90,100,20);

        panel.add(info);
    }
}
