#include<iostream>
using namespace std;

class Vehicle{
	private:
		int pA = 8;
	protected:
		string fB = "7x";
		void honk(){
			cout << "Tuut" << pA << endl;
		}
	public:
		string brand = "Ford";
		

};

class Car : public Vehicle {
	public:
	string model = "Mustang " + Vehicle::fB;
	void honk1(){
			honk();
	}
};

int main(int argc, char* argv[]){
	Car myCar;
	myCar.honk1();

	return 0;
}