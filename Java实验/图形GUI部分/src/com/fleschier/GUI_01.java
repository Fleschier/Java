package com.fleschier;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_01 {

    public static void main(String[] args){

        // 创建 JFrame 实例
        JFrame frame = new JFrame("用户登录");
        // Setting the width and height of frame
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);

        //生成第二个界面
        JFrame choice = new JFrame("欢迎选购家电！");
        choice.setSize(800,500);
        choice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel cPanel = new JPanel();
        choice.add(cPanel);

        //elecDryer页面
        JFrame elecDryer = new JFrame("吹风机信息");
        elecDryer.setSize(800,500);
        elecDryer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel dPanel = new JPanel();
        elecDryer.add(dPanel);
        String dInfo = "";

        //elecKettle页面
        JFrame elecKettle = new JFrame("电水壶信息");
        elecKettle.setSize(800,500);
        elecKettle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel kPanel = new JPanel();
        elecKettle.add(kPanel);

        //elecFan页面
        JFrame elecFan = new JFrame("电风扇");
        elecFan.setSize(800,500);
        elecFan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel fPanel = new JPanel();
        elecFan.add(fPanel);

        //airCleaner页面
        JFrame airCleaner = new JFrame("空气净化器");
        airCleaner.setSize(800,500);
        airCleaner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel aPanel = new JPanel();
        airCleaner.add(aPanel);

        //购买成功页面
        JFrame purch = new JFrame("结果页面");
        purch.setSize(400,250);
        purch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel res = new JPanel();
        purch.add(res);



        //调用用户定义的方法并添加组件到面板
        //登录界面设置
        placeComponents(panel,choice);
        //选择页面设置
        choiceSetUp(cPanel,elecDryer,elecFan,elecKettle,airCleaner);
        //信息页面设置
        commonSetUp(dPanel,"电吹风","白色","54","1000",purch);
        commonSetUp(kPanel,"电水壶","不锈钢","210","1200",purch);
        commonSetUp(fPanel,"电风扇","白色","80","120",purch);
        commonSetUp(aPanel,"空气净化器","白色","3100","1200",purch);
        //购买结果页面设置
        resultSet(res);


        // 设置界面可见
        frame.setVisible(true); //执行到这一个语句时才会产生界面
    }

    public static void placeComponents(JPanel panel, JFrame choice) {

        // 这边设置布局为 null
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("User:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);   //将标签放到窗口中

        // 创建文本域用于用户输入
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        //设置监听器
        //当点击按钮时产生动作
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //监听器只有这个方法需要重写，这个方法中会定义触发监听器之后要执行的内容
                choice.setVisible(true);
            }
        });
    }

    private static void choiceSetUp(JPanel cPanel, JFrame elecDryer, JFrame elecFan, JFrame elecKettle, JFrame airCleaner){
        cPanel.setLayout(null);

        JLabel label = new JLabel("请选择家电：");
        label.setBounds(100,30,200,25);
        cPanel.add(label);          //每次新建一个部分都要把他加到panel（面板）中。

        JButton elec_dryer = new JButton("电吹风");
        elec_dryer.setBounds(100,80,200,50);
        cPanel.add(elec_dryer);
        elec_dryer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                elecDryer.setVisible(true);
            }
        });

        JButton elec_kettle = new JButton("电水壶");
        elec_kettle.setBounds(100,140,200,50);
        cPanel.add(elec_kettle);
        elec_kettle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                elecKettle.setVisible(true);
            }
        });


        JButton elec_fan = new JButton("电风扇");
        elec_fan.setBounds(100,200,200,50);
        cPanel.add(elec_fan);
        elec_fan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                elecFan.setVisible(true);
            }
        });


        JButton air_cleaner = new JButton("空气净化器");
        air_cleaner.setBounds(100,260,200,50);
        cPanel.add(air_cleaner);
        air_cleaner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                airCleaner.setVisible(true);
            }
        });
    }

    private static void commonSetUp(JPanel jPanel, String name, String color, String price, String power, JFrame purchase){
        jPanel.setLayout(null);

        JLabel pre = new JLabel("详细信息如下：");
        pre.setBounds(50,20,300,40);

        JLabel sname = new JLabel("名称： "+name);
        sname.setBounds(50,70,300,40);

        JLabel scolor = new JLabel("颜色: " + color);
        scolor.setBounds(50,120,300,40);

        JLabel pow = new JLabel("功率: " + power + " w");
        pow.setBounds(50,170,300,40);

        JLabel pri = new JLabel("价格: " + price + " 元");
        pri.setBounds(50,220,300,40);

        JButton get = new JButton("立即购买");
        get.setBounds(70,300,100,40);
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                purchase.setVisible(true);
            }
        });

        jPanel.add(pre);
        jPanel.add(sname);
        jPanel.add(scolor);
        jPanel.add(pow);
        jPanel.add(pri);
        jPanel.add(get);
    }

    private static void resultSet(JPanel res){

        res.setLayout(null);
        JLabel succ = new JLabel("购买成功!");
        succ.setBounds(150,80,100,40);
        res.add(succ);
    }

}
