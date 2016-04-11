/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jean Paul
 */
public class MockEffectenbeurs implements IEffectenbeurs {
    List<IFonds> koersen;
    @Override
    public List<IFonds> getKoersen() {
        koersen = new ArrayList<IFonds>();
        
        Random rand = new Random(); 
        int value = rand.nextInt(10); 
        System.out.println(value);
        
        koersen.add(new Fonds("Aalberts", value + 10.0));
        koersen.add(new Fonds("ABN AMRO", value + 7.0));
        koersen.add(new Fonds("Aegon", value + 6.0));
        koersen.add(new Fonds("Ahold", value + 2.0));
        koersen.add(new Fonds("Heineken", value + 6.0));
        koersen.add(new Fonds("Philips", value + 7.0));
        return koersen;
    }
    
    
    
}
