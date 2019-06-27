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

import java.io.*;
import java.util.Arrays;

public class Qaralama {

   public static void main(String args[]) {
        String metin =null;
        int sayacD=0;
        int sayacS=0;
        SinifOzellikleri sinifOzellikleri=new SinifOzellikleri();
        sinifOzellikleri.DegiskenAdi=new String[100];
        sinifOzellikleri.DegiskenTuru=new String[100];
        sinifOzellikleri.UyeFonkAdi=new String[100];
        sinifOzellikleri.DonusTuru=new String[100];
        sinifOzellikleri.AldigiParametre=new int[100];
        sinifOzellikleri.ParametreAdi=new String[100][100];
        sinifOzellikleri.ParametreTuru=new String[100][100];
        String dosyaAdi="C:\\\\Users\\\\kenan\\\\Desktop\\dosya.java";
        try
        {
            FileReader fayliOxuyan =new FileReader(dosyaAdi);
            try (BufferedReader buferdenOxuyan = new BufferedReader(fayliOxuyan)) 
            {
                String[] soz;
                while((metin=buferdenOxuyan.readLine())!=null)
                {
                    sinifOzellikleri.AldigiParametre[sayacS]=1;
                    soz = metin.split("\\s+|,\\s*");
                    for (int i = 0; i < soz.length; i++) 
                    {
                        if("private".equals(soz[i]) || "public".equals(soz[i]) || "protected".equals(soz[i]))
                        {
                            for (int j = i+1; j < soz.length; j++) 
                            {
                                if("class".equals(soz[j]))
                                {
                                    StringBuilder yapici= new StringBuilder();
                                            for(String deger : soz[j+1].split("\\{"))
                                            {
                                                yapici.append(deger);
                                            }
                                    sinifOzellikleri.SinifinAdi=yapici.toString();
                                    
                                }
                                else
                                {
                                    if(soz[j].endsWith(";"))//eger deisken ise
                                    {
                                        sinifOzellikleri.AltElemanlar++;

                                        if(soz[j].length()>1)
                                        {
                                            StringBuilder yapici= new StringBuilder();
                                            for(String deger : soz[j].trim().split(";"))
                                            {
                                                yapici.append(deger);
                                            }
                                            sinifOzellikleri.DegiskenAdi[sayacD]=yapici.toString();
                                            sinifOzellikleri.DegiskenTuru[sayacD]=soz[j-1];
                                        }
                                        else 
                                        {
                                            sinifOzellikleri.DegiskenAdi[sayacD]=soz[j-1];
                                            sinifOzellikleri.DegiskenTuru[sayacD]=soz[j-2];
                                        }
                                        sayacD++;
                                    }
                                    else if(soz[j].endsWith("{"))//eger deisken degil ise
                                    {
                                        for (int k=0;k<soz.length;k++)//satirdaki kelimeler arasinda '(' ariyor
                                        {
                                            char[] chars = soz[k].toCharArray();
                                            for (int m = 0; m < chars.length; m++) 
                                            {
                                                if((chars[m]=='(' && chars.length<2))//eger '(' iki tarafdanda bosluklarla ayrilmisdir
                                                {
                                                    if(!"public".equals(soz[k-2])&&!"private".equals(soz[k-2])&&!"protected".equals(soz[k-2]))
                                                    {
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=soz[k-1];
                                                        sinifOzellikleri.DonusTuru[sayacS]=soz[k-2];
                                                        //-----------------------------------/virgul aramasi
                                                        if(soz[k+1].startsWith(")"))//eger parantezler arasi bosluk ve parametre yok ise
                                                        {
                                                            sinifOzellikleri.AldigiParametre[sayacS]--;
                                                        }
                                                        else
                                                        {
                                                            //===dizideki satirin tum sozlerini karakter dizisine atip virgul sayisini cikartim
                                                            StringBuilder yapici= new StringBuilder();
                                                            for(String deger : soz)
                                                            {
                                                                yapici.append(deger);
                                                            }
                                                            char[] virgul=yapici.toString().toCharArray();
                                                            for (int l = 0; l < virgul.length; l++) {
                                                                if(virgul[l]==',')
                                                                {
                                                                    sinifOzellikleri.AldigiParametre[sayacS]++;
                                                                }
                                                            }
                                                            //========
                                                            //********Parametre isi
                                                            int indexOfV1=metin.indexOf("(");
                                                            int indexOf2=metin.indexOf(")");
                                                            metin=metin.substring(indexOfV1+1,indexOf2);
                                                            String[] parantezlerIci = metin.trim().split("\\s+|,\\s*");
                                                            int a=0;
                                                            int b=sinifOzellikleri.AldigiParametre[sayacS];
                                                            for (int q = 0; q <b*2; q++) 
                                                            {
                                                                if(soz[k+2].endsWith(","))
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                    q=q+1;
                                                                    k=k+2;
                                                                    a++;
                                                                }
                                                                else if(soz[k+2].contains(",") && !soz[k+2].endsWith(","))
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                    q=q+1;
                                                                    k=k+1;
                                                                    a++;
                                                                }
                                                                else if(!soz[k+2].contains(",") && !soz[k+2].contains(")"))
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                    q=q+2;
                                                                    k=k+2;
                                                                    a++;
                                                                }
                                                                else
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];   
                                                                    if(sinifOzellikleri.AldigiParametre[sayacS]==1)
                                                                    {
                                                                       b=b-b; 
                                                                    }
                                                                    else 
                                                                    {
                                                                        b=b-(b-1);
                                                                    }
                                                                    
                                                                }
                                                            }
                                                            //********
                                                        }
                                                        //-------------------------------------
                                                        sayacS++;
                                                        sinifOzellikleri.UyeFonksiyonlar++;
                                                    }
                                                    else if(sinifOzellikleri.SinifinAdi.equals(soz[k-1]))
                                                    {
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=soz[k-1];
                                                        sinifOzellikleri.DonusTuru[sayacS]="yok";
                                                        if(soz[k+1].startsWith(")"))
                                                        {
                                                            sinifOzellikleri.AldigiParametre[sayacS]=0;
                                                        }
                                                        sayacS++;
                                                        sinifOzellikleri.UyeFonksiyonlar++;
                                                    }
                                                }
                                                else if(chars[m]=='(' && chars.length>1 && soz[k].endsWith("("))//eger '(' fonk adina birlesik ise
                                                {
                                                    if(!"public".equals(soz[k-1])&&!"private".equals(soz[k-1])&&!"protected".equals(soz[k-1]))
                                                    {
                                                        StringBuilder yapici= new StringBuilder();
                                                        for(String deger : soz[k].split("\\("))
                                                        {
                                                            yapici.append(deger);
                                                        }
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=yapici.toString();
                                                        sinifOzellikleri.DonusTuru[sayacS]=soz[k-1];
                                                    }
                                                    else if(sinifOzellikleri.SinifinAdi.equals(soz[k].substring(0,soz[k].length()-1)))
                                                    {
                                                        StringBuilder yapici= new StringBuilder();
                                                        for(String deger : soz[k].split("\\("))
                                                        {
                                                            yapici.append(deger);
                                                        }
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=yapici.toString();
                                                        sinifOzellikleri.DonusTuru[sayacS]="yok";
                                                    }
                                                    if(soz[k+1].startsWith(")"))//eger parantezler arasi bosluk ve parametre yok ise
                                                    {
                                                        sinifOzellikleri.AldigiParametre[sayacS]--;
                                                    }
                                                    else
                                                    {
                                                        //===dizideki satirin tum sozlerini karakter dizisine atip virgul sayisini cikartim
                                                        StringBuilder yapici2= new StringBuilder();
                                                        for(String deger : soz)
                                                        {
                                                            yapici2.append(deger);
                                                        }
                                                        char[] virgul=yapici2.toString().toCharArray();
                                                        for (int l = 0; l < virgul.length; l++) {
                                                            if(virgul[l]==',')
                                                            {
                                                                sinifOzellikleri.AldigiParametre[sayacS]++;
                                                            }
                                                        }
                                                        //========
                                                        //********Parametre isi
                                                        int indexOfV1=metin.indexOf("(");
                                                        int indexOf2=metin.indexOf(")");
                                                        metin=metin.substring(indexOfV1+1,indexOf2);
                                                        String[] parantezlerIci = metin.trim().split("\\s+|,\\s*");
                                                        int a=0;
                                                        int b=sinifOzellikleri.AldigiParametre[sayacS];
                                                        for (int q = 0; q <b*2; q++) 
                                                        {
                                                            if(soz[k+2].endsWith(","))
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                q=q+1;
                                                                k=k+2;
                                                                a++;
                                                            }
                                                            else if(soz[k+2].contains(",") && !soz[k+2].endsWith(","))
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                q=q+1;
                                                                k=k+1;
                                                                a++;
                                                            }
                                                            else if(!soz[k+2].contains(",") && !soz[k+2].contains(")"))
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                q=q+2;
                                                                k=k+3;
                                                                a++;
                                                            }
                                                            else
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];   
                                                                if(sinifOzellikleri.AldigiParametre[sayacS]==1)
                                                                {
                                                                   b=b-b; 
                                                                }
                                                                else 
                                                                {
                                                                    b=b-(b-1);
                                                                }

                                                            }
                                                        }
                                                        //********
                                                    }
                                                    sayacS++;
                                                    sinifOzellikleri.UyeFonksiyonlar++;
                                                }
                                                else if(chars[m]=='(' && chars.length>1 && !soz[k].startsWith("("))//eger '(' her iki tarafida birlesik
                                                {
                                                    int indexOf=soz[k].indexOf("(");
                                                    if(!"public".equals(soz[k-1]) && !"private".equals(soz[k-1]) && !"protected".equals(soz[k-1]))
                                                    {
                                                        int indexOFParantez =soz[k].indexOf("(");
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=soz[k].substring(0,indexOFParantez);
                                                        sinifOzellikleri.DonusTuru[sayacS]=soz[k-1];
                                                    }
                                                    else if(sinifOzellikleri.SinifinAdi.equals(soz[k].subSequence(0, indexOf)))
                                                    {
                                                        String[] sozler=soz[k].split("\\(");
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=sozler[0];
                                                        sinifOzellikleri.DonusTuru[sayacS]="yok";
                                                        
                                                    }
                                                    if(soz[k].contains(")")||soz[k+1].contains(")"))//eger parantezler arasi bosluk ve parametre yok ise
                                                    {
                                                        sinifOzellikleri.AldigiParametre[sayacS]--;
                                                    }
                                                    else
                                                    {
                                                        //===dizideki satirin tum sozlerini karakter dizisine atip virgul sayisini cikartim
                                                        StringBuilder yapici= new StringBuilder();
                                                        for(String deger : soz)
                                                        {
                                                            yapici.append(deger);
                                                        }
                                                        char[] virgul=yapici.toString().toCharArray();
                                                        for (int l = 0; l < virgul.length; l++) {
                                                            if(virgul[l]==',')
                                                            {
                                                                sinifOzellikleri.AldigiParametre[sayacS]++;
                                                            }
                                                        }
                                                        //========
                                                        //********Parametre isi
                                                        int indexOfV1=metin.indexOf("(");
                                                        int indexOf2=metin.indexOf(")");
                                                        metin=metin.substring(indexOfV1+1,indexOf2);
                                                        String[] parantezlerIci = metin.trim().split("\\s+|,\\s*");
                                                        int a=0;
                                                        int b=sinifOzellikleri.AldigiParametre[sayacS];
                                                        for (int q = 0; q <b*2; q++) 
                                                        {
                                                            if(soz[k+1].endsWith(","))
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                q=q+1;
                                                                k=k+2;
                                                                a++;
                                                            }
                                                            else if(soz[k+1].contains(",") && !soz[k+1].endsWith(","))
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                q=q+1;
                                                                k=k+1;
                                                                a++;
                                                            }
                                                            else if(!soz[k+1].contains(",") && !soz[k+1].contains(")"))
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                q=q+2;
                                                                k=k+2;
                                                                a++;
                                                            }
                                                            else
                                                            {
                                                                sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];   
                                                                if(sinifOzellikleri.AldigiParametre[sayacS]==1)
                                                                {
                                                                   b=b-b; 
                                                                }
                                                                else 
                                                                {
                                                                    b=b-(b-1);
                                                                }

                                                            }
                                                        }
                                                        //********
                                                    }
                                                    
                                                    sayacS++;
                                                    sinifOzellikleri.UyeFonksiyonlar++;
                                                }
                                                else if(chars[m]=='(' && chars.length>1 && soz[k].startsWith("("))//eger '(' parametrenin degisken turune birlesik ise
                                                {
                                                    if(!"public".equals(soz[k])&&!"private".equals(soz[k])&&!"protected".equals(soz[k]))
                                                    {
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=soz[k-1];
                                                        sinifOzellikleri.DonusTuru[sayacS]=soz[k-2];
                                                    }
                                                    else if(sinifOzellikleri.SinifinAdi.equals(soz[k-1]))
                                                    {
                                                        sinifOzellikleri.UyeFonkAdi[sayacS]=soz[k-1];
                                                        sinifOzellikleri.DonusTuru[sayacS]="yok";
                                                    }
                                                    if(soz[k].contains(")")||")".equals(soz[k+1]))//eger parantezler arasi bosluk ve parametre yok ise
                                                        {
                                                            sinifOzellikleri.AldigiParametre[sayacS]--;
                                                        }
                                                        else
                                                        {
                                                            //===dizideki satirin tum sozlerini karakter dizisine atip virgul sayisini cikartim
                                                            StringBuilder yapici= new StringBuilder();
                                                            for(String deger : soz)
                                                            {
                                                                yapici.append(deger);
                                                            }
                                                            char[] virgul=yapici.toString().toCharArray();
                                                            for (int l = 0; l < virgul.length; l++) {
                                                                if(virgul[l]==',')
                                                                {
                                                                    sinifOzellikleri.AldigiParametre[sayacS]++;
                                                                }
                                                            }
                                                            //========
                                                            //********Parametre isi
                                                            int indexOfV1=metin.indexOf("(");
                                                            int indexOf2=metin.indexOf(")");
                                                            metin=metin.substring(indexOfV1+1,indexOf2);
                                                            String[] parantezlerIci = metin.trim().split("\\s+|,\\s*");
                                                            int a=0;
                                                            int b=sinifOzellikleri.AldigiParametre[sayacS];
                                                            for (int q = 0; q <b*2; q++) 
                                                            {
                                                                if(soz[k+1].endsWith(","))
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                    q=q+1;
                                                                    k=k+2;
                                                                    a++;
                                                                }
                                                                else if(soz[k+1].contains(",") && !soz[k+1].endsWith(","))
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                    q=q+1;
                                                                    k=k+1;
                                                                    a++;
                                                                }
                                                                else if(!soz[k+1].contains(",") && !soz[k+1].contains(")"))
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];
                                                                    q=q+2;
                                                                    k=k+3;
                                                                    a++;
                                                                }
                                                                else
                                                                {
                                                                    sinifOzellikleri.ParametreTuru[sayacS][a]=parantezlerIci[q];
                                                                    sinifOzellikleri.ParametreAdi[sayacS][a]=parantezlerIci[q+1];   
                                                                    if(sinifOzellikleri.AldigiParametre[sayacS]==1)
                                                                    {
                                                                       b=b-b; 
                                                                    }
                                                                    else 
                                                                    {
                                                                        b=b-(b-1);
                                                                    }
                                                                    
                                                                }
                                                            }
                                                            //********
                                                        }
                                                    sayacS++;
                                                    sinifOzellikleri.UyeFonksiyonlar++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch(FileNotFoundException ex)
        {
            System.out.println("'" +dosyaAdi + "' dosya bulunmadı"); 
        }catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        sinifOzellikleri.Yazdir();

        
    }
}