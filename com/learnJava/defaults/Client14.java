package com.learnJava.defaults;

public class Client14 implements Interface1,Interface4{

	//If we have 2 same method signature in implementing interfaces like Interface 1 and 4
	//Then in Client we have to override the method
	//else we will get compile time error
	//Duplicate default methods named methodA with the parameters () and () are inherited 
	//from the types Interface4 and Interface1
	
    public void  methodA(){
        System.out.println("Inside method A "+Client14.class);
    }

    public static void main(String[] args) {
        Client14 client14 = new Client14();
        client14.methodA();

    }

}
