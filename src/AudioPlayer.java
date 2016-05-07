// Audio Player

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

public class AudioPlayer extends JFrame {

    public JFrame BaseWindow;
    public JLabel playingInfo;
    public JLabel playlistInfo;
    public JButton play;
    public JButton stop;
    public JButton playlist;
    public JButton openFile;
    public String PathToFile;
    public String FileName;

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

        openFile = new JButton("openFile");
        add(openFile);

        OpenFile of = new OpenFile();
        openFile.addActionListener(of);

        PlayingEvent e = new PlayingEvent();
        play.addActionListener(e);
        stop.addActionListener(e);

        PlaylistEvent ex = new PlaylistEvent();
        playlist.addActionListener(ex);

    }

    public class OpenFile implements ActionListener {
        public void actionPerformed(ActionEvent of){

            JFileChooser ChooseFile = new JFileChooser();
            ChooseFile.setCurrentDirectory(new java.io.File("."));
            //ChooseFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            ChooseFile.setSize(200, 200);
            ChooseFile.setVisible(true);
            ChooseFile.setDialogTitle("Choose the file/folder you want to play");

            int returnValue = ChooseFile.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION){
                File selectedFile = ChooseFile.getSelectedFile();
                System.out.println(selectedFile.getName());
                FileName = selectedFile.getName();
            }

            //PathToFile = ChooseFile.getSelectedFile().getAbsolutePath();
            PathToFile = ChooseFile.getSelectedFile().getPath();
            System.out.println(PathToFile);
            System.out.println(FileName);
        }
    }


    //URL url = PlayingEvent.class.getResource(FileName);
    URL url = PlayingEvent.class.getResource("back.wav");
    AudioClip playing = Applet.newAudioClip(url);

    
    public class PlayingEvent implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equals("play")){
                System.out.println("play pressed");
                playing.play();
                playingInfo.setText("back.wav");
            }
            if(e.getActionCommand().equals("stop")){
                System.out.println("stop pressed");
                playing.stop();
            }

        }
    }

    public class PlaylistEvent implements ActionListener {
        public void actionPerformed(ActionEvent ex) {
            playlistInfo.setText("Here we suppose to see out playlist");
            System.out.println("playlist button pressed");
        }
    }

    public static void main(String args[]) {
        AudioPlayer Core = new AudioPlayer();
        Core.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Core.setSize(400, 200);
        Core.setResizable(false);
        Core.setVisible(true);
        Core.setTitle("Audio Player");

    }
}




