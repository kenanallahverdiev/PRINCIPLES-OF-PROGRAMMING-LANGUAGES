/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#include "Kisi.h"
Kisi _Kisi()
{
	Kisi kisi;
	kisi=(Kisi)malloc(sizeof(struct KISI));
	kisi->AdSoyad=malloc(sizeof(char)*25);
	kisi->KisiOlustur=&_KisiOlustur;
	kisi->AdSoyadOlustur=&_AdSoyadOlustur;
	kisi->YasOlustur=&_YasOlustur;
	kisi->AdiYaz=&_AdiYaz;
	kisi->YasiYaz=&_YasiYaz;
	kisi->KisiYokEt=&_KisiYokEt;
	kisi->kimlikNumarasi=_Kimlik();
	kisi->telefonNumarasi=_Telefon();
	return kisi;
}

void _KisiYokEt(Kisi kisi)
{
	if(kisi==NULL)return;
	kisi->kimlikNumarasi->KimlikNoYokEt(kisi->kimlikNumarasi);
	kisi->telefonNumarasi->TelefonYokEt(kisi->telefonNumarasi);
	free(kisi->AdSoyad);
	free(kisi);
}

void _KisiOlustur(Kisi kisi)
{	kisi->AdSoyadOlustur(kisi);
	kisi->YasOlustur(kisi);
	kisi->kimlikNumarasi->KimlikNumaraOlustur(kisi->kimlikNumarasi);
	kisi->telefonNumarasi->TelefonOlustur(kisi->telefonNumarasi);
}

char* _AdiYaz(Kisi kisi)
{
	return kisi->AdSoyad;
}
int _YasiYaz(Kisi kisi)
{
	return kisi->Yas;
}

void _AdSoyadOlustur(Kisi kisi)
{
	int rndAdSoyad=rand()%3000;
	FILE *toFile=fopen("isimler_random.txt","r");
	int sayac =0;
	char AdSoyad[25];
	while(!feof(toFile))
	{
		fgets(AdSoyad,25,toFile);
		if(sayac==rndAdSoyad)
		{
			AdSoyad[strlen(AdSoyad)-1]='\0';
			strcpy(kisi->AdSoyad,AdSoyad);
		}
		sayac++;
	}
	fclose(toFile);
}
void _YasOlustur(Kisi kisi)
{
	kisi->Yas=1+rand()%100;
}