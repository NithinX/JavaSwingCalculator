import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator implements ActionListener {
    JFrame jf;
    JLabel displayLabel;
    JButton sevenButton;
    JButton eightButton;
    JButton nineButton;
    JButton fourButton;
    JButton fiveButton;
    JButton threeButton;
    JButton twoButton;
    JButton oneButton;
    JButton sixButton;
    JButton zeroButton;
    JButton dotButton;
    JButton equalButton;
    JButton addButton;
    JButton subtractButton;
    JButton multiplyButton;
    JButton divideButton;
    JButton clearButton;
    JButton sign;
    JButton prime;
    JButton oddEven;
    JButton divisible;


    boolean isOperatorClicked=false;
    String  oldValue;
    String  buttonStatus;
    boolean signStat=true;
    int w=80,h=50;


    public Calculator(){
        jf= new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(450,700);
        jf.setLocation(300,150);
        jf.getContentPane().setBackground(Color.gray);

        displayLabel = new JLabel("0");
        displayLabel.setBounds(30,50,380,40);
        displayLabel.setBackground(Color.black);
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setForeground(Color.green);
        displayLabel.setFont(new Font("Sans", Font.BOLD, 25));
        jf.add(displayLabel);

        sevenButton = new JButton("7");
        sevenButton.setBounds(30,310,w,h);
        sevenButton.setFont(new Font("Sans", Font.BOLD, 25));
        sevenButton.addActionListener(this);
        jf.add(sevenButton);

        eightButton = new JButton("8");
        eightButton.setBounds(130,310,w,h);
        eightButton.setFont(new Font("Sans", Font.BOLD, 25));
        eightButton.addActionListener(this);
        jf.add(eightButton);

        nineButton = new JButton("9");
        nineButton.setBounds(230,310,w,h);
        nineButton.setFont(new Font("Sans", Font.BOLD, 25));
        nineButton.addActionListener(this);
        jf.add(nineButton);

        fourButton = new JButton("4");
        fourButton.setBounds(30,390,w,h);
        fourButton.setFont(new Font("Sans", Font.BOLD, 25));
        fourButton.addActionListener(this);
        jf.add(fourButton);

        fiveButton = new JButton("5");
        fiveButton.setBounds(130,390,w,h);
        fiveButton.setFont(new Font("Sans", Font.BOLD, 25));
        fiveButton.addActionListener(this);
        jf.add(fiveButton);

        sixButton = new JButton("6");
        sixButton.setBounds(230,390,w,h);
        sixButton.setFont(new Font("Sans", Font.BOLD, 25));
        sixButton.addActionListener(this);
        jf.add(sixButton);

        oneButton = new JButton("1");
        oneButton.setBounds(30,470,w,h);
        oneButton.setFont(new Font("Sans", Font.BOLD, 25));
        oneButton.addActionListener(this);
        jf.add(oneButton);

        twoButton = new JButton("2");
        twoButton.setBounds(130,470,w,h);
        twoButton.setFont(new Font("Sans", Font.BOLD, 25));
        twoButton.addActionListener(this);
        jf.add(twoButton);

        threeButton = new JButton("3");
        threeButton.setBounds(230,470,w,h);
        threeButton.setFont(new Font("Sans", Font.BOLD, 25));
        threeButton.addActionListener(this);
        jf.add(threeButton);

        sign = new JButton("+/-");
        sign.setBounds(30,550,w,h);
        sign.setFont(new Font("Sans", Font.BOLD, 25));
        sign.addActionListener(this);
        jf.add(sign);

        zeroButton = new JButton("0");
        zeroButton.setBounds(130,550,w,h);
        zeroButton.setFont(new Font("Sans", Font.BOLD, 25));
        zeroButton.addActionListener(this);
        jf.add(zeroButton);

        dotButton = new JButton(".");
        dotButton.setBounds(230,550,w,h);
        dotButton.setFont(new Font("Sans", Font.BOLD, 25));
        dotButton.addActionListener(this);
        jf.add(dotButton);

        equalButton = new JButton("=");
        equalButton.setForeground(Color.blue);
        equalButton.setBounds(330,530,65,70);
        equalButton.setFont(new Font("Sans", Font.BOLD, 25));
        equalButton.addActionListener(this);
        jf.add(equalButton);

        divideButton = new JButton("÷");
        divideButton.setBounds(330,143,65,70);
        divideButton.setFont(new Font("Sans", Font.BOLD, 25));
        divideButton.addActionListener(this);
        jf.add(divideButton);

        multiplyButton = new JButton("×");
        multiplyButton.setBounds(330,238,65,70);
        multiplyButton.setFont(new Font("Sans", Font.BOLD, 25));
        multiplyButton.addActionListener(this);
        jf.add(multiplyButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(330,338,65,70);
        subtractButton.setFont(new Font("Sans", Font.BOLD, 25));
        subtractButton.addActionListener(this);
        jf.add(subtractButton);

        addButton = new JButton("+");
        addButton.setBounds(330,435,65,70);
        addButton.setFont(new Font("sans", Font.BOLD, 25));
        addButton.addActionListener(this);
        jf.add(addButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(180,225,130,60);
        clearButton.setFont(new Font("Sans", Font.BOLD, 15));
        clearButton.setForeground(Color.red);
        clearButton.addActionListener(this);
        jf.add(clearButton);

        oddEven = new JButton("Odd-Even");
        oddEven.setBounds(180,143,130,60);
        oddEven.setFont(new Font("Sans", Font.BOLD, 15));
        oddEven.addActionListener(this);
        jf.add(oddEven);

        prime = new JButton("Prime");
        prime.setBounds(30,225,130,60);
        prime.setFont(new Font("Sans", Font.BOLD, 15));
        prime.addActionListener(this);
        jf.add(prime);

        divisible = new JButton("Divisible");
        divisible.setBounds(30,143,130,60);
        divisible.setFont(new Font("Sans", Font.BOLD, 15));
        divisible.addActionListener(this);
        jf.add(divisible);


        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public String decimalEliminator(String x){
        String[] str = x.split("\\.");
            int temp=Integer.parseInt(str[0]);
            int temp2=Integer.parseInt(str[1]);
            if(temp2>0){
                return (x+"");
            }
            return (temp+"");

         }

    public boolean isDivisible(int num){

        ArrayList<Integer> digits = getDigits(num);

        for (int x : digits) {
            if (num % x != 0)
                return false;
        }
       return true;
    }


    ArrayList<Integer> getDigits(int num){

        ArrayList<Integer> digits = new ArrayList<>();
        while (num>0){
            int x = num%10;
            num = num/10;
            digits.add(x);
        }
        return digits;
    }

    public Boolean isPrime(String m){
            // Corner case
            int n=Integer.parseInt(m);
            if (n <= 1)
                return false;
            // Check from 2 to n-1
            for (int i = 2; i < n; i++)
                if (n % i == 0)
                    return false;
            return true;
        }

    public static void main(String[] args) {
            new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==sevenButton){
            if(isOperatorClicked){
                displayLabel.setText("7");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"7");
            }

        }else if(e.getSource()==eightButton){
            if(isOperatorClicked){
                displayLabel.setText("8");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"8");
            }

        }else if(e.getSource()==nineButton){
            if(isOperatorClicked){
                displayLabel.setText("9");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"9");
            }

        }else if (e.getSource()==fourButton){
            if(isOperatorClicked){
                displayLabel.setText("4");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"4");
            }

        }else if (e.getSource()==fiveButton){
            if(isOperatorClicked){
                displayLabel.setText("5");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"5");
            }

        }else if(e.getSource()==sixButton){
            if(isOperatorClicked){
                displayLabel.setText("6");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"6");
            }

        }else if (e.getSource()==oneButton){
            if(isOperatorClicked){
                displayLabel.setText("1");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"1");
            }

        }else if (e.getSource()==twoButton){
            if(isOperatorClicked){
                displayLabel.setText("2");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"2");
            }

        }else if (e.getSource()==threeButton){
            if(isOperatorClicked){
                displayLabel.setText("3");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"3");
            }

        }else if (e.getSource()==zeroButton){
            if(isOperatorClicked){
                displayLabel.setText("0");
                isOperatorClicked=false;
            }else{
                if(displayLabel.getText().equals("0"))
                    displayLabel.setText("");
                displayLabel.setText(displayLabel.getText()+"0");
            }

        }else if (e.getSource()==dotButton) {
            displayLabel.setText(displayLabel.getText() + ".");

        }else if (e.getSource()==sign) {
            if(!displayLabel.getText().equals("0")){
                if (signStat){
            displayLabel.setText("-"+displayLabel.getText());
                signStat=false;
            }else {
                    displayLabel.setText(displayLabel.getText().substring(1));
                    signStat=true;
                }
            }

        }else if (e.getSource()==equalButton) {
            switch (buttonStatus) {
                case "add" -> {
                    String newValue = displayLabel.getText();
                    float result = Float.parseFloat(oldValue) + Float.parseFloat(newValue);
                    displayLabel.setText(decimalEliminator(result+""));
                }
                case "multiply" -> {
                    String newValue = displayLabel.getText();
                    float result = Float.parseFloat(oldValue) * Float.parseFloat(newValue);
                    displayLabel.setText(decimalEliminator(result+""));
                }
                case "subtract" -> {
                    String newValue = displayLabel.getText();
                    float result = Float.parseFloat(oldValue) - Float.parseFloat(newValue);
                    displayLabel.setText(decimalEliminator(result+""));
                }
                case "divide" -> {
                    String newValue = displayLabel.getText();
                    float result = Float.parseFloat(oldValue) / Float.parseFloat(newValue);
                    displayLabel.setText(decimalEliminator(result+""));
                }
            }

        }else if (e.getSource()==addButton) {
            isOperatorClicked=true;
            oldValue=displayLabel.getText();
            buttonStatus="add";

        }else if (e.getSource()==multiplyButton) {
            isOperatorClicked=true;
            oldValue=displayLabel.getText();
            buttonStatus="multiply";

        }else if (e.getSource()==subtractButton) {
            isOperatorClicked=true;
            oldValue=displayLabel.getText();
            buttonStatus="subtract";

        }else if (e.getSource()==divideButton) {
            isOperatorClicked=true;
            oldValue=displayLabel.getText();
            buttonStatus="divide";

        }else if (e.getSource()==clearButton) {
            displayLabel.setText("0");

        }else if (e.getSource()==prime) {
            if(isPrime(displayLabel.getText())){
                displayLabel.setText(displayLabel.getText()+" is Prime");
            }else{
                displayLabel.setText(displayLabel.getText()+" is Not Prime");
            }


        }else if (e.getSource()==oddEven) {
            if(Float.parseFloat(displayLabel.getText())%2==0)
                 displayLabel.setText(displayLabel.getText()+(" is Even"));
            else
                displayLabel.setText(displayLabel.getText()+(" is Odd"));

        }else if (e.getSource()==divisible) {
          boolean result= isDivisible(Integer.parseInt(displayLabel.getText()));
          if(result)
              displayLabel.setText(displayLabel.getText()+" is divisible by it's digits");
          else
              displayLabel.setText(displayLabel.getText()+" is NOT divisible by it's digits");
        }
    }
}