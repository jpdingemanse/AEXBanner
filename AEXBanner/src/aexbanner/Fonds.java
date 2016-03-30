/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

/**
 *
 * @author Jean Paul
 */
public class Fonds implements IFonds{
     private String naam;
    private double koers;

    public Fonds(String naam, Double koers){
        this.naam = naam;
        this.koers = koers;
    }
    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public Double getKoers() {
        return koers;
    }
    
    
    
    
}
