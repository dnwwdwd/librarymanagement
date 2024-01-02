package view.Management.StuManageView;

import SQLOperation.StuSQLOperation.StuOperation;

import javax.swing.*;
import java.awt.*;

public class StuDelete extends JFrame {
    JPanel p1=new JPanel();
    JLabel emptylabel=new JLabel();
    JLabel deleteid=new JLabel("请输入你要删除读者的学号");
    JTextField fieldid=new JTextField(10);
    JButton confirm=new JButton("确认");
    JButton cancel=new JButton("取消");
    public StuDelete(){
        this.setTitle("读者信息删除");
        this.setSize(750,500);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        emptylabel.setPreferredSize(new Dimension(10,300));
        p1.add(emptylabel);
        p1.add(deleteid);
        p1.add(fieldid);
        p1.add(confirm);
        p1.add(cancel);
        this.add(p1);
        confirm.addActionListener(e->{
            if(e.getSource()==confirm){
                try{
                    StuOperation.studelete(fieldid.getText());
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"删除失败！","警告",JOptionPane.WARNING_MESSAGE);
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
