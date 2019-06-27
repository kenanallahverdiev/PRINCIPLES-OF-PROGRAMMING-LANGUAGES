/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#ifndef KIMLIKNO_H
#define KIMLIKNO_H
#include "stdlib.h"
#include "stdio.h"
#include "time.h"

struct KIMLIKNO
{
	char* kimlikNumara;
	void(*KimlikNumaraOlustur)(struct KIMLIKNO*);
	int (*KimlikKontrol)(char*);
	char* (*KimlikNoYaz)(struct KIMLIKNO*);
	void (*KimlikNoYokEt)(struct KIMLIKNO*);
};
typedef struct KIMLIKNO* KimlikNo;

KimlikNo _Kimlik();
void _KimlikNumaraOlustur(KimlikNo);
int _KimlikKontrol(char*);
char* _KimlikNoYaz(KimlikNo);
void _KimlikNoYokEt(KimlikNo);
#endif