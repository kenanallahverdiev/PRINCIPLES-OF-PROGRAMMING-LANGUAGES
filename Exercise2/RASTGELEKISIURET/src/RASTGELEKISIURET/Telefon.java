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
public class Telefon
{
  private String numara;
  protected IMEINo imeiNo;
  
  public void TelefonOlustur(IMEINo imeiNo)
  {
    Random rastgeleSayi = new Random();
    int[] dizi = new int[11];
    String[] GSMOperatorler = { "0540", "0541", "0542", "0543", "0544", "0545", "0546", "0547", "0548", "0549", "0505", "0506", "0507", "0551", "0552", "0553", "0554", "0555", "0556", "0557", "0558", "0559", "0530", "0532", "0533", "0534", "0535", "0536", "0537", "0538", "0539" };
    String randomSecilernGSM = GSMOperatorler[rastgeleSayi.nextInt(31)];
    for (int i = 0; i < 4; i++) {
      dizi[i] = Integer.parseInt(String.valueOf(randomSecilernGSM.toCharArray()[i]));
    }
    for (int i = 4; i < 11; i++)
    {
      dizi[i] = rastgeleSayi.nextInt(10);
    }
    numara="";
    for (int i = 0; i < 11; i++) {
      numara += dizi[i];
    }
    this.imeiNo = imeiNo;
  }
  public String getNumara()
  {
    return this.numara;
  }
}
