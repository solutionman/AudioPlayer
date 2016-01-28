// Audio Player

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class AudioPlayer extends JFrame {

    public JFrame BaseWindow;
    public JLabel playingInfo;
    public JLabel playlistInfo;
    public JButton play;
    public JButton stop;
    public JButton playlist;


    public AudioPlayer() {
        setLayout(new FlowLayout());

        playingInfo = new JLabel("Silent for now");
        add(playingInfo);

        play = new JButton("play");
        add(play);

        stop = new JButton("stop");
        add(stop);

        playlist = new JButton("playlist");
        add(playlist);

        playlistInfo = new JLabel("Nothing to show");
        add(playlistInfo);

        PlayingEvent e = new PlayingEvent();
        play.addActionListener(e);

        StoppingEvent est = new StoppingEvent();
        stop.addActionListener(est);

        PlaylistEvent ple = new PlaylistEvent();
        playlist.addActionListener(ple);
    }

    public class PlayingEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            try {
                URL url = PlayingEvent.class.getResource("back.wav");
                AudioClip playing = Applet.newAudioClip(url);
                playing.play();
                playing.loop();

            } catch (Exception ex) {

            }
            playingInfo.setText("Now we suppose to play something");
        }
    }

    public class StoppingEvent implements ActionListener {
        public void actionPerformed(ActionEvent est) {
            playingInfo.setText("Now we suppose stop playing");
        }
    }

    public class PlaylistEvent implements ActionListener {
        public void actionPerformed(ActionEvent ple) {
            playlistInfo.setText("Here we suppose to see out playlist");
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




