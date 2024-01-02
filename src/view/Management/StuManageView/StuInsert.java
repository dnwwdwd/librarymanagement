package view.Management.StuManageView;

import SQLOperation.StuSQLOperation.StuOperation;

import javax.swing.*;
import java.awt.*;

public class StuInsert extends JFrame{
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JLabel insertname=new JLabel("请输入你要增加读者的名字");
    JLabel insertgender=new JLabel("请输入你要增加读者的性别");
    JLabel insertid=new JLabel("请输入你要增加读者的学号");
    JTextField fieldname=new JTextField(10);
    JTextField fieldgender=new JTextField(10);
    JTextField fieldid=new JTextField(10);
    JButton confirm=new JButton("确认");
    JButton cancel=new JButton("取消");
    public StuInsert(){
        this.setTitle("增加读者");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLayout(new GridLayout(4,1));
        p1.add(insertname);
        p1.add(fieldname);
        p2.add(insertgender);
        p2.add(fieldgender);
        p3.add(insertid);
        p3.add(fieldid);
        p4.add(confirm);
        p4.add(cancel);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        confirm.addActionListener(e->{
            if(e.getSource()==confirm){
                try{
                    StuOperation.stuinsert(fieldname.getText(),fieldgender.getText(),fieldid.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"添加失败！","警告",JOptionPane.INFORMATION_MESSAGE);
                }
                dispose();
            }
        });
        cancel.addActionListener(e->{
            if(e.getSource()==cancel){
                dispose();
            }
        });
    }
}
