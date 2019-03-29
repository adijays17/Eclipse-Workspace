package com.oops.concept;

public class C extends B {
	public String m2() {
		return "C";
	}
	
	public static void main(String[] args) throws Exception{
		B obj = new C();
		System.out.println(obj.m2());
	}
}
