#include "rect.h"
#include <stdio.h>

typedef struct Rect{
    int l;
    int c;
    int x;
    int y;
} Rect;

Rect * rect_new(void){
    Rect n;
    n.l = 10;
    n.c = 20;
    n.x = 0;
    n.y = 0;
};

void rect_drag(Rect * this, int dx, int dy){
    this->x += dx;
    this->y += dy;
};

void rect_print(Rect * this) {
    printf("Retângulo na posição (%d, %d)", this->x, this->y);
};
