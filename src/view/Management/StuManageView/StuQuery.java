package view.Management.StuManageView;

import SQLOperation.StuSQLOperation.StuOperation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StuQuery extends JFrame {
    DefaultTableModel model=new DefaultTableModel();
    JTable stutable=new JTable(model);
    String[] colunmnname={"姓名","性别","学号"};
    JScrollPane jScrollPane=new JScrollPane(stutable);
    JButton cancel=new JButton("取消");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    public StuQuery(){
        this.setSize(800,600);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("学生信息查询");
        p1.add(jScrollPane);
        p2.add(cancel);
        this.add(p1);
        this.add(p2);
        model.setColumnIdentifiers(colunmnname);
        try{
            StuOperation.stuquery(model);
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
