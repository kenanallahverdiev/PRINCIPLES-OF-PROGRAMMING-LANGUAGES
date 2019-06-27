/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#include "IMEINo.h"


IMEINo _IMEINO()
{
	IMEINo imei;
	imei=(IMEINo)malloc(sizeof(struct IMEINO));
	imei->imeiNumara=malloc(sizeof(int)*15);
	imei->IMEIkodOlustur=&_IMEIkodOlustur;
	imei->IMEIkontrol=&_IMEIkontrol;
	imei->IMEIyaz=&_IMEIyaz;
	imei->IMEIyokEt=&_IMEIyokEt;
	return imei;
}

void _IMEIyokEt(IMEINo imei)
{
	if(imei == NULL) return; 
	free(imei ->imeiNumara);
	free(imei); 
	
}

char* _IMEIyaz(IMEINo imei)
{
	return imei->imeiNumara;
}

void _IMEIkodOlustur(IMEINo imei)
{
	int tekliSayitoplami=0;
	int ciftliSayiToplami=0;
	
	int imeiDizi[15];
	
	for(int i=0;i<15;i++)//dizinin 14 elemanini rastgele ata
		imeiDizi[i]=rand()%10;
		
	for(int i=0;i<14;i+=2)//tekli sirali sayilarin toplami
		tekliSayitoplami+=imeiDizi[i];
		
	for(int i=1;i<14;i+=2)//ciftli sirali sayilarin Toplami
		ciftliSayiToplami+=((imeiDizi[i]*2)%10+(imeiDizi[i]*2)/10);
		
	int luhnSayi=tekliSayitoplami+ciftliSayiToplami;
	int kontrolSayi=luhnSayi;
	
	while(kontrolSayi%10!=0)
		kontrolSayi++;
	
	int sonIMEIrakam=kontrolSayi-luhnSayi;
	
	imeiDizi[14]=sonIMEIrakam;
	
	for(int i=0;i<15;i++)
		imei->imeiNumara[i]=imeiDizi[i]+'0';
	
	imei->imeiNumara[15]='\0';
}
int _IMEIkontrol(char* dizi)
{
	int counter=0;//sayici
	int lastChIndex;//last character index(sonuncu indexi donuste kullanacaz)
	int IMEINO[15];
	
	for(int i=0;i<strlen(dizi);i++)//parametreyle gelen satirin icinde '(' bulup ondan 15 iterasyon sonraya kadar IMEINO`nun icinde int turunde kopyalama
	{
		if(dizi[i]=='(')
		{
			for(int j=i+1;j<=i+15;j++)
			{
				IMEINO[counter]=dizi[j]-'0';
				counter++;
				lastChIndex=j;
			}
			break;
		}
	}
	int tekliSayitoplami=0;
	int ciftliSayiToplami=0;
	
	for(int i=0;i<14;i+=2)//tekli sirali sayilarin toplami		
			tekliSayitoplami+=IMEINO[i];
		
	for(int i=1;i<14;i+=2)//ciftli sirali Sayilarin Toplami
		ciftliSayiToplami+=((IMEINO[i]*2)%10+(IMEINO[i]*2)/10);
		
	int luhnSayi=tekliSayitoplami+ciftliSayiToplami;
	int kontrolSayi=luhnSayi;
	
	while(kontrolSayi%10!=0)
		kontrolSayi++;
	
	char sonIMEIrakam=(kontrolSayi-luhnSayi)+'0';
	
	return dizi[lastChIndex]==sonIMEIrakam?1:0;
}

