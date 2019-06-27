/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * @since 27.03.2018
 * <p>  
 *  Odev 2
 * </p>  
 */


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

import java.util.Random;

/**
 *
 * @author kenan
 */
public class IMEINo {
    private String imeiNo;
    
    public void IMEIkodOlustur()
    {
        Random rastgeleSayi=new Random();
        int toplama1=0;
        String toplama2="";
        int toplam3=0;
        int dizi[]=new int[15];
        for (int i = 0; i < 14; i++) 
        {
         dizi[i]=rastgeleSayi.nextInt(10);
        }
        for (int i = 0; i < 14; i+=2) 
        {
            toplama1+=dizi[i];
        }
        for (int i = 1; i < 14; i+=2) 
        {
            toplama2+=dizi[i]*2;    
        }
        for (int i = 0; i < toplama2.length(); i++) {
            toplam3+=Integer.parseInt(String.valueOf(toplama2.toCharArray()[i]));
        }
        int luhnSayi=toplama1+toplam3;
        int kontrolSayi=luhnSayi;
        while(kontrolSayi%10!=0)
        {
            kontrolSayi++;
        }
        int sonIMEIrakam=kontrolSayi-luhnSayi;
        dizi[14]=sonIMEIrakam;
        imeiNo="";
        for (int i = 0; i < 15; i++) {
            imeiNo+=dizi[i];
        }
    }
    public boolean IMEIKontrol(String IMEIkod)
    {
        int dizi[]=new int[15];
        int toplama1=0;
        String toplama2="";
        int toplam3=0;
        char rakam;
        for (int i = 0; i < 15; i++)
        {
            rakam=IMEIkod.toCharArray()[i];
            dizi[i]=Integer.parseInt(String.valueOf(rakam));
        }
        for (int i = 0; i < 14; i+=2) 
        {
            toplama1+=dizi[i];
        }
        for (int i = 1; i < 14; i+=2) 
        {
            toplama2+=dizi[i]*2;    
        }
        for (int i = 0; i < toplama2.length(); i++) {
            toplam3+=Integer.parseInt(String.valueOf(toplama2.toCharArray()[i]));
        }
        int luhnSayi=toplama1+toplam3;
        int kontrolSayi=luhnSayi;
        while(kontrolSayi%10!=0)
        {
            kontrolSayi++;
        }
        int sonIMEIrakam=kontrolSayi-luhnSayi;
        
        return dizi[14]==sonIMEIrakam;
    }
    public String getIMEINo()
    {
        return imeiNo;
    }
}
