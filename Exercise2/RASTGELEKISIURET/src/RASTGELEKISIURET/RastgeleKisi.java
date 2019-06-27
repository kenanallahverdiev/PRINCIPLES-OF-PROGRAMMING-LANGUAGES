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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author kenan
 */
public class RastgeleKisi {
    
    private final KimlikNo kimlikNo;
    private final IMEINo imeiNo;
    private final Telefon telefon;
    private final Kisi kisi;
    public RastgeleKisi()
    {
        kimlikNo=new KimlikNo();
        imeiNo=new IMEINo();
        telefon=new Telefon();
        kisi=new Kisi();
    }
    public void RndKisiOlustur()
    {
        kimlikNo.TCKimlikNoOlustur();
        imeiNo.IMEIkodOlustur();
        telefon.TelefonOlustur(imeiNo);
        kisi.KisiOlustur(kimlikNo, telefon);
    }
    public void DosyayaKaydet() throws IOException
    {
        File dosyaYaz=new File("kisiler.txt");
        try{
            PrintWriter write;
            write = new PrintWriter(new BufferedWriter(new FileWriter(dosyaYaz,true)));
                write.println(kisi.kimlikNo.getKimlikNo()+" "
                +kisi.getAdSoyad()+" "
                +kisi.getYas()+" "
                +kisi.telefonNo.getNumara()+" "
                +'('+kisi.telefonNo.imeiNo.getIMEINo()+')');
            write.flush();
            write.close();
        }catch(IOException ex)
        {
            System.out.println("Sistem Hatasi : "+ ex);
        }
    }
    public void DosyaKontrolu()
    {
        try {
            String metin=null;
            int gecerliTCsayi=0;
            int gecersizTCsayi=0;
            int gecerliIMEIsayi=0;
            int gecersizIMEIsayi=0;
            int satirSayi=0;
            ArrayList<String> str=new ArrayList<>();
            String path="kisiler.txt";
                File dosyaOku=new File(path);
            try {
                dosyaOku.createNewFile();//eger dosya yok ise,yeni dosya olusturur
            } catch (IOException ex) {
                System.out.println("Dosya Okuma Yazma İşleminde Hata Oluşdu : "+ex);
            }
            try (Scanner scan = new Scanner(dosyaOku)) 
            {
                //dosyadan str listesine satir satir ekleme
                while (scan.hasNextLine()) 
                {
                    metin=scan.nextLine();
                    str.add(metin);
                    satirSayi++;
                }
                if(satirSayi>0)
                {
                    //Kontrol
                    for (int i = 0; i < satirSayi; i++) {
                        String a=str.get(i);
                        if(kimlikNo.TCKontrol(a.substring(0,11)))
                        {
                            gecerliTCsayi++;
                        }
                        else gecersizTCsayi++;
                    }
                    for (int i = 0; i < satirSayi; i++) {
                        String b=str.get(i);
                        int parantezIND=str.get(i).indexOf("(");
                        int parantezIND2=str.get(i).indexOf(")");
                        if(imeiNo.IMEIKontrol(b.substring(parantezIND+1,parantezIND2)))
                        {
                            gecerliIMEIsayi++;
                        }
                        else gecersizIMEIsayi++;
                    }
                    //Ekran cikti
                    System.out.println("\nT.C. Kimlik Kontrol");
                    System.out.println(gecerliTCsayi+" Geçerli");
                    System.out.println(gecersizTCsayi+" Geçersiz\n");
                    System.out.println("IMEI Kontrol");
                    System.out.println(gecerliIMEIsayi+" Geçerli");
                    System.out.println(gecersizIMEIsayi+" Geçersiz\n");
                    
                    
                    
                    
//                    System.out.println("T.C. Kimlik Kontrol");
//                    str.stream().map((string) -> string.substring(0,11)).forEachOrdered((TCkimlikNo) -> {
//                        if(kimlikNo.TCKontrol(TCkimlikNo))
//                            System.out.println(TCkimlikNo+" Geçerli");                            
//                        else
//                            System.out.println(TCkimlikNo+" Geçersiz");
//                    });
//                    System.out.println("IMEI Kontrol");
//                    str.stream().map((string) -> {
//                        int parantezIND=string.indexOf("(");
//                        int parantezIND2=string.indexOf(")");
//                        String IMEIkodNo=string.substring(parantezIND+1,parantezIND2);
//                        return IMEIkodNo;
//                    }).map((IMEIkodNo) -> {
//                        System.out.print(IMEIkodNo);
//                        return IMEIkodNo;
//                    }).forEachOrdered((IMEIkodNo) -> {
//                        if(imeiNo.IMEIKontrol(IMEIkodNo))
//                            System.out.println(IMEIkodNo+" Geçerli");
//                        else
//                            System.out.println(IMEIkodNo+" Geçersiz");
//                    });

                }
                else 
                {
                    System.out.println("Oluşturulmuş Kişi Yok");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunmadı veya oluşturulamadı : "+ex);
        }
    }
}
