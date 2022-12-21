import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class FDemo extends JFrame implements ActionListener {
      JTextField tx1;
      JButton b[]=new JButton[20];
      int k=0;
      int x,y,w,h;
      FDemo()
      {
          setTitle("Calculator");
          setResizable(false);
          x=0;
          y=100;
          w=100;
          h=100;
          setLayout(null);
          Font f=new Font("",Font.BOLD,30);
          tx1=new JTextField();
          tx1.setSize(400,100);
          tx1.setLocation(0,0);
          tx1.setFont(f);
          tx1.setHorizontalAlignment(JTextField.RIGHT);
          tx1.setBackground(Color.gray);
          add(tx1);
          for(int i=1;i<=5;i++)
          {
              for(int j=1;j<=4;j++)
              {
                  b[k]=new JButton();
                  b[k].setSize(w,h);
                  b[k].setLocation(x,y);
                  b[k].setFont(f);
                  add(b[k]);
                  b[k].addActionListener(this);
                  k++;
                  x=x+100;
              }
              x=0;
              y=y+100;
          }
          b[0].setLabel("B");
          b[1].setLabel("C");
          b[2].setLabel("1/x");
          b[3].setLabel("sqrt");
          b[4].setLabel("1");
          b[5].setLabel("2");
          b[6].setLabel("3");
          b[7].setLabel("/");
          b[8].setLabel("4");
          b[9].setLabel("5");
          b[10].setLabel("6");
          b[11].setLabel("*");
          b[12].setLabel("7");
          b[13].setLabel("8");
          b[14].setLabel("9");
          b[15].setLabel("-");
          b[16].setLabel(".");
          b[17].setLabel("0");
          b[18].setLabel("=");
          b[19].setLabel("+");
      }
      public void actionPerformed(ActionEvent e) {
          if (e.getSource() == b[0]) {
              String s1 = tx1.getText();
              tx1.setText(s1.substring(0, s1.length() - 1));
          } else if (e.getSource() == b[1]) {
              tx1.setText("");
          } else if (e.getSource() == b[2]) {
              String s1 = tx1.getText();
              double a = Double.valueOf(s1);
              a = 1 / a;
              tx1.setText("" + a);
          } else if (e.getSource() == b[3]) {
              String s1 = tx1.getText();
              double a = Double.valueOf(s1);
              tx1.setText("" + Math.sqrt(a));
          } else if (e.getSource() == b[18]) {
              String s1 = tx1.getText();
              int ind = -1;
              for (int i = 0; i < s1.length(); i++) {
                  char ch = s1.charAt(i);
                  if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                      ind = i;
                  }
              }
              if(decimal(s1)) {
                  double v1 = Double.valueOf(s1.substring(0, ind));
                  double v2 = Double.valueOf(s1.substring(ind + 1));
                  double res;
                  if (s1.charAt(ind) == '+')
                      res = v1 + v2;
                  else if (s1.charAt(ind) == '-')
                      res = v1 - v2;
                  else if (s1.charAt(ind) == '*')
                      res = v1 * v2;
                  else
                      res = v1 / v2;
                  tx1.setText(Double.toString(res));
              }
              else {
                  int v1 = Integer.valueOf(s1.substring(0, ind));
                  int v2 = Integer.valueOf(s1.substring(ind + 1));
                  int res;
                  if (s1.charAt(ind) == '+')
                  {   res = v1 + v2;
                      tx1.setText(Integer.toString(res));}
                  else if (s1.charAt(ind) == '-')
                  {    res = v1 - v2;
                      tx1.setText(Integer.toString(res));}
                  else if (s1.charAt(ind) == '*')
                  {  res = v1 * v2;
                      tx1.setText(Integer.toString(res));}
                  else
                  {   double re = v1 / v2;
                      tx1.setText(Double.toString(re));}

              }
          } else if (e.getSource() == b[16]) {
              int check = 0;
              String s1 = tx1.getText();
              for (int i = s1.length() - 1; i >= 0; i--) {
                  if (s1.charAt(i) == '+' || s1.charAt(i) == '-' || s1.charAt(i) == '*' || s1.charAt(i) == '/') {
                      break;
                  }
                  if (s1.charAt(i) == '.') {
                      check = 1;
                      break;
                  }
              }
              if (check == 0) {
                  JButton b1 = (JButton) e.getSource();
                  String s5 = tx1.getText() + b1.getLabel();
                  tx1.setText(s5);
              }
          } else if (e.getSource() == b[7]) {
              int check = 0;
              String s1 = tx1.getText();
              int j = s1.length() - 1;
              if (s1.charAt(j) == '+' || s1.charAt(j) == '-' || s1.charAt(j) == '*' || s1.charAt(j) == '/' || s1.charAt(j) == '.') {
                  check = 1;
              }
              if (check == 0) {
                  int ind = -1;
                  double res;
                  for (int i = 0; i < s1.length(); i++) {
                      char ch = s1.charAt(i);
                      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                          ind = i;
                      }
                  }
                  if (decimal(s1)) {
                      if (ind >= 0) {
                          double v1 = Double.valueOf(s1.substring(0, ind));
                          double v2 = Double.valueOf(s1.substring(ind + 1));
                          if (s1.charAt(ind) == '+')
                              res = v1 + v2;
                          else if (s1.charAt(ind) == '-')
                              res = v1 - v2;
                          else if (s1.charAt(ind) == '*')
                              res = v1 * v2;
                          else
                              res = v1 / v2;
                          tx1.setText(Double.toString(res) + "/");
                      } else {
                          JButton b1 = (JButton) e.getSource();
                          String s5 = tx1.getText() + b1.getLabel();
                          tx1.setText(s5);
                      }
                  } else {
                      if (ind >= 0) {
                          int v1 = Integer.valueOf(s1.substring(0, ind));
                          int v2 = Integer.valueOf(s1.substring(ind + 1));
                          if (s1.charAt(ind) == '+') {
                              int re = v1 + v2;
                              tx1.setText(Integer.toString(re) + "/");
                          } else if (s1.charAt(ind) == '-') {
                              int re = v1 - v2;
                              tx1.setText(Integer.toString(re) + "/");
                          } else if (s1.charAt(ind) == '*') {
                              int re = v1 * v2;
                              tx1.setText(Integer.toString(re) + "/");
                          } else {
                              double re = v1 / v2;
                              tx1.setText(Double.toString(re) + "/");
                          }
                      } else {
                          JButton b1 = (JButton) e.getSource();
                          String s5 = tx1.getText() + b1.getLabel();
                          tx1.setText(s5);
                      }
                  }
              }
          } else if (e.getSource() == b[11]) {
              int check = 0;
              String s1 = tx1.getText();
              int j = s1.length() - 1;
              if (s1.charAt(j) == '+' || s1.charAt(j) == '-' || s1.charAt(j) == '*' || s1.charAt(j) == '/' || s1.charAt(j) == '.') {
                  check = 1;
              }
              if (check == 0) {
                  int ind = -1;
                  double res;
                  for (int i = 0; i < s1.length(); i++) {
                      char ch = s1.charAt(i);
                      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                          ind = i;
                      }
                  }
                  if(decimal(s1))
                  {if (ind >= 0) {
                      double v1 = Double.valueOf(s1.substring(0, ind));
                      double v2 = Double.valueOf(s1.substring(ind + 1));
                      if (s1.charAt(ind) == '+')
                          res = v1 + v2;
                      else if (s1.charAt(ind) == '-')
                          res = v1 - v2;
                      else if (s1.charAt(ind) == '*')
                          res = v1 * v2;
                      else
                          res = v1 / v2;
                      tx1.setText(Double.toString(res) + "*");
                  } else {
                      JButton b1 = (JButton) e.getSource();
                      String s5 = tx1.getText() + b1.getLabel();
                      tx1.setText(s5);
                  }}
                  else {
                      if (ind >= 0) {
                          int v1 = Integer.valueOf(s1.substring(0, ind));
                          int v2 = Integer.valueOf(s1.substring(ind + 1));
                          if (s1.charAt(ind) == '+')
                          {  int re = v1 + v2;
                              tx1.setText(Integer.toString(re) + "*");}
                          else if (s1.charAt(ind) == '-')
                          { int re = v1 - v2;
                              tx1.setText(Integer.toString(re) + "*");}
                          else if (s1.charAt(ind) == '*')
                          {  int re = v1 * v2;
                              tx1.setText(Integer.toString(re) + "*");}
                          else
                          { double  re = v1 / v2;
                              tx1.setText(Double.toString(re) + "*");
                          }}
                      else {
                          JButton b1 = (JButton) e.getSource();
                          String s5 = tx1.getText() + b1.getLabel();
                          tx1.setText(s5);
                      }}
              }
          } else if (e.getSource() == b[15]) {
              int check = 0;
              String s1 = tx1.getText();
              int j = s1.length() - 1;
              if (s1.charAt(j) == '+' || s1.charAt(j) == '-' || s1.charAt(j) == '*' || s1.charAt(j) == '/' || s1.charAt(j) == '.') {
                  check = 1;
              }
              if (check == 0) {
                  int ind = -1;
                  double res;
                  for (int i = 0; i < s1.length(); i++) {
                      char ch = s1.charAt(i);
                      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                          ind = i;
                      }
                  }
                  if(decimal(s1))
                  {if (ind >= 0) {
                      int v1 = Integer.valueOf(s1.substring(0, ind));
                      int v2 = Integer.valueOf(s1.substring(ind + 1));
                      if (s1.charAt(ind) == '+')
                          res = v1 + v2;
                      else if (s1.charAt(ind) == '-')
                          res = v1 - v2;
                      else if (s1.charAt(ind) == '*')
                          res = v1 * v2;
                      else
                          res = v1 / v2;
                      tx1.setText(Double.toString(res) + "-");
                  } else {
                      JButton b1 = (JButton) e.getSource();
                      String s5 = tx1.getText() + b1.getLabel();
                      tx1.setText(s5);
                  }}
                  else {
                      if (ind >= 0) {
                          int v1 = Integer.valueOf(s1.substring(0, ind));
                          int v2 = Integer.valueOf(s1.substring(ind + 1));
                          if (s1.charAt(ind) == '+')
                          {  int re = v1 + v2;
                              tx1.setText(Integer.toString(re) + "-");}
                          else if (s1.charAt(ind) == '-')
                          { int re = v1 - v2;
                              tx1.setText(Integer.toString(re) + "-");}
                          else if (s1.charAt(ind) == '*')
                          {  int re = v1 * v2;
                              tx1.setText(Integer.toString(re) + "-");}
                          else
                          {
                              double  re = v1 / v2;
                              tx1.setText(Double.toString(re) + "-");
                          }
              }
                      else {
                          JButton b1 = (JButton) e.getSource();
                          String s5 = tx1.getText() + b1.getLabel();
                          tx1.setText(s5);
                      }}}
          } else if (e.getSource() == b[19]) {
              int check = 0;
              String s1 = tx1.getText();
              int j = s1.length() - 1;
              if (s1.charAt(j) == '+' || s1.charAt(j) == '-' || s1.charAt(j) == '*' || s1.charAt(j) == '/' || s1.charAt(j) == '.') {
                  check = 1;
              }
              if (check == 0) {
                  int ind = -1;
                  double res;
                  for (int i = 0; i < s1.length(); i++) {
                      char ch = s1.charAt(i);
                      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                          ind = i;
                      }
                  }
                  if(decimal(s1))
                  { if (ind >= 0) {
                      double v1 = Double.valueOf(s1.substring(0, ind));
                      double v2 = Double.valueOf(s1.substring(ind + 1));
                      if (s1.charAt(ind) == '+')
                          res = v1 + v2;
                      else if (s1.charAt(ind) == '-')
                          res = v1 - v2;
                      else if (s1.charAt(ind) == '*')
                          res = v1 * v2;
                      else
                          res = v1 / v2;
                      tx1.setText(Double.toString(res) + "+");
                  } else {
                      JButton b1 = (JButton) e.getSource();
                      String s5 = tx1.getText() + b1.getLabel();
                      tx1.setText(s5);
                  }}
                  else {
                      if (ind >= 0) {
                          int v1 = Integer.valueOf(s1.substring(0, ind));
                          int v2 = Integer.valueOf(s1.substring(ind + 1));
                          if (s1.charAt(ind) == '+')
                          {  int re = v1 + v2;
                              tx1.setText(Integer.toString(re) + "+");}
                          else if (s1.charAt(ind) == '-')
                          { int re = v1 - v2;
                              tx1.setText(Integer.toString(re) + "+");}
                          else if (s1.charAt(ind) == '*')
                          {  int re = v1 * v2;
                              tx1.setText(Integer.toString(re) + "+");}
                          else
                          { double  re = v1 / v2;
                              tx1.setText(Double.toString(re) + "+");
                          }

                      } else {
                          JButton b1 = (JButton) e.getSource();
                          String s5 = tx1.getText() + b1.getLabel();
                          tx1.setText(s5);
                      }
                  }
              }}
              else {
                  JButton b1 = (JButton) e.getSource();
                  String s5 = tx1.getText() + b1.getLabel();
                  tx1.setText(s5);
              }
          }
          public boolean decimal(String s)
          {
              for(int i=0;i<s.length();i++)
              {
                  if(s.charAt(i)=='.')
                      return true;
              }
              return false;
          }
    public static void main(String[] args) {
        FDemo f=new FDemo();
        f.setVisible(true);
        f.setSize(420,650);
        f.setLocation(200,100);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}