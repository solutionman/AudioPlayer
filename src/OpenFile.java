
// Here we suppose to choose music to play

import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenFile implements ActionListener {
    public void actionPerformed(ActionEvent of){


        System.out.println("openFile button pressed");
        JFileChooser ChooseFile = new JFileChooser();
        ChooseFile.setCurrentDirectory(new java.io.File("."));
        ChooseFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        ChooseFile.setSize(200, 200);
        ChooseFile.setVisible(true);
        ChooseFile.setDialogTitle("Choose the file/folder you want to play");

        if(of.getActionCommand().equals("openFile")){
            //
        }
        System.out.println(ChooseFile.getSelectedFile().getAbsolutePath());
    }
}


