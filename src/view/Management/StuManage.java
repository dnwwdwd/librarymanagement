package view.Management;

import view.Management.StuManageView.StuDelete;
import view.Management.StuManageView.StuInsert;
import view.Management.StuManageView.StuQuery;
import view.Management.StuManageView.StuUpdate;

import javax.swing.*;
import java.awt.*;

public class StuManage extends JFrame {
    JButton stuinsert=new JButton("增加读者");
    JButton studelete=new JButton("删除读者");
    JButton stuupdate=new JButton("修改读者信息");
    JButton stuquery=new JButton("查询读者信息");
    JButton cancel=new JButton("取消");
    public StuManage(){
        this.setTitle("学生信息管理");
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
        this.add(stuinsert,constraintsleft);
        this.add(studelete,constraintsleft);
        this.add(stuupdate,constraintsleft);
        this.add(stuquery,constraintsleft);
        this.add(cancel,constraintsleft);
        stuinsert.addActionListener(e->{
            if(e.getSource()==stuinsert){
                StuInsert stuInsert=new StuInsert();
                stuInsert.setVisible(true);
            }
        });
        studelete.addActionListener(e->{
            if(e.getSource()==studelete){
                StuDelete stuDelete=new StuDelete();
                stuDelete.setVisible(true);
            }
        });
        stuupdate.addActionListener(e->{
            if(e.getSource()==stuupdate){
                StuUpdate stuUpdate=new StuUpdate();
                stuUpdate.setVisible(true);
            }
        });
        stuquery.addActionListener(e->{
            if(e.getSource()==stuquery){
                StuQuery stuQuery=new StuQuery();
                stuQuery.setVisible(true);
            }
        });
        cancel.addActionListener(e->{
            if(e.getSource()==cancel){
                dispose();
            }
        });
    }
}
