/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Jean Paul
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ResourceBundle;

public class AEXBanner extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 100;
    public static final int NANO_TICKS = 20000000; 
    // FRAME_RATE = 1000000000/NANO_TICKS = 50;

   
   
    private double textLength;
    private double textPosition;
    private BannerController controller;
    private AnimationTimer animationTimer;
    @FXML
    private Label aexBannerLabel;

    public static void main(String[] args) {
        launch(args);
    }
   
    @Override
    public void start(Stage primaryStage) {

        controller = new BannerController(this);

        Font font = new Font("Arial", HEIGHT);
        aexBannerLabel = new Label();
        aexBannerLabel.setFont(font);
       // aexBannerLabel.setFill(Color.BLACK);

       //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
       // aexBannerLabel.setLayoutX(20.0);
       // aexBannerLabel.setLayoutY(20.0);
        Pane root = new Pane();
        root.getChildren().add(aexBannerLabel);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        primaryStage.setTitle("AEX banner");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.toFront();


        // Start animation: text moves from right to left
        animationTimer = new AnimationTimer() {
            private long prevUpdate;

            @Override
            public void handle(long now) {
                long lag = now - prevUpdate;
                if (lag >= NANO_TICKS) {
                    // calculate new location of text
                    // TODO
                    textPosition -= 5;
                    int end = (int) aexBannerLabel.layoutXProperty().get() + (aexBannerLabel.getText().length() * 20);
                    if (end < 0) {
                        textPosition = WIDTH;
                    }
                    aexBannerLabel.relocate(textPosition,0);
			prevUpdate = now;
                }
            }
            @Override
            public void start() {
                prevUpdate = System.nanoTime();
                textPosition = WIDTH;
                aexBannerLabel.relocate(textPosition, 0);
                setKoersen("Koersen aan het laden....");
                super.start();
            }
        };
        animationTimer.start();
    }
    @FXML
  
    public void setKoersen(String koersen) {
        
        aexBannerLabel.setText(koersen);
        textLength = aexBannerLabel.getLayoutBounds().getWidth();
       
    }

    @Override
    public void stop() {
        animationTimer.stop();
        controller.stop();
    }
}

//public class AEXBanner extends Application {
//    
//    MockEffectenbeurs mockBeurs = new MockEffectenbeurs();
//    List<IFonds> koersen = new ArrayList<>();
//    Stage primaryStage; 
//    
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLBanner.fxml"));
//        
//        Scene scene = new Scene(root);
//        this.primaryStage = primaryStage;
//        this.primaryStage.setScene(scene);
//        
//        this.primaryStage.show();
//
//    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//    public void setKoersen(String koersen){
//        
//    }
   
//}
