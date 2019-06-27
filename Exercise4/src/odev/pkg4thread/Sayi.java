
/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * @since 09.05.2018
 * <p>  
 *  Odev 4
 * </p>  
 */



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odev.pkg4thread;

/**
 *
 * @author kenan
 */
public class Sayi {
    public String sayi;
    public String[] sayilar;
    
    public Sayi(String sayi)
    {
        this.sayi=sayi;
    }
    public Sayi(String[] sayilar)
    {
        this.sayilar=sayilar;
    }
    public int length()
    {
        return sayi.length();
    }
    public char charAt(int i)
    {
        return sayi.charAt(i);
    }

}
