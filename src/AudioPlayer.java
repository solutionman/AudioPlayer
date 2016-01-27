// Audio Player

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AudioPlayer extends JFrame {

    public JFrame BaseWindow;
    public JLabel playingInfo;
    public JButton play;
    public JButton stop;


    public AudioPlayer() {
        setLayout(new FlowLayout());

        playingInfo = new JLabel("Silent for now");
        add(playingInfo);

        play = new JButton("play");
        add(play);

        stop = new JButton("stop");
        add(stop);

        PlayingEvent e = new PlayingEvent();
        play.addActionListener(e);

        StoppingEvent est = new StoppingEvent();
        stop.addActionListener(est);
    }

    public class PlayingEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            playingInfo.setText("Now we suppose to play something");
        }
    }

    public class StoppingEvent implements ActionListener {
        public void actionPerformed(ActionEvent est) {
            playingInfo.setText("Now we suppose stop playing");
        }
    }

    public static void main(String args[]) {
        AudioPlayer Core = new AudioPlayer();
        Core.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Core.setSize(400, 200);
        Core.setVisible(true);
        Core.setTitle("Audio Player");

    }
}




