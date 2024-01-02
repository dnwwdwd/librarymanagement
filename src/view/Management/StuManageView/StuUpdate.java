package view.Management.StuManageView;

import SQLOperation.StuSQLOperation.StuOperation;

import javax.swing.*;
import java.awt.*;

public class StuUpdate extends JFrame {
    JLabel oldid=new JLabel("请输入学号");
    JTextField fieldoldid=new JTextField(10);
    JLabel updatename=new JLabel("请输入修改后的名字");
    JTextField fieldname=new JTextField(10);
    JLabel updategender=new JLabel("请输入修改后的性别");
    JTextField fieldgender=new JTextField(10);
    JLabel updateid=new JLabel("请输入修改后的学号");
    JTextField fieldid=new JTextField(10);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JPanel p5=new JPanel();
    JButton confirm=new JButton("确认");
    JButton cancel=new JButton("取消");
    public StuUpdate(){
        this.setTitle("读者修改信息");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,1));
        p1.add(oldid);
        p1.add(fieldoldid);
        p2.add(updatename);
        p2.add(fieldname);
        p3.add(updategender);
        p3.add(fieldgender);
        p4.add(updateid);
        p4.add(fieldid);
        p5.add(confirm);
        p5.add(cancel);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        confirm.addActionListener(e->{
            if(e.getSource()==confirm){
                try{
                    StuOperation.stuupdate(fieldoldid.getText(),fieldname.getText(),fieldgender.getText(),fieldid.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"修改失败！","警告",JFrame.EXIT_ON_CLOSE);
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
