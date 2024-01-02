package view.Management.BookManageView;

import SQLOperation.BookSQLOperation.BookOperation;

import javax.swing.*;
import java.awt.*;

public class BookUpdate extends JFrame {
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JPanel p5=new JPanel();
    JPanel p6=new JPanel();
    JPanel p7=new JPanel();
    JLabel oldbooknum=new JLabel("请输入你想修改的图书编号");
    JTextField fieldoldbooknum=new JTextField(10);
    JLabel updatebookname=new JLabel("请输入修改后的书名");
    JTextField fieldbookname=new JTextField(10);
    JLabel updatebookauthor=new JLabel("请输入修改后的作者名");
    JTextField fieldbookauthor=new JTextField(10);
    JLabel updatebookpublisher=new JLabel("请输入修改后的出版社");
    JTextField fieldbookpublisher=new JTextField(10);
    JLabel updatebooknum=new JLabel("请输入修改后的图书编号");
    JTextField fieldbooknum=new JTextField(10);
    JLabel updatebookstock=new JLabel("请输入修改后的图书数量");
    JTextField fieldbookstock=new JTextField(10);
    JButton confirm=new JButton("确认");
    JButton cancel=new JButton("取消");
    public BookUpdate(){
        this.setTitle("图书修改信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLayout(new GridLayout(7,1));
        p1.add(oldbooknum);
        p1.add(fieldoldbooknum);
        p2.add(updatebookname);
        p2.add(fieldbookname);
        p3.add(updatebookauthor);
        p3.add(fieldbookauthor);
        p4.add(updatebookpublisher);
        p4.add(fieldbookpublisher);
        p5.add(updatebooknum);
        p5.add(fieldbooknum);
        p6.add(updatebookstock);
        p6.add(fieldbookstock);
        p7.add(confirm);
        p7.add(cancel);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        confirm.addActionListener(e->{
            if(e.getSource()==confirm){
                try{
                    BookOperation.bookupdate(fieldoldbooknum.getText(),fieldbookname.getText(),fieldbookauthor.getText(),fieldbookpublisher.getText(),fieldbooknum.getText(),Integer.parseInt(fieldbookstock.getText()));
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"修改失败！","警告",JOptionPane.WARNING_MESSAGE);
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
