package view.Management;

import view.Management.BorrowManageView.BorrowDelete;
import view.Management.BorrowManageView.BorrowInsert;
import view.Management.BorrowManageView.BorrowQuery;

import javax.swing.*;
import java.awt.*;

public class BorrowManage extends JFrame {
    JButton borrowinsert=new JButton("借书");
    JButton borrowdelete=new JButton("还书");
    JButton borrowquery=new JButton("查询借书信息");
    JButton cancel=new JButton("取消");
    public BorrowManage(){
        this.setSize(800,600);
        this.setTitle("借阅管理");
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagConstraints constraintsleft=new GridBagConstraints();
        constraintsleft.gridx = 0; // 列为0
        constraintsleft.gridy = GridBagConstraints.RELATIVE; // 按钮的行相对于前一个按钮的行
        constraintsleft.anchor = GridBagConstraints.CENTER; // 设置水平方向上的位置居中
        constraintsleft.fill = GridBagConstraints.HORIZONTAL; // 填充水平方向
        /*constraintsleft.weightx = 0.5; // 水平方向上的权重为0.5*/
        constraintsleft.insets = new Insets(10, 5, 5, 100); // 设置按钮的内边距
        constraintsleft.ipadx = 10;
        this.add(borrowinsert,constraintsleft);
        this.add(borrowdelete,constraintsleft);
        this.add(borrowquery,constraintsleft);
        this.add(cancel,constraintsleft);
        borrowinsert.addActionListener(e->{
            if(e.getSource()==borrowinsert){
                BorrowInsert borrowInsert=new BorrowInsert();
                borrowInsert.setVisible(true);
            }
        });
        borrowdelete.addActionListener(e->{
            if(e.getSource()==borrowdelete){
                BorrowDelete borrowDelete=new BorrowDelete();
                borrowDelete.setVisible(true);
            }
        });
        borrowquery.addActionListener(e->{
            if(e.getSource()==borrowquery){
                BorrowQuery borrowQuery=new BorrowQuery();
                borrowQuery.setVisible(true);
            }
        });
        cancel.addActionListener(e->{
            if(e.getSource()==cancel){
                dispose();
            }
        });
    }
}
