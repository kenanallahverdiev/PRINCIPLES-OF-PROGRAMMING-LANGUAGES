/** 
 * 
 * @author Kenan Allakhverdiev-kenan.allakhverdiev@ogr.sakarya.edu.tr
 * Parviz Karimili-parviz.karimli@ogr.sakarya.edu.tr
 * @since 11.03.2018
 * <p>  
 *  Odev 1
 * </p>  
 */
#ifndef IMEINO_H
#define IMEINO_H
#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "time.h"
struct IMEINO
{
	char* imeiNumara;
	void(*IMEIkodOlustur)(struct IMEINO*);
	int(*IMEIkontrol)(char*);
	char*(*IMEIyaz)(struct IMEINO*);
	void(*IMEIyokEt)(struct IMEINO*);
};
typedef struct IMEINO* IMEINo;

IMEINo _IMEINO();
void _IMEIkodOlustur(IMEINo);
int _IMEIkontrol(char*);
char* _IMEIyaz(IMEINo);
void _IMEIyokEt(IMEINo);

#endif