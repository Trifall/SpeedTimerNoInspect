package speed.Timer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.awt.*;
import java.io.*;



public class SpeedTimer extends JFrame{

    Timer speedTimer;


    public static void main(String[] args) throws InterruptedException {
        SpeedTimer start = new SpeedTimer();
    }



    public static void update(long dT){
        // convert milliseconds into other forms
        int seconds = (int) ((dT / 1000) % 60);
        String secondsValue;

            if(seconds < 10 && seconds >= 0){
                secondsValue = "0" + seconds;
            }
            else{
                secondsValue = String.valueOf(seconds);
            }

        long milliseconds = dT%1000;
        String millisecondsValue;

            if(milliseconds < 100 && milliseconds >= 0){
                if(milliseconds == 0 ||milliseconds == 1 || milliseconds == 2 || milliseconds == 3 || milliseconds == 4 || milliseconds == 5 || milliseconds == 6 || milliseconds == 7 || milliseconds == 8 || milliseconds == 9){
                    millisecondsValue = "0" + milliseconds + "0";
                }
                else
                millisecondsValue = "0" + milliseconds;
            }
            else{
                millisecondsValue = String.valueOf(milliseconds);
            }


        int minutes = (int) ((dT / 1000) / 60);
        String minutesValue;

        if(minutes < 10 && seconds >= 0){
            minutesValue = "0" + minutes;
        }
        else{
            minutesValue = String.valueOf(minutes);
        }


        timeLabel.setText(minutesValue+":"+secondsValue+"."+millisecondsValue);
    }

    public SpeedTimer() throws InterruptedException {

        speedTimer = new Timer(this);

        addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_SPACE) {
                    if (speedTimer.running == true) {
                        speedTimer.stopTimer();
                        scramble();
                        scrambleLabel.setText(currentScramble);
                    }
                    else{
                        speedTimer.startTimer();
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
//                if(e.getKeyCode()== KeyEvent.VK_SPACE){
//                    if(speedTimer.running == false){
//                        speedTimer.startTimer();
//                    }
//                }

            }
            public void keyTyped(KeyEvent e) {

            }
        });



        initComponents();

        Thread.sleep(1000);
    }




    String currentScramble = "";

    public void scramble(){
        String[] options = {"U ", "U' ", "U2 ", "F ", "F' ", "F2 ", "L ", "L' ", "L2 ", "R ", "R' ", "R2 ", "B ", "B' ", "B2 ", "D ", "D' ", "D2 "};
        Random r = new Random();

        currentScramble = "";
        String lastLetter = "G22";
        for(int i = 0; i < 20; i++) {
                String getLetter = options[r.nextInt(options.length)];

                if(!((lastLetter.contains(getLetter.substring(0, getLetter.length()-1))) || (getLetter.contains(lastLetter.substring(0, lastLetter.length()-1))) || getLetter.equalsIgnoreCase(lastLetter) || lastLetter.equalsIgnoreCase(getLetter))){
                    currentScramble += getLetter;
                    lastLetter = getLetter;
                }
                else{
                    while(lastLetter.contains(getLetter.substring(0, getLetter.length()-1)) || (getLetter.contains(lastLetter.substring(0, lastLetter.length()-1))) || getLetter.equalsIgnoreCase(lastLetter) || lastLetter.equalsIgnoreCase(getLetter)){
                        getLetter = options[r.nextInt(options.length)];
                    }
                    currentScramble += getLetter;
                    lastLetter = getLetter;
                }
        }
    }


    private void scrambleButtonActionPerformed(ActionEvent e) {
        scramble();
        scrambleLabel.setText(currentScramble);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jerren Trifan
        TimePanel = new JPanel();
        timeLabel = new JLabel();
        scramblePanel = new JPanel();
        scrambleLabel = new JLabel();
        scrambleButton = new JButton();

        scramble();

        //======== this ========
        setVisible(true);
        setTitle("Speed Timer - Jerren Trifan");
        setResizable(false);
        Container contentPane = getContentPane();
        Color panelColor = new Color(65,63,68);
        getContentPane().setBackground(panelColor);
        getContentPane().setSize(600, 1000);
        setSize(600, 1000);
        setPreferredSize(new Dimension(785, 580));

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //======== TimePanel ========
        {
            TimePanel.setBackground(new Color(90, 93, 95));
            TimePanel.setMinimumSize(new Dimension(785, 489));
            TimePanel.setMaximumSize(new Dimension(815, 490));
            TimePanel.setFocusable(false);




            //---- timeLabel ----
            timeLabel.setText("  Ready");
            timeLabel.setName("timerLabel");
            timeLabel.setAlignmentX(0.5F);
            timeLabel.setFont(new Font("Arial", Font.PLAIN, 120));
            timeLabel.setForeground(Color.white);
            timeLabel.setFocusable(false);
            timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timeLabel.setHorizontalTextPosition(SwingConstants.CENTER);

            GroupLayout TimePanelLayout = new GroupLayout(TimePanel);
            TimePanel.setLayout(TimePanelLayout);
            TimePanelLayout.setHorizontalGroup(
                    TimePanelLayout.createParallelGroup()
                            .addGroup(TimePanelLayout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(0, 0, Short.MAX_VALUE))
            );
            TimePanelLayout.setVerticalGroup(
                    TimePanelLayout.createParallelGroup()
                            .addGroup(TimePanelLayout.createSequentialGroup()
                                    .addGap(153, 153, 153)
                                    .addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(197, 197, 197))
            );
        }

        //======== scramblePanel ========
        {
            scramblePanel.setBackground(new Color(90, 93, 95));
            scramblePanel.setMinimumSize(new Dimension(671, 30));
            scramblePanel.setPreferredSize(new Dimension(753, 70));
            scramblePanel.setBackground(new Color(90, 93, 95));
            scramblePanel.setFocusable(false);

            //---- scrambleLabel ----
            scrambleLabel.setText(currentScramble);
            scrambleLabel.setForeground(Color.white);
            scrambleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            scrambleLabel.setRequestFocusEnabled(false);
            scrambleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            scrambleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            scrambleLabel.setFocusable(false);

            //---- scrambleButton ----
            scrambleButton.setText("Scramble");
            scrambleButton.setForeground(new Color(50, 53, 55));
            scrambleButton.setFont(new Font("Arial", Font.PLAIN, 12));
            scrambleButton.setRequestFocusEnabled(false);
            scrambleButton.setFocusable(false);
            scrambleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    scrambleButtonActionPerformed(e);
                }
            });

            GroupLayout scramblePanelLayout = new GroupLayout(scramblePanel);
            scramblePanel.setLayout(scramblePanelLayout);
            scramblePanelLayout.setHorizontalGroup(
                    scramblePanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, scramblePanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(scrambleButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED , 0, 0)
                                    .addComponent(scrambleLabel, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(0, 0))
            );
            scramblePanelLayout.setVerticalGroup(
                    scramblePanelLayout.createParallelGroup()
                            .addGroup(scramblePanelLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(scramblePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(scrambleButton)
                                            .addComponent(scrambleLabel))
                                    .addContainerGap(0, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER, false)
                                        .addComponent(scramblePanel, GroupLayout.PREFERRED_SIZE, 785, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TimePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(0,1))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addComponent(scramblePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jerren Trifan
    private JPanel TimePanel;
    private static JLabel timeLabel;
    private JPanel scramblePanel;
    private JLabel scrambleLabel;
    public JButton scrambleButton;


    // JFormDesigner - End of variables declaration  //GEN-END:variables
}


/*

        Color panelColor = new Color(65, 63, 68);
        getContentPane().setBackground(panelColor);


        setDefaultCloseOperation(EXIT_ON_CLOSE);




            TimePanel.setBackground(new Color(90, 93, 95));
*/