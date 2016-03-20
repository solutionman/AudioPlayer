// ok, try to do it with JavaFX
// actually it didn't work at all

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;


public class AudioPlayerFX extends Application {

    Stage playerWindow;
    Button playButton;
    Label playingSong;
    public String filetoplay = "back.wav";


    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        playerWindow = primaryStage;
        playerWindow.setTitle("AudioPlayerFX");

        playButton = new Button();
        playButton.setText("Play music");

        playingSong = new Label("");
        playingSong.setText("back.wav");


        playButton.setOnAction(e -> {
            try{

                //Media getsound = new Media(new File(filetoplay).toURI().toString());
                //MediaPlayer mediaPlayer = new MediaPlayer(getsound);

                AudioClip sound = new AudioClip("back.wav");
                sound.play();

            } catch(Exception ex){
                System.out.println("Somethings goes wrong...");
                System.out.println("Some kind of shit happens");
            }
        });


        StackPane layout = new StackPane();
        layout.getChildren().addAll(playButton, playingSong);

        Scene scene = new Scene(layout, 400, 200);
        playerWindow.setScene(scene);
        primaryStage.show();
    }
}


