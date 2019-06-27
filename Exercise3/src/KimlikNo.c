/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#include "KimlikNo.h"

KimlikNo _Kimlik()
{
	KimlikNo kimlik;
	kimlik=(KimlikNo)malloc(sizeof(struct KIMLIKNO));
	kimlik->kimlikNumara=malloc(sizeof(int)*11);
	kimlik->KimlikNumaraOlustur=&_KimlikNumaraOlustur;
	kimlik->KimlikKontrol=&_KimlikKontrol;
	kimlik->KimlikNoYaz=&_KimlikNoYaz;
	kimlik->KimlikNoYokEt=&_KimlikNoYokEt;
	return kimlik;
}

void _KimlikNoYokEt(KimlikNo kimlik)
{
	if(kimlik==NULL)return;
	free(kimlik->kimlikNumara);
	free(kimlik);
}

void _KimlikNumaraOlustur(KimlikNo kimlik)
{
	int TCkimlik[11];
	int tekliToplam=0;
	int ciftliToplam=0;
	
	int hane10,hane11;
	
	TCkimlik[0]=(1+rand()%9);//0dan farkli 9a kadar herhangi bir sayi atama
	for(int i=1;i<9;i++)
		TCkimlik[i]=rand()%9;
	
	//--10.Haneyi bulma
	int i;
	for(i=0;i<9;i+=2)
		tekliToplam+=TCkimlik[i];
	for(i=1;i<8;i+=2)
		ciftliToplam+=TCkimlik[i];
	hane10=((tekliToplam*7)-ciftliToplam)%10;
	TCkimlik[9]=hane10;
	//-----------------
	
	//--11. Haneyi bulma
	int sayi=0;
	for(i=0;i<10;i++)
		sayi+=TCkimlik[i];
	
	hane11=sayi%10;
	TCkimlik[10]=hane11;
	//-----------------
	for(int i=0;i<11;i++)
		kimlik->kimlikNumara[i]=TCkimlik[i]+'0';
	
}
int _KimlikKontrol(char* dizi)
{
	int TCkimlik[11];
	
	for(int i=0;i<11;i++)
		TCkimlik[i]=dizi[i]-'0';
	
	int tekliToplam=0;
	int ciftliToplam=0;
	char hane10,hane11;
	
	//--10.Haneyi bulma
	int i;
	for(i=0;i<9;i+=2)
		tekliToplam+=TCkimlik[i];
	for(i=1;i<8;i+=2)
		ciftliToplam+=TCkimlik[i];
	hane10=(((tekliToplam*7)-ciftliToplam)%10)+'0';
	//-----------------
	
	//--11. Haneyi bulma
	int sayi=0;
	for(i=0;i<10;i++)
	{
		sayi+=TCkimlik[i];
	}
	hane11=(sayi%10)+'0';
	//-----------------
	return dizi[9]==hane10 && dizi[10]==hane11?1:0;
}
char* _KimlikNoYaz(KimlikNo kimlik)
{
	return kimlik->kimlikNumara;
}