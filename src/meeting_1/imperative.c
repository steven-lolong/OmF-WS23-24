#include<stdio.h>

void goTo(){
	const int a =17;
	startJump:
	printf("Hello world");

	goto newJump;
	printf("before new jump label");

	newJump:
	printf("Hallo from new jump");
	goto startJump;
}

void jumpIt(){
	int a = 0;
	for(int i =1; i < 100; i++){
		a++;
		// continue;
		break;
		printf("%d", i);
	}
	printf("jump %d", a);
}

int main (int argc, char* argv[]){

	goTo();
	jumpIt();
	return 0;
}