/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#include "RastgeleKisi.h"

RastgeleKisi _RastgeleKisi()
{
	RastgeleKisi rastgeleKisi;
	rastgeleKisi=(RastgeleKisi)malloc(sizeof(struct RASTGELEKISI));
	rastgeleKisi->kisi=_Kisi();
	rastgeleKisi->RastgeleKisiOlustur=&_RastgeleKisiOlustur;
	rastgeleKisi->DosyayaKaydet=&_DosyayaKaydet;
	rastgeleKisi->DosyakKntrl=&_DosyakKntrl;
	rastgeleKisi->RastgeleKisiYokEt=&_RastgeleKisiYokEt;
	return rastgeleKisi;
}

void _RastgeleKisiYokEt(RastgeleKisi rndKisi)
{
	if(rndKisi==NULL)return;
	rndKisi->kisi->KisiYokEt(rndKisi->kisi);
	free(rndKisi);
}

void _RastgeleKisiOlustur(RastgeleKisi rndKisi)
{
	rndKisi->kisi->KisiOlustur(rndKisi->kisi);
}

void _DosyayaKaydet(RastgeleKisi rastgeleKisi,char* dosyaAdi)
{
	int areFirst=0;
	FILE *file = fopen(dosyaAdi, "a");
	if (file== NULL)
	{
		printf("Kayitlar yazilacak dosya bulunmadi!\n");
		return;
	}
	char *kimlikNo=rastgeleKisi->kisi->kimlikNumarasi->KimlikNoYaz(rastgeleKisi->kisi->kimlikNumarasi);
	char *AdSoyadi=rastgeleKisi->kisi->AdiYaz(rastgeleKisi->kisi);
	int yas=rastgeleKisi->kisi->YasiYaz(rastgeleKisi->kisi);
	char *TelefonNo=rastgeleKisi->kisi->telefonNumarasi->TelefonNoYaz(rastgeleKisi->kisi->telefonNumarasi);
	char *IMEIno=rastgeleKisi->kisi->telefonNumarasi->imeiKod->IMEIyaz(rastgeleKisi->kisi->telefonNumarasi->imeiKod);
	
	if(kimlikNo!=NULL && AdSoyadi!=NULL && TelefonNo!=NULL && IMEIno!=NULL)
	fprintf(file,"%s %s %d %s (%s)\n",kimlikNo,AdSoyadi,yas,TelefonNo,IMEIno);
	else
	{
		printf("Sistemde hata olusdu");
	}
	fclose(file);
}

void _DosyakKntrl(RastgeleKisi rndKisi,char* dosyaAdi)
{
	int counter =0;
	
	int validCounterPSP=0;
	int invalidCounterPSP=0;
	
	int validCounterIMEI=0;
	int invalidCounterIMEI=0;
	
	char metin[150];
	FILE *file=fopen(dosyaAdi,"r");
	if(file==NULL)
	{
		printf("Kontrol edilecek dosya bulunmadi!\n");
		return;
	}
	while(!feof(file))
	{
		if(fgets(metin,150,file)!=NULL)
		{
			int validKimlik=rndKisi->kisi->kimlikNumarasi->KimlikKontrol(metin);
			int validIMEI=rndKisi->kisi->telefonNumarasi->imeiKod->IMEIkontrol(metin);
			
			if(validKimlik==1)
				validCounterPSP++;
			
			else if(validKimlik==0)
				invalidCounterPSP++;
			
			if(validIMEI==1)
				validCounterIMEI++;
			
			else if(validIMEI==0)
				invalidCounterIMEI++;
			
			counter++;
		}
	}
	if(counter<=0)
	{
		printf("Olusturulmus kisi yok\n");
	}
	else
	{
		printf("\nTCKimlik\nGecerli : %d\nGecersiz : %d\n\nIMEINO\nGecerli : %d\nGecersiz : %d\n\n",validCounterPSP,invalidCounterPSP,validCounterIMEI,invalidCounterIMEI);
	}
	fclose(file);
	

}

