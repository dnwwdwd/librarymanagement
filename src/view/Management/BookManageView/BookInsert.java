package view.Management.BookManageView;

import SQLOperation.BookSQLOperation.BookOperation;

import javax.swing.*;
import java.awt.*;
public class BookInsert extends JFrame {
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JPanel p5=new JPanel();
    JPanel p6=new JPanel();
    JLabel insertbookname=new JLabel("请输入你要增加图书的名字");
    JLabel insertauthor=new JLabel("请输入你要增加图书的作者");
    JLabel insertpublisher=new JLabel("请输入你要增加图书的出版社");
    JLabel insertbooknum=new JLabel("请输入你要增加图书的编号");
    JTextField fieldbookname=new JTextField(10);
    JTextField fieldauthor=new JTextField(10);
    JTextField fieldpublisher=new JTextField(10);
    JTextField fieldbooknum=new JTextField(10);
    JLabel insertstock=new JLabel("请输入你要增加图书的数量");
    JTextField fieldstock=new JTextField(10);
    JButton confirm=new JButton("确认");
    JButton cancel=new JButton("取消");
    public BookInsert(){
        this.setTitle("增加图书信息");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLayout(new GridLayout(6,1));
        p1.add(insertbookname);
        p1.add(fieldbookname);
        p2.add(insertauthor);
        p2.add(fieldauthor);
        p3.add(insertpublisher);
        p3.add(fieldpublisher);
        p4.add(insertbooknum);
        p4.add(fieldbooknum);
        p5.add(insertstock);
        p5.add(fieldstock);
        p6.add(confirm);
        p6.add(cancel);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p5);
        this.add(p6);
        confirm.addActionListener(e->{
            if(e.getSource()==confirm){
                try{
                    BookOperation.bookinsert(fieldbookname.getText(),fieldauthor.getText(),fieldpublisher.getText(),fieldbooknum.getText(),Integer.parseInt(fieldstock.getText()));
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
