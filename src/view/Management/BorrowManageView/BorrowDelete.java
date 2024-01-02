package view.Management.BorrowManageView;

import SQLOperation.BorrowOperation.BorrowOperation;

import javax.swing.*;
import java.awt.*;

public class BorrowDelete extends JFrame {
    JLabel borrowid=new JLabel("请输入你的学号");
    JTextField fieldid=new JTextField(10);
    JLabel returnbooknum=new JLabel("请输入你要还书的编号");
    JTextField fieldreturnnum=new JTextField(10);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    public BorrowDelete(){
        this.setTitle("还书");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));
        p1.add(borrowid);
        p1.add(fieldid);
        p2.add(returnbooknum);
        p2.add(fieldreturnnum);
        p3.add(confirm);
        p3.add(cancel);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        confirm.addActionListener(e->{
            if(e.getSource()==confirm){
                try{
                    BorrowOperation.borrowdelete(fieldid.getText(),fieldreturnnum.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"还书失败！请确保你的学号和图书编号正确且存在！","警告",JOptionPane.WARNING_MESSAGE);
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
