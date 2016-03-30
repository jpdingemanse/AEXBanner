/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jean Paul
 */
public class MockEffectenbeurs implements IEffectenbeurs {

    @Override
    public List<IFonds> getKoersen() {
        List<IFonds> koersen = new ArrayList<IFonds>();
        
        koersen.add(new Fonds("Aalberts", 10.0));
        koersen.add(new Fonds("ABN AMRO", 7.0));
        koersen.add(new Fonds("Aegon", 6.0));
        koersen.add(new Fonds("Ahold", 2.0));
        koersen.add(new Fonds("Heineken", 6.0));
        koersen.add(new Fonds("Philips", 7.0));
        return koersen;
    }
    
}
