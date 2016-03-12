// ok, try to do it with JavaFX
// actually it didn't work at all


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AudioPlayerFX extends Application {

    Stage playerWindow;
    Button playButton;


    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        playerWindow = primaryStage;
        playerWindow.setTitle("AudioPlayerFX");
        playButton = new Button();
        playButton.setText("Play music");



        playButton.setOnAction(e -> {
            try{
                AudioClip sound = new AudioClip("back.wav");
                sound.play();
            } catch(Exception ex){
                System.out.println("Somethings goes wrong...");
            }
        });


        StackPane layout = new StackPane();
        layout.getChildren().addAll(playButton);

        Scene scene = new Scene(layout, 300, 200);
        playerWindow.setScene(scene);
        primaryStage.show();
    }
}


