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
 * and open the template in the editor.1

 */
package test;
import RASTGELEKISIURET.*;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author kenan
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        RastgeleKisi kisi=new RastgeleKisi();
        Scanner iString=new Scanner(System.in);
        Scanner iInt=new Scanner(System.in);
        String secim="";
        while(!"3".equals(secim))
        {
            System.out.print("1- Rastgele Kişi Üret\n2- Üretilmiş Dosya Kontrol Et\n3- Çıkış\nSeçim : ");
            secim=iString.nextLine().trim();
            if("1".equals(secim))
            {
                System.out.print("Kaç kişi Üretilsin : ");
                int kisiSayisi=iInt.nextInt();
                for (int i = 1; i <= kisiSayisi; i++)
                {
                    kisi.RndKisiOlustur();
                    kisi.DosyayaKaydet();
                }
            }
            else if("2".equals(secim))
            {
                kisi.DosyaKontrolu();
            }
            else if(!"3".equals(secim)&&!"2".equals(secim)&&!"1".equals(secim))
            {
                System.out.println("-Hatalı Seçim");
            }
        }
    }
}