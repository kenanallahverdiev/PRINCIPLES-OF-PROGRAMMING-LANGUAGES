/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1 
 * </p>  
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qaralama;

/**
 *
 * @author kenan
 */
public class SinifOzellikleri {
    public String SinifinAdi;
    public int AltElemanlar;
    public int UyeFonksiyonlar;
    public String[] DegiskenAdi;
    public String[] DegiskenTuru;
    public String[] UyeFonkAdi;
    public String[] DonusTuru;
    public int[] AldigiParametre;
    public String[][] ParametreAdi;
    public String[][] ParametreTuru;
    public void Yazdir(){
        System.out.println("Sınıf Adı :"+SinifinAdi);
        System.out.println("Alt elemanlar :"+AltElemanlar);
        for (int i = 0; i < AltElemanlar; i++) {
           System.out.println(DegiskenAdi[i]+"-"+DegiskenTuru[i]);
       }
        System.out.println("Üye Fonksiyonlar :"+UyeFonksiyonlar);
        for (int i = 0; i < UyeFonksiyonlar; i++)
        {
            System.out.println(UyeFonkAdi[i]);
            System.out.println("Dönüş Türü: "+DonusTuru[i]);
            System.out.println("Aldığı Parametre: "+AldigiParametre[i]);
            int[] a=new int[1];
            a[0]=AldigiParametre[i];
            int b=a[0];
            for (int j = 0; j < b; j++) {
                System.out.println(ParametreAdi[i][j]+"-"+ParametreTuru[i][j]);
            }
            System.out.println("----------------");
        }
        
    }
}
