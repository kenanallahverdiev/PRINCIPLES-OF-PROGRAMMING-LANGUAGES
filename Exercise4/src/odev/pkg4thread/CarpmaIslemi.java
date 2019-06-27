
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
public class CarpmaIslemi implements Runnable{

    
    private Sayi sayi1;
    private Sayi sayi2;
    private Sayi crpmSnc;
    private int i,kalik;
    public CarpmaIslemi()
    {}
    public CarpmaIslemi(Sayi sayi1,Sayi sayi2,int i,int kalik,Sayi crpmSnc)
    {
        this.crpmSnc = crpmSnc;
        this.sayi1=sayi1;
        this.sayi2=sayi2;
        this.i=i;
        this.kalik=kalik;
    }
    @Override
    public void run() 
    {
        for (int j = sayi1.length()-1; j >=0; j--) 
        {
            int sayi;
            String a=String.valueOf(Integer.parseInt(String.valueOf(sayi2.charAt(i)))*Integer.parseInt(String.valueOf(sayi1.charAt(j))));
            sayi=Integer.parseInt(a)+kalik;
            kalik=sayi/10;
            crpmSnc.sayilar[i]=String.valueOf(sayi%10)+crpmSnc.sayilar[i];
            if(j==0 && kalik!=0)crpmSnc.sayilar[i]=String.valueOf(kalik)+crpmSnc.sayilar[i];
        }
    }
    
}
