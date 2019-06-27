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
public class KimlikNo {
    private String kimlikNo;//degisken
    
    public String getKimlikNo()
    {
        return kimlikNo;
    }
    public void TCKimlikNoOlustur()
    {
        Random rastgeleSayi=new Random();
        int dizi[]=new int[11];
        int sayi;
        int tekliSiraSayiToplam=0;
        int ciftSayiToplam=0;
        int sonHaneToplam=0;
        dizi[0]=1+rastgeleSayi.nextInt(9);//ilk hane 0 olamaz
        for (int i = 0; i < 8; i++) {//2-9 aralığda ki haneleri random uretiyor
            sayi=rastgeleSayi.nextInt(10);
            dizi[i+1]=sayi;
        }
        //------10. hanenin hesaplanmasi
        int i;
        for (i = 0; i < 9; i++) 
        {
            tekliSiraSayiToplam+=dizi[i];
            i++;
        }
        for (i = 0; i < 8; i++) 
        {
            i++;
            ciftSayiToplam+=dizi[i];
        }
        tekliSiraSayiToplam*=7;
        int Hane10=(tekliSiraSayiToplam-ciftSayiToplam)%10;//10. hane
        dizi[9]=Hane10;
        //---------------------------

        //------11. hanenin hesaplanmasi
        for (i = 0; i < 10; i++) 
        {
            sonHaneToplam+=dizi[i];
        }
        int Hane11=(sonHaneToplam)%10;//11. hane
        dizi[10]=Hane11;
        //----------------------------
        kimlikNo="";
        for (int j = 0; j < 11; j++) {
            kimlikNo+=dizi[j];
        }
    }
    
    public boolean TCKontrol(String tcKimlikNo)
    {
        int tekliSiraSayiToplam=0;
        int ciftSayiToplam=0;
        int sonHaneToplam=0;
        int dizi[]=new int[11];
        int i;
        char rakam;
        for (i = 0; i < 11; i++) 
        {
            rakam=tcKimlikNo.toCharArray()[i];
            dizi[i]=Integer.parseInt(String.valueOf(rakam));
        }
        for (i = 0; i < 9; i++) 
        {
            tekliSiraSayiToplam+=dizi[i];
            i++;
        }
        for (i = 0; i < 8; i++)
        {
            i++;
            ciftSayiToplam+=dizi[i];
        }
        int Hane10=((tekliSiraSayiToplam*7)-ciftSayiToplam)%10;
        for (i = 0; i < 10; i++)
        {
            sonHaneToplam+=dizi[i];
        }
        int Hane11=(sonHaneToplam)%10;
        return dizi[9]==Hane10 && dizi[10]==Hane11;
    }
    
}
