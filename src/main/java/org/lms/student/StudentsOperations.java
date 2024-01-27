package org.lms.student;

import org.lms.college.Book;
import org.lms.operations.BooksOperations;
import org.lms.student.Student;

import java.util.Scanner;

public class StudentsOperations {
	// Scanner Object
	Scanner input = new Scanner(System.in);
	Student theStudents[] = new Student[50];

	public static int count = 0;


	// To add books
	public void addStudent(Student s) {
		for (int i = 0; i < count; i++) {

			if (s.regNum.equalsIgnoreCase(
					theStudents[i].regNum)) {


				System.out.println(
						"Student of Reg Num " + s.regNum
								+ " is Already Registered.");

				return;
			}
		}

		if (count <= 50) {
			theStudents[count] = s;
			count++;
		}
	}


	// Displaying all students
	public void showAllStudents() {
		// Printing student name and
		// corresponding registered number
		System.out.println("Student Name\t\tReg Number");
		for (int i = 0; i < count; i++) {

			System.out.println(theStudents[i].studentName
					+ "\t\t"
					+ theStudents[i].regNum);
		}
	}

	// To check the Student
	public int isStudent() {
		// Display message only
		System.out.println("Enter Reg Number:");

		String regNum = input.nextLine();

		for (int i = 0; i < count; i++) {

			if (theStudents[i].regNum.equalsIgnoreCase(
					regNum)) {
				return i;
			}
		}

		// Print Logs
		System.out.println("Student is not Registered.");
		System.out.println("Get Registered First.");

		return -1;
	}

	// Method 4
	public void checkOutBook(BooksOperations book) {
		int studentIndex = this.isStudent();

		if (studentIndex != -1) {
			System.out.println("checking out");

			book.showAllBooks();
			Book b = book.checkOutBook();

			System.out.println("checking out");
			if (b != null) {

				if (theStudents[studentIndex].booksCount
						<= 3) {

					System.out.println("adding book");
					theStudents[studentIndex].borrowedBooks
							[theStudents[studentIndex]
							.booksCount]
							= b;
					theStudents[studentIndex].booksCount++;

					return;
				} else {

					System.out.println(
							"Student Can not Borrow more than 3 Books.");
					return;
				}
			}
			System.out.println("Book is not Available.");
		}
	}


	// To add the book
	public void checkInBook(BooksOperations book) {
		int studentIndex = this.isStudent();
		if (studentIndex != -1) {

			// Printing credentials corresponding to student
			System.out.println(
					"S.No\t\t\tBook Name\t\t\tAuthor Name");

			Student s = theStudents[studentIndex];

			for (int i = 0; i < s.booksCount; i++) {

				System.out.println(
						s.borrowedBooks[i].sNo + "\t\t\t"
								+ s.borrowedBooks[i].bookName + "\t\t\t"
								+ s.borrowedBooks[i].authorName);
			}

			// Display message only
			System.out.println(
					"Enter Serial Number of Book to be Checked In:");

			int sNo = input.nextInt();

			for (int i = 0; i < s.booksCount; i++) {
				if (sNo == s.borrowedBooks[i].sNo) {
					book.checkInBook(s.borrowedBooks[i]);
					s.borrowedBooks[i] = null;

					return;
				}
			}

			System.out.println("Book of Serial No " + sNo
					+ "not Found");
		}
	}

}
