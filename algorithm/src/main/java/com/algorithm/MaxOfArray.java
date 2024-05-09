package com.algorithm;

import java.util.Scanner;

public class MaxOfArray {
		static int maxOf(int[] a) {
			int max= a[0];
			for(int i =1; i<a.length;i++)
				if(a[i] > max)
					max = a[i];
			return max;
	
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최대값을 구합니다");
		System.out.println("사람 수: ");
		int num = stdIn.nextInt(); //배열의 요솟수를 입력받음
		
		int [] height = new int[num]; //요솟수사 num인 배열 생성
		
		for(int i =0; i < num ; i++) {
			System.out.println("heigth["+i+"]:");
			height[i] = stdIn.nextInt();
		}
		
		System.out.println("최대값은" + maxOf(height)+ "입니다.");
	}

}
