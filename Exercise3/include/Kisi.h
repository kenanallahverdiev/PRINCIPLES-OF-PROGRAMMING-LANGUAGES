/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#ifndef KISI_H
#define KISI_H

#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "string.h"

#include "KimlikNo.h"
#include "Telefon.h"

struct KISI
{
	KimlikNo kimlikNumarasi;
	char* AdSoyad;
	int Yas;
	Telefon telefonNumarasi;
	void (*KisiOlustur)(struct KISI*);
	void(*AdSoyadOlustur)(struct KISI*);
	void(*YasOlustur)(struct KISI*);
	char*(*AdiYaz)(struct KISI*);
	int(*YasiYaz)(struct KISI*);
	void(*KisiYokEt)(struct KISI*);
};
typedef struct KISI* Kisi;

Kisi _Kisi();
void _KisiOlustur(Kisi);
void _AdSoyadOlustur(Kisi);
void _YasOlustur(Kisi);
char* _AdiYaz(Kisi);
int _YasiYaz(Kisi);
void _KisiYokEt(Kisi);

#endif