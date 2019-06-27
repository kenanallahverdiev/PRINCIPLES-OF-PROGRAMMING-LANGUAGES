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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kenan
 */
public class Kisi {
    protected KimlikNo kimlikNo;
    private String AdSoyad;
    private int yas;
    protected Telefon telefonNo;
    
    public void KisiOlustur(KimlikNo kimlikNo,Telefon telefonNo)
    {
        this.kimlikNo=kimlikNo;
        this.yas=YasOlustur();
        this.telefonNo=telefonNo;
        this.AdSoyad=AdSoyadOlustur();
    }
    private String AdSoyadOlustur()
    {
        Random rastgeleSayi=new Random();
        String metin = null;
        String adlarSoyadlar[]=new String[3000];
        int satirSayi=0;
        try 
        {
            String path="isimler_random.txt";
            File dosyaOku=new File(path);
            try (Scanner scan = new Scanner(dosyaOku)) {
                while (scan.hasNextLine()) {
                    metin=scan.nextLine();
                    adlarSoyadlar[satirSayi]=metin;
                    satirSayi++;
                }
                this.AdSoyad=adlarSoyadlar[rastgeleSayi.nextInt(3000)];
            }
        }catch (FileNotFoundException ex) {
                
            System.out.println("Dosya Bulunmadı");
        }
        return AdSoyad;
    }
    public String getAdSoyad()
    {
        return AdSoyad;
    }
    private int YasOlustur()
    {
        Random rastgeleSayi=new Random();
        return rastgeleSayi.nextInt(101);
    }
    public int getYas()
    {
        return yas;
    }
}
