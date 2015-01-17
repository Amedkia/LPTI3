/* 
 * File:   main.cpp
 * Author: system
 *
 * Created on 13 de enero de 2015, 11:08 PM
 */

#include <cstdlib>
#include <stdio.h>

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {


    int respuesta;
    int cont1 = 0, cont2 = 0, cont3 = 0;
    int i;

    int regresa = 1;
    
    while (regresa == 1) {

        printf("INSTRUCCIONES\nConteste con: \n  1 para si\n  2 para no \n  3 para Talvez \n  \n");


        printf("\nEres humano:_");
        scanf("%i", &respuesta);
        if (respuesta <= 1) {
            printf("\n Bien hecho\n");
        } else if (respuesta >= 2) {
            printf("\nNO LO CREO\n");
        }
        else
            printf("vuelva a intentar");

        printf("\nPI ES IGUAL A 3.1416:");
        scanf("%i", &respuesta);
        if (respuesta <= 1) {
            printf("\n Bien hecho\n");
        } else if (respuesta >= 2) {
            printf("NO LO CREO");
        }
        else
            printf("vuelva a intentar");


        printf("\nLA CAPITAL DE ECUADOR ES QUITO:_");
        scanf("%i", &respuesta);
        if (respuesta <= 1) {
            printf("\n SUPONGO\n");
        } else if (respuesta >= 2) {
            printf("\nNI YO ME LA SE\n");
        }
        else
            printf("vuelva a intentar");

        printf("\nERES UN ROBOT:_");
        scanf("%i", &respuesta);
        if (respuesta <= 1) {
            printf("\n BIP-BUP-BI-BU-BOP\n");
        } else if (respuesta >= 2) {
            printf("\nTE CREO\n");
        }
        else
            printf("vuelva a intentar");

        printf("\nTE HAN ASALTADO");
        scanf("%i", &respuesta);
        if (respuesta <= 1) {
            printf("\n LASTIMA\n");
        } else if (respuesta >= 2) {
            printf("\nLO HARAN\n");
        }
        else
            printf("vuelva a intentar");

        printf("\nEL CIELO ES AZUL");
        scanf("%i", &respuesta);
        if (respuesta <= 1) {
            printf("\nY LAS ROSAS SON ROJAS\n");
        } else if (respuesta >= 2) {
            printf("\nSEGUROESTA NUBLADO\n");
        }
        else
            printf("vuelva a intentar");

//No entiendo para que es esta parte del switch.....
        switch (respuesta) {
            case 1: cont1++;
                break;

            case 2: cont2++;
                break;

            case 3: cont3++;
                break;

            default: printf("\n\n Valor no aceptado\n");
                break;

        }//fin del switch

        printf("Desea volver a intentarlo? 1.- Si 2.- No");
        scanf("%i", &regresa);
    }




    return 0;
}