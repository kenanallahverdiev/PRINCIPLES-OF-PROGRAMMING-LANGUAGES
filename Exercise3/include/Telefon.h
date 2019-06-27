/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#ifndef TELEFON_H
#define TELEFON_H
#include "IMEINo.h"
#include "stdio.h"
#include "stdlib.h"
#include "time.h"

struct TELEFON
{
	char* telNumara;
	IMEINo imeiKod;
	void(*TelefonOlustur)(struct TELEFON*);
	char*(*TelefonNoYaz)(struct TELEFON*);
	void (*TelefonYokEt)(struct TELEFON*);
};

typedef struct TELEFON* Telefon;

Telefon _Telefon();
void _TelefonOlustur(Telefon);
char* _TelefonNoYaz(Telefon);
void _TelefonYokEt(Telefon);


#endif