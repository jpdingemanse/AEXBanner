/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.io.IOException;
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
public class AEXBanner extends Application {
    FXMLBannerController ui = new FXMLBannerController();  
    MockEffectenbeurs mockBeurs = new MockEffectenbeurs();
    List<IFonds> koersen = new ArrayList<>();
    Stage primaryStage; 
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBanner.fxml"));
        
        Scene scene = new Scene(root);
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(scene);
        
        this.primaryStage.show();
        
    }
    
    public void stop(){
        primaryStage.close();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void setKoersen(){
        koersen = mockBeurs.getKoersen();
        ui.setLabel(koersen.toString());
    }
}
