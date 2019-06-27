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
#include "unistd.h"
int main()
{
	srand(time(NULL));
	RastgeleKisi rndKisi=_RastgeleKisi();
	int secim;
	int sayi;
	do{
		printf("1-Rastgele Kisi Olustur\n2-Dosya Kontrol Et\n3-Cikis\nSecim : ");
		scanf("%d",&secim);
		if(secim==1)
		{
			printf("Kac kisi uretilsin : ");
			scanf("%d",&sayi);
			for(int i=0;i<sayi;i++)
			{
				rndKisi->RastgeleKisiOlustur(rndKisi);
				rndKisi->DosyayaKaydet(rndKisi,"kisiler.txt");//hangi dosyaya kayit edilecek
				//sleep(1);
			}
		}
		else if(secim==2)
			rndKisi->DosyakKntrl(rndKisi,"kisiler.txt");//hangi dosya kontrol edilecek
		else if(secim!=3)
			printf("Ust menuye bakarak secim yapiniz!\n");
	}while(secim!=3);
	rndKisi->RastgeleKisiYokEt(rndKisi);
	return 0;
}
