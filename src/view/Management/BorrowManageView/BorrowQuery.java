package view.Management.BorrowManageView;

import SQLOperation.BorrowOperation.BorrowOperation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BorrowQuery extends JFrame {
    DefaultTableModel model=new DefaultTableModel();
    JTable borrowtable=new JTable(model);
    JScrollPane jScrollPane=new JScrollPane(borrowtable);
    String[] columnname={"学号","图书编号","借书日期","还书日期"};
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JButton cancel=new JButton("取消");
    public BorrowQuery(){
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("借阅信息查询");
        this.setLayout(new GridLayout(2,1));
        this.add(jScrollPane);
        model.setColumnIdentifiers(columnname);
        p1.add(jScrollPane);
        p2.add(cancel);
        this.add(p1);
        this.add(p2);
        try{
            BorrowOperation.borrowquery(model);
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
