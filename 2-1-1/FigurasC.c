#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

typedef struct {
    int radius;
    float excentrity;
    int posx, posy;
} Circle;

typedef struct{
    int x, y;
    int p1, p2, p3, p4, p5;
    
} Pentagon;

void printCircle(Circle *c){
    printf("\n\nCirculo de raio: %d \nPosicao:(%d, %d), \nExcentricidade: %.2f", c->radius, c->posx, c->posy, c->excentrity);
}
void printPent(Pentagon *p){
    printf("\nPentagono nos vertices:\nv1: %d \nv2: %d \nv3: %d \nv4: %d \nv5: %d \nPosicao(%d, %d)",p->p1, p->p2, p->p3, p->p4, p->p5, p->x, p->y);
};


int main(){

    Pentagon p1 = {15, 30, 150, 120, 90, 60, 30};
    printPent(&p1);

    Circle c1 = {9, 1.0, 50, 50};
    printCircle(&c1);
};