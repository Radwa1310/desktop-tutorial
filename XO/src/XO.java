import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class XO extends JFrame  implements ActionListener{
    JButton[] buttons = new JButton[9];
    boolean playerX = true;
    boolean vsComputer= false;
    XO(){
        setTitle("XO Game");
        setSize(400,400);
        setLayout(new GridLayout(3,3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i=0;i<9;i++){
            buttons[i]=new JButton("");
            buttons[i].setFont(new Font("Arial",Font.BOLD,40));
            buttons[i].addActionListener(this);
            add(buttons[i]);

        }
        String[] options = {" player vs player","player vs computer"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose Game Mode",
                "XO Game",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        if(choice==1){
            vsComputer = true;
        }
        setVisible(true);
    }
    public  static void main (String[]args){

new XO ();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if(clicked.getText().equals("")){


            if(vsComputer){
                clicked.setText("X");
                checkWinner();

                computer();
                checkWinner();
            }


            else{
                if(playerX){
                    clicked.setText("X");
                    playerX=false;
                }else{
                    clicked.setText("O");
                    playerX=true;
                }
                checkWinner();
            }
        }
    }

        void checkWinner(){
            int[][] win= {
                    {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}
            };
            for(int[] w:win){
                String b1=buttons[w[0]].getText();
                String b2=buttons[w[1]].getText();
                String b3=buttons[w[2]].getText();
                if(!b1.equals("")&& b1 .equals(b2)&&b2.equals(b3) ){
                    JOptionPane.showMessageDialog(this,b1+"Wins!");
                    String[] options = {" PVP","Player vs Computer","Exit"};

                    int choice = JOptionPane.showOptionDialog(
                            this,
                            " Choose mode",
                            "Game Over",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]
                    );

                    if(choice==0){
                        vsComputer=false;
                        resetGame();
                    }
                    else if(choice==1){
                        vsComputer=true;
                        resetGame();
                    }
                    else{
                        System.exit(0);
                    }
                    return;

                }}boolean full = true;

            for(int i=0;i<9;i++){
                if(buttons[i].getText().equals("")){
                    full = false;
                    break;
                }
            }

            if(full){
                JOptionPane.showMessageDialog(this,"Draw!");

                String[] options = {"Play again PVP","Play vs Computer","Exit"};

                int choice = JOptionPane.showOptionDialog(
                        this,
                        "No winner! Choose mode",
                        "Draw",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if(choice==0){
                    vsComputer=false;
                    resetGame();
                }
                else if(choice==1){
                    vsComputer=true;
                    resetGame();
                }
                else{
                    System.exit(0);
                }
            }}
                void resetGame(){
                    for(JButton b:buttons){
                        b.setText("");
                    }
                    playerX=true;
                }
                void computer(){
        for(int i=0; i<9;i++){
            if (buttons[i].getText().equals("")) {
                buttons[i].setText("O");
                break;

            }
        }
                }
            }








