import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @author Mr.w
 */
public class SourceUi extends JFrame{

    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JButton bt1;
    private JButton bt2;
    File file = new File("save.txt");

    public SourceUi(){
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUpUi();
        setUpEventListener();
        setVisible(true);
    }


    private void setUpUi(){
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        bt1 = new JButton("下一个");
        bt2 = new JButton("完成");

        JLabel lbl1 = new JLabel("姓名:");
        JLabel lbl2 = new JLabel("年龄:");
        JLabel lbl3 = new JLabel("电话号码:");

        add(lbl1);
        add(tf1);
        add(lbl2);
        add(tf2);
        add(lbl3);
        add(tf3);
        add(bt1);
        add(bt2);

    }

    private void setUpEventListener(){
        bt1.addActionListener(
                e -> next()
        );

        bt2.addActionListener(
                e -> finish()
        );
    }

    private void next(){
        String txt = tf1.getText() + "\t" + tf2.getText() + "\t" + tf3.getText() + "\n";
        try {
            // true 表示附加，默认为覆盖
            var bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(txt);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
    }

    private void finish(){
        next();
        var stringBuilder = new StringBuilder();
        String text;
        try {
            var bufferedReader = new BufferedReader(new FileReader(file));
            while ((text = bufferedReader.readLine()) != null){
                stringBuilder.append(text);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());
        System.exit(0);
    }

    public static void main(String[] args){
        new SourceUi();
    }

}
