/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#ifndef RASTGELEKISI_H
#define RASTGELEKISI_H
#include "stdlib.h"
#include "stdio.h"
#include "string.h"
#include "Kisi.h"

struct RASTGELEKISI
{
	Kisi kisi;
	void(*RastgeleKisiOlustur)(struct RASTGELEKISI*);
	void(*DosyayaKaydet)(struct RASTGELEKISI*,char*);
	void(*DosyakKntrl)(struct RASTGELEKISI*,char*);
	void(*RastgeleKisiYokEt)(struct RASTGELEKISI*);
};
typedef struct RASTGELEKISI* RastgeleKisi;

RastgeleKisi _RastgeleKisi();
void _RastgeleKisiOlustur(RastgeleKisi);
void _DosyayaKaydet(RastgeleKisi,char*);
void _DosyakKntrl(RastgeleKisi,char*);
void _RastgeleKisiYokEt(RastgeleKisi);

#endif