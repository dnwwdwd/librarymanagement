package view;

import view.Management.BookManage;
import view.Management.BorrowManage;
import view.Management.StuManage;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainView extends JFrame {
    private HashMap<String,String> adminhashMap=new HashMap<>();
    private HashMap<String,String> readerhashMap=new HashMap<>();
    JLabel welcome=new JLabel("欢迎来到图书管理系统");
    JLabel username=new JLabel("用户名");
    JLabel password=new JLabel("密码");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JTextField usernamefield=new JTextField(10);
    JPasswordField passwordfield=new JPasswordField(10);
    JButton exit=new JButton("登出");
    JButton adminregister=new JButton("管理员注册");
    JButton readerregister=new JButton("读者注册");
    JButton stumanage=new JButton("读者管理");
    JButton bookmanage=new JButton("书库管理");
    JButton borrowmanage=new JButton("借阅管理");
    public MainView() throws HeadlessException {
        this.setTitle("图书管理系统");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setVisible(true);
        GridBagConstraints constraintsleft=new GridBagConstraints();
        constraintsleft.gridx = 0; // 列为0
        constraintsleft.gridy = GridBagConstraints.RELATIVE; // 按钮的行相对于前一个按钮的行
        constraintsleft.anchor = GridBagConstraints.CENTER; // 设置水平方向上的位置居中
        constraintsleft.fill = GridBagConstraints.HORIZONTAL; // 填充水平方向
        /*constraintsleft.weightx = 0.5; // 水平方向上的权重为0.5*/
        constraintsleft.insets = new Insets(10, 5, 5, 100); // 设置按钮的内边距
        constraintsleft.ipadx = 10;

        GridBagConstraints constraintsright=new GridBagConstraints();
        constraintsright.gridx=1;
        constraintsright.gridy = GridBagConstraints.RELATIVE; // 按钮的行相对于前一个按钮的行
        constraintsright.anchor = GridBagConstraints.CENTER; // 设置水平方向上的位置居中
        constraintsright.fill = GridBagConstraints.HORIZONTAL; // 填充水平方向
        /*constraintsleft.weightx = 0.5; // 水平方向上的权重为0.5*/
        constraintsright.insets = new Insets(10, 100, 5, 5); // 设置按钮的内边距
        constraintsright.ipadx = 10;

        this.add(stumanage,constraintsleft);
        this.add(bookmanage,constraintsleft);
        this.add(borrowmanage,constraintsleft);

        this.add(welcome,constraintsright);
        p1.add(username);
        p1.add(usernamefield);
        p2.add(password);
        p2.add(passwordfield);
        p3.add(readerregister);
        p3.add(adminregister);
        this.add(p1,constraintsright);
        this.add(p2,constraintsright);
        this.add(p3,constraintsright);
        this.add(exit,constraintsright);
        exit.addActionListener(e -> {
            if(e.getSource()==exit){
                dispose();
            }
        });
        readerregister.addActionListener(e->{
            if(e.getSource()==readerregister){
                if(readerhashMap.containsKey(usernamefield.getText())&&readerhashMap.get(usernamefield.getText()).equals(passwordfield.getText())){
                    JOptionPane.showMessageDialog(null,"该账户已存在！","警告",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    readerhashMap.put(usernamefield.getText(),passwordfield.getText());
                    JOptionPane.showMessageDialog(null,"注册成功！","通知",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        adminregister.addActionListener(e -> {
            if(e.getSource()==adminregister){
                if(adminhashMap.containsKey(usernamefield.getText())&&adminhashMap.get(usernamefield.getText()).equals(passwordfield.getText())){
                    JOptionPane.showMessageDialog(null,"该账户已存在！","警告",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    adminhashMap.put(usernamefield.getText(),passwordfield.getText());
                    JOptionPane.showMessageDialog(null,"注册成功！","通知",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        stumanage.addActionListener(e->{
            if(!adminhashMap.containsKey(usernamefield.getText())){
                JOptionPane.showMessageDialog(null,"管理员用户名不存在，请注册！","警告",JOptionPane.WARNING_MESSAGE);
            }
            else{
                if(adminhashMap.get(usernamefield.getText()).equals(passwordfield.getText())){
                    JOptionPane.showMessageDialog(null,"登陆成功！","通知",JOptionPane.INFORMATION_MESSAGE);
                    StuManage stuManage=new StuManage();
                    stuManage.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"密码错误，请重新输入！","警告",JOptionPane.WARNING_MESSAGE);
            }
        });
        bookmanage.addActionListener(e->{
            if(!adminhashMap.containsKey(usernamefield.getText())){
                JOptionPane.showMessageDialog(null,"管理员用户名不存在，请注册！","警告",JOptionPane.WARNING_MESSAGE);
            }
            else{
                if(adminhashMap.get(usernamefield.getText()).equals(passwordfield.getText())){
                    JOptionPane.showMessageDialog(null,"登陆成功！","通知",JOptionPane.INFORMATION_MESSAGE);
                    BookManage bookManage=new BookManage();
                    bookManage.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"密码错误，请重新输入！","警告",JOptionPane.WARNING_MESSAGE);
            }
        });
        borrowmanage.addActionListener(e->{
            if(!readerhashMap.containsKey(usernamefield.getText())){
                JOptionPane.showMessageDialog(null,"读者用户名不存在，请注册！","警告",JOptionPane.WARNING_MESSAGE);
            }
            else{
                if(readerhashMap.get(usernamefield.getText()).equals(passwordfield.getText())){
                    JOptionPane.showMessageDialog(null,"登陆成功！","通知",JOptionPane.INFORMATION_MESSAGE);
                    BorrowManage borrowManage=new BorrowManage();
                    borrowManage.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"密码错误，请重新输入！","警告",JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    public static void main(String[] args) {
        MainView mainView=new MainView();
    }
}
