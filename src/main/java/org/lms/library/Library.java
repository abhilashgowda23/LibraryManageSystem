package org.lms.library;

import org.lms.student.StudentsOperations;
import org.lms.college.Book;
import org.lms.operations.BooksOperations;
import org.lms.student.Student;

import java.util.Scanner;

public class Library {
	public static void main(String[] args)
	{
		// Creating object of Scanner class
		// to take input from user
		Scanner input = new Scanner(System.in);

		// Displaying menu
		System.out.println(
				"********************Welcome to the ABHI'S Library!********************");
		System.out.println(
				"                 Please Select From The Following Options:               ");
		System.out.println(
				"**********************************************************************");

		// Creating object of book class
		BooksOperations ob = new BooksOperations();
		// Creating object of students class
		StudentsOperations obStudent = new StudentsOperations();

		int choice;
		int searchChoice;

		//Creating Menu
		do {

			ob.dispMenu();
			choice = input.nextInt();


			switch (choice) {

				// Case
				case 1:
					Book b = new Book();
					ob.addBook(b);
					break;

				// Case
				case 2:
					ob.upgradeBookQty();
					break;

				// Case
				case 3:

					System.out.println(
							" press 1 to Search with Book Serial No.");
					System.out.println(
							" Press 2 to Search with Book's Author Name.");
					searchChoice = input.nextInt();

					switch (searchChoice) {

						// Case
						case 1:
							ob.searchBySno();
							break;

						// Case
						case 2:
							ob.searchByAuthorName();
					}
					break;

				// Case
				case 4:
					ob.showAllBooks();
					break;

				// Case
				case 5:
					Student s = new Student();
					obStudent.addStudent(s);
					break;

				// Case
				case 6:
					obStudent.showAllStudents();
					break;

				// Case
				case 7:
					obStudent.checkOutBook(ob);
					break;

				// Case
				case 8:
					obStudent.checkInBook(ob);
					break;

				// Default case that will execute for sure
				// if above cases does not match
				default:

					// Print statement
					System.out.println("ENTER BETWEEN 0 TO 8.");
			}

		}


		// checking case entered value is not zero
		while (choice != 0);
	}
}
