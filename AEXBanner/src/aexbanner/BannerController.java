package aexbanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.Timer;
import javafx.application.Platform;

/**
 * FXML Controller class
 *
 * @author Jean Paul
 */
public class BannerController {
    private AEXBanner banner;
    private IEffectenbeurs effectenbeurs;
    private Timer pollingTimer;
    List<IFonds> beurs;

    public BannerController(AEXBanner banner) {

        this.banner = banner;
 
        this.effectenbeurs = new MockEffectenbeurs();
        
        class PeriodiekeActie extends java.util.TimerTask{
            BannerController bannerController;
            private PeriodiekeActie(BannerController aThis) {
                this.bannerController = aThis;
                this.run();
            }

            @Override
            public void run() {
               Platform.runLater(new Runnable() {
            @Override
            public void run() {
               bannerController.setBeurs();
            }
        });
    }}
          
        // Start polling timer: update banner every two seconds
        pollingTimer = new Timer();

        pollingTimer.schedule(new PeriodiekeActie(this),0,  2000);  
       
         
    }

    // Stop banner controller
    public void stop() {
        pollingTimer.cancel();
        // Stop simulation timer of effectenbeurs
        // TODO
    }

    private void setBeurs() {
        beurs = effectenbeurs.getKoersen();
        int i =0;
        String koersenString = "";
        for (IFonds f : beurs){
            
            koersenString = koersenString + f.getNaam() + " " + f.getKoers() + " ";
            i++;
        }

        banner.setKoersen(koersenString);
    }
}

//public class BannerController implements Initializable, Remote {
//    @FXML
//    private Label label;
//
//    private AnimationTimer antimer;
//    private MockEffectenbeurs beurs = new MockEffectenbeurs();
//    private Registry reg;
//    
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//            
//        }
//
//    public void setKoersen(String koersen) {
//        
//    }
//    
//    public void getKoersen(){
//        beurs.getKoersen();
//    }
//}
    

