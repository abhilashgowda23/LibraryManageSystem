package org.lms.student;

import org.lms.college.Book;

import java.util.Scanner;

public class Student {
	public String studentName;
	public String regNum;

	Book[] borrowedBooks = new Book[3];
	public int booksCount = 0;

	// Creating object of Scanner class to
	// take input from user
	Scanner input = new Scanner(System.in);


	public Student()
	{
		// Print statement
		System.out.println("Enter Student Name:");

		// This keywords refers to current instance
		this.studentName = input.nextLine();

		// Print statement
		System.out.println("Enter Registration Number:");
		this.regNum = input.nextLine();
	}
}
