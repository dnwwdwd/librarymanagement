package view.Management.BookManageView;

import SQLOperation.BookSQLOperation.BookOperation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookQuery extends JFrame {
    DefaultTableModel model=new DefaultTableModel();
    JTable booktable=new JTable(model);
    JScrollPane jScrollPane=new JScrollPane(booktable);
    String[] columnname={"书名","作者","出版社","图书编号","库存量"};
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JButton cancel=new JButton("取消");
    public BookQuery(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("图书查询信息");
        this.setLayout(new GridLayout(2,1));
        p1.add(jScrollPane);
        p2.add(cancel);
        this.add(p1);
        this.add(p2);
        model.setColumnIdentifiers(columnname);
        try{
            BookOperation.bookquery(model);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"查询失败！","警告",JOptionPane.WARNING_MESSAGE);
        }
        cancel.addActionListener(e->{
            if(e.getSource()==cancel){
                dispose();
            }
        });
    }
}
