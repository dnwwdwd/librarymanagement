package view.Management;

import view.Management.BookManageView.BookDelete;
import view.Management.BookManageView.BookInsert;
import view.Management.BookManageView.BookQuery;
import view.Management.BookManageView.BookUpdate;

import javax.swing.*;
import java.awt.*;

public class BookManage extends JFrame {
    JButton bookinsert=new JButton("增加图书");
    JButton bookdelete=new JButton("删除图书");
    JButton bookupdate=new JButton("修改图书信息");
    JButton bookquery=new JButton("查询图书信息");
    JButton cancel=new JButton("取消");
    public BookManage(){
        this.setTitle("图书信息管理");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraintsleft=new GridBagConstraints();
        constraintsleft.gridx = 0; // 列为0
        constraintsleft.gridy = GridBagConstraints.RELATIVE; // 按钮的行相对于前一个按钮的行
        constraintsleft.anchor = GridBagConstraints.CENTER; // 设置水平方向上的位置居中
        constraintsleft.fill = GridBagConstraints.HORIZONTAL; // 填充水平方向
        /*constraintsleft.weightx = 0.5; // 水平方向上的权重为0.5*/
        constraintsleft.insets = new Insets(10, 5, 5, 100); // 设置按钮的内边距
        constraintsleft.ipadx = 10;
        this.add(bookinsert,constraintsleft);
        this.add(bookdelete,constraintsleft);
        this.add(bookupdate,constraintsleft);
        this.add(bookquery,constraintsleft);
        this.add(cancel,constraintsleft);
        bookinsert.addActionListener(e->{
            if(e.getSource()==bookinsert){
                BookInsert bookInsert=new BookInsert();
                bookInsert.setVisible(true);
            }
        });
        bookdelete.addActionListener(e->{
            if(e.getSource()==bookdelete){
                BookDelete bookDelete=new BookDelete();
                bookDelete.setVisible(true);
            }
        });
        bookupdate.addActionListener(e->{
            if(e.getSource()==bookupdate){
                BookUpdate bookUpdate=new BookUpdate();
                bookUpdate.setVisible(true);
            }
        });
        bookquery.addActionListener(e->{
            if(e.getSource()==bookquery){
                BookQuery bookQuery=new BookQuery();
                bookQuery.setVisible(true);
            }
        });
        cancel.addActionListener(e->{
            if(e.getSource()==cancel){
                dispose();
            }
        });
    }
}
