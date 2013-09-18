package com.epam.stuffshop.test;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Sub s1 = new Sub();
		Sub s2 = new Sub();
		
		s1.setI(3);
		System.out.println(s2.getI());
		
		System.out.println(s1.entity.hashCode());
		System.out.println(s2.entity.hashCode());
		
		System.out.println(s2.entity == s1.entity);
		
		s1.entity.setCategory("1");
		System.out.println(s2.entity.getCategory());

	}

}
