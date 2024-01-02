package view.Management.BorrowManageView;

import SQLOperation.BorrowOperation.BorrowOperation;
import javafx.util.converter.LocalDateStringConverter;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowInsert extends JFrame {
    JLabel borrowid=new JLabel("请输入你的学号");
    JTextField fieldid=new JTextField(10);
    JLabel borrowbooknum=new JLabel("请输入你要借书的编号");
    JTextField fieldbooknum=new JTextField(10);
    JLabel returndate=new JLabel("请输入还书的日期");
    JTextField fieldreturndate=new JTextField(10);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JPanel p4=new JPanel();
    JButton confirm=new JButton("确定");
    JButton cancel=new JButton("取消");
    public BorrowInsert(){
        this.setTitle("借书");
        this.setLayout(new GridLayout(4,1));
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1.add(borrowid);
        p1.add(fieldid);
        p2.add(borrowbooknum);
        p2.add(fieldbooknum);
        p3.add(returndate);
        p3.add(fieldreturndate);
        p4.add(confirm);
        p4.add(cancel);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        LocalDate currenttime=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String borrowdate=currenttime.format(formatter);
        confirm.addActionListener(e->{
            if(e.getSource()==confirm){
                try{
                    BorrowOperation.borrowinsert(fieldid.getText(),fieldbooknum.getText(),borrowdate,fieldreturndate.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"借书失败！请确保你的学号和图书编号正确且存在！或者你已经借了这本书！","警告",JOptionPane.WARNING_MESSAGE);
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
