// for testing
// works with wav, doesn't work with mp3

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;

public class AudioPlayerFX2 extends Application {

    Button play;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Audio Player FX");

        play = new Button();
        play.setText("Play");

        try{
        URL resource = getClass().getResource("back.wav");
        //URL resource = getClass().getResource("work.mp3");
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

         }catch (Exception e){
            System.out.println("Something goes wrong");
        }

        StackPane layout = new StackPane();
        layout.getChildren().add(play);
        primaryStage.setWidth(400);
        primaryStage.setHeight(250);
        primaryStage.show();
    }
}



