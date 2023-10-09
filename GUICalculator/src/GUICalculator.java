import net.objecthunter.exp4j.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.*;

//execution of Calculator GUI
public class GUICalculator {
    public static void main(String[] args){
        new GUI();
    }
}

//calculator build (front end and back end)
class GUI{
    private final JFrame f;
    private final JButton p,m,P,d,dot,ope,clo;
    private final JButton equals,clear,del;
    private final JTextArea ta;
    public GUI(){
        f=new JFrame("Calculator");
        f.setBounds(new Rectangle(390,520));

        ta=new JTextArea();
        ta.setFont(new Font("SansSerif", Font.PLAIN, 16));
        ta.setEditable(false);
        ta.setBounds(40,10,300,75);
        p=new JButton("+");
        //action
        p.setBounds(40,95,50,50);
        p.setFont(new FontUIResource("+",Font.BOLD,15));
        p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("+");
            }
        });
        m=new JButton("-");
        //action
        m.setBounds(110,95,50,50);
        m.setFont(new FontUIResource("-",Font.BOLD,20));

        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("-");
            }
        });

        P=new JButton("×");
        //action
        P.setBounds(40,165,50,50);
        P.setFont(new FontUIResource("×",Font.BOLD,15));

        P.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("*");
            }
        });


        d=new JButton("÷");
        //action
        d.setBounds(180,95,50,50);
        d.setFont(new FontUIResource("÷",Font.BOLD,15));
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("/");

            }
        });
//digits
        JButton o=new JButton("1");
        o.setBounds(110,165,50,50);
        o.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("1");
            }
        });

        JButton t=new JButton("2");
        t.setBounds(180,165,50,50);
        t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("2");
            }
        });

        JButton th=new JButton("3");
        th.setBounds(250,165,50,50);
        th.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("3");
            }
        });

        JButton fo=new JButton("4");
        fo.setBounds(110,235,50,50);
        fo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("4");
            }
        });

        JButton fi=new JButton("5");
        fi.setBounds(180,235,50,50);
        fi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("5");
            }
        });

        JButton si=new JButton("6");
        si.setBounds(250,235,50,50);
        si.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("6");
            }
        });

        JButton se=new JButton("7");
        se.setBounds(110,305,50,50);
        se.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("7");
            }
        });

        JButton ei=new JButton("8");
        ei.setBounds(180,305,50,50);
        ei.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("8");
            }
        });

        JButton ni=new JButton("9");
        ni.setBounds(250,305,50,50);
        ni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("9");
            }
        });

        JButton z=new JButton("0");
        z.setBounds(180,375,50,50);
        z.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("0");
            }
        });
//evaluating
        equals=new JButton("=");
        equals.setBounds(250,95,50,50);
        equals.setBackground(Color.green);
        equals.setFont(new FontUIResource("=",Font.BOLD,15));

        equals.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Expression exp=new ExpressionBuilder(ta.getText()).build();
                    double res=exp.evaluate();
                    ta.setText(Double.toString(res));

                }catch(Exception exe){
                    JOptionPane.showMessageDialog(f,"Enter a valid operation");
                }
            }
        });

//Clear button
        clear=new JButton("CE");
        clear.setBounds(40,235,50,50);
        clear.setFont(new FontUIResource("CE",Font.BOLD,10));
        clear.setBackground(Color.red);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText("");
            }
        });

//delete button
        del=new JButton("DEL");
        del.setFont(new FontUIResource("DEL",Font.BOLD,8));
        del.setBounds(40,305,50,50);
        del.setBackground(Color.getColor("#32a852"));
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s=ta.getText();
                try{
                    char[] ca=s.toCharArray();
                    StringBuilder sb=new StringBuilder();
                    for(int i=0;i<ca.length-1;i++){
                        sb.append(ca[i]);
                    }

                    ta.setText(sb.toString());
                }
                catch(Exception exception){
                    ta.setText("");
                }
            }

        });
        dot=new JButton(".");
        dot.setBounds(40,375,50,50);
        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append(".");
            }
        });
        ope=new JButton("(");
        ope.setBounds(110,375,50,50);
        ope.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("(");
            }
        });

        clo=new JButton(")");
        clo.setBounds(250,375,50,50);
        clo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append(")");
            }
        });




        f.add(p);f.add(m);f.add(P);f.add(d);f.add(equals);f.add(clear);f.add(del);
        f.add(z);f.add(o);f.add(t); f.add(si);f.add(th);f.add(se);f.add(fo);f.add(ei);f.add(ni);f.add(fi);
        f.add(ta);f.add(dot);f.add(ope);f.add(clo);
        f.setLayout(/*new BorderLayout()*/null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
