/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#include "Telefon.h"
Telefon _Telefon()
{
	Telefon telefon;
	telefon=(Telefon)malloc(sizeof(struct TELEFON));
	telefon->telNumara=malloc(sizeof(char)*11);
	telefon->TelefonOlustur=&_TelefonOlustur;
	telefon->TelefonNoYaz=&_TelefonNoYaz;
	telefon->imeiKod=_IMEINO();
	telefon->TelefonYokEt=&_TelefonYokEt;
	return telefon;
	
}

void _TelefonYokEt(Telefon telefon)
{
	if(telefon==NULL)return;
	telefon->imeiKod->IMEIyokEt(telefon->imeiKod);
	free(telefon->telNumara);
	free(telefon);
}

void _TelefonOlustur(Telefon telefon)
{
	
	int numara[11];
	int GSMoperators[]={540,541,542,543,544,545,546,547,548,549,505,506,507,551,552,553,554,555,556,557,558,559,530,532,533,534,535,536,537,538,539};
	int secilenGSM=GSMoperators[rand()%31];
	//--->GSM operatoru ayirarak ekleme
	numara[0]=0;
	numara[1]=secilenGSM/100;
	numara[2]=(secilenGSM/10)%10;
	numara[3]=secilenGSM%10;
	for(int i=4;i<11;i++)//diger haneleri random atama
		numara[i]=rand()%10;
		
	for(int i=0;i<11;i++)
		telefon->telNumara[i]=numara[i]+'0';
	
	telefon->telNumara[11]='\0';
	telefon->imeiKod->IMEIkodOlustur(telefon->imeiKod);
}

char* _TelefonNoYaz(Telefon telefon)
{
	return telefon->telNumara;
}