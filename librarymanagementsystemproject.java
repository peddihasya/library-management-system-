package com.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {
	@Id
	private Integer book_id;
	private String title;
	private Integer publicationYear;
	private String category;
	private Integer copies;
	private Integer iSBN;
	
	@OneToOne(targetEntity=BookHasAuthor.class)
	private BookHasAuthor authorofBook;
	 
	@OneToMany(mappedBy="book",cascade=CascadeType.ALL)
	List<Transaction1> list=new ArrayList<Transaction1>();

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCopies() {
		return copies;
	}

	public void setCopies(Integer copies) {
		this.copies = copies;
	}

	public Integer getiSBN() {
		return iSBN;
	}

	public void setiSBN(Integer iSBN) {
		this.iSBN = iSBN;
	}

	public BookHasAuthor getAuthorofBook() {
		return authorofBook;
	}

	public void setAuthorofBook(BookHasAuthor authorofBook) {
		this.authorofBook = authorofBook;
	}

	public List<Transaction1> getList() {
		return list;
	}

	public void setList(List<Transaction1> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", title=" + title + ", publicationYear=" + publicationYear + ", category="
				+ category + ", copies=" + copies + ", iSBN=" + iSBN + ", authorofBook=" + authorofBook + "]";
	}
	
	
	

}
package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Author {
	@Id
	private Integer author_id;
	private String author_fname;
	private String author_lname;
	private String Nationality;
	private String dateOfBirth;
	private int authorcol;
	@OneToOne(targetEntity=BookHasAuthor.class)
	private BookHasAuthor bookauthor;
	
	public Integer getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_fname() {
		return author_fname;
	}
	public void setAuthor_fname(String author_fname) {
		this.author_fname = author_fname;
	}
	public String getAuthor_lname() {
		return author_lname;
	}
	public void setAuthor_lname(String author_lname) {
		this.author_lname = author_lname;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getAuthorcol() {
		return authorcol;
	}
	public void setAuthorcol(int i) {
		this.authorcol = i;
	}
	public BookHasAuthor getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(BookHasAuthor bookauthor) {
		this.bookauthor = bookauthor;
	}
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_fname=" + author_fname + ", author_lname=" + author_lname
				+ ", Nationality=" + Nationality + ", dateOfBirth=" + dateOfBirth + ", authorcol=" + authorcol
				+ ", bookauthor=" + bookauthor + "]";
	}


}
package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Transaction1 {
	@Id
	private Integer transaction_id;
	private String dueDate;
	private String issueDate;
	private String returnDate;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@OneToOne(targetEntity=Fine.class)
	private Fine fine;
	
	@OneToOne(targetEntity=Member.class)
	private Member member1;

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", dueDate=" + dueDate + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + ", book=" + book + ", fine=" + fine + ", member1=" + member1 + "]";
	}

	public Integer getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Fine getFine() {
		return fine;
	}

	public void setFine(Fine fine) {
		this.fine = fine;
	}

	public Member getMember1() {
		return member1;
	}

	public void setMember1(Member member1) {
		this.member1 = member1;
	}

}
package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Fine {
	@Id
	private Integer fine_id;
	private String fineDate;
	private Double fineAmount;
	private String paymentDate;
	private Double paymentAmount;
	
	@OneToOne(targetEntity=Transaction1.class)
	private Transaction1 transaction;

	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;

	public Integer getFine_id() {
		return fine_id;
	}

	public void setFine_id(Integer fine_id) {
		this.fine_id = fine_id;
	}

	public String getFineDate() {
		return fineDate;
	}

	public void setFineDate(String fineDate) {
		this.fineDate = fineDate;
	}

	public Double getFneAmount() {
		return fineAmount;
	}

	public void setFneAmount(Double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Transaction1 getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction1 transaction) {
		this.transaction = transaction;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public String toString() {
		return "Fine [fine_id=" + fine_id + ", fineDate=" + fineDate + ", fneAmount=" + fineAmount + ", paymentDate="
				+ paymentDate + ", paymentAmount=" + paymentAmount + ", transaction=" + transaction + ", member="
				+ member + "]";
	}

}
package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BookHasAuthor {
	@Id
	private Integer baid;
	
	public Integer getBaid() {
		return baid;
	}
	public void setBaid(Integer baid) {
		this.baid = baid;
	}
	@OneToOne(targetEntity=Author.class)
	private Author author;
	@OneToOne(targetEntity=Book.class)
	private Book book;
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "BookHasAuthor [author=" + author + ", book=" + book + "]";
	}
	

}
package com.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Member {

	@Id
	private Integer member_id;
	private String name;
	private String joinDate;
	private String status;
	
	@OneToMany(mappedBy="member")
	List<Fine> finelist=new ArrayList<Fine>();
	
	@OneToOne(targetEntity=Transaction1.class)
	private Transaction1 transaction1;
	
	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Fine> getFinelist() {
		return finelist;
	}

	public void setFinelist(List<Fine> finelist) {
		this.finelist = finelist;
	}

	public Transaction1 getTransaction1() {
		return transaction1;
	}

	public void setTransaction1(Transaction1 transaction1) {
		this.transaction1 = transaction1;
	}

	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", name=" + name + ", joinDate=" + joinDate + ", status=" + status
				+ ", finelist=" + finelist + ", transaction1=" + transaction1 + "]";
	}

}
package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private Integer student_id;
	private Integer student_year;
	private Integer student_rollno;
	
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_year=" + student_year + ", student_rollno="
				+ student_rollno + "]";
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getStudent_year() {
		return student_year;
	}
	public void setStudent_year(Integer student_year) {
		this.student_year = student_year;
	}
	public Integer getStudent_rollno() {
		return student_rollno;
	}
	public void setStudent_rollno(Integer student_rollno) {
		this.student_rollno = student_rollno;
	}
	

}
package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeachingStaff {
	@Id
	private Integer teachingStaff_id;
	private String designation;
	@Override
	public String toString() {
		return "TeachingStaff [teachingStaff_id=" + teachingStaff_id + ", designation=" + designation + "]";
	}
	public Integer getTeachingStaff_id() {
		return teachingStaff_id;
	}
	public void setTeachingStaff_id(Integer teachingStaff_id) {
		this.teachingStaff_id = teachingStaff_id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	

}
package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NonTeachingStaff {
	@Id
	private Integer nonteaching_id;
	private String designation;
	
	public Integer getNonteaching_id() {
		return nonteaching_id;
	}
	public void setNonteaching_id(Integer nonteaching_id) {
		this.nonteaching_id = nonteaching_id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Override
	public String toString() {
		return "NonTeachingStaff [nonteaching_id=" + nonteaching_id + ", designation=" + designation + "]";
	}
	
	

}
package com.library.service;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.Fine;
import com.library.entity.Member;
import com.library.entity.NonTeachingStaff;
import com.library.entity.Student;
import com.library.entity.TeachingStaff;
import com.library.entity.Transaction1;

public interface Service {
	
	public void insertBook(Book b);
	public void insertBookHasAuthor(Book b);
	public void insertAuthor(Author a);
	public void insertTransaction1(Transaction1 t);
	public void insertFine(Fine f);
	public void insertMember(Member m);
	public void insertStudent(Student s);
	public void insertTeachingStaff(TeachingStaff t);
	public void insertNonTeachingStaff(NonTeachingStaff n);
	
	public void updateBook(Book b);
	public void updateBookHasAuthor(Book b);
	public void updateAuthor(Author a);
	public void updateTransaction1(Transaction1 t);
	public void updateFine(Fine f);
	public void updateMember(Member m);
	public void updateStudent(Student s);
	public void updateTeachingStaff(TeachingStaff t);
	public void updateNonTeachingStaff(NonTeachingStaff n);
	
	public void deleteBook(Book b);
	public void deleteBookHasAuthor(Book b);
	public void deleteAuthor(Author a);
	public void deleteTransaction1(Transaction1 t);
	public void deleteFine(Fine f);
	public void deleteMember(Member m);
	public void deleteStudent(Student s);
	public void deleteTeachingStaff(TeachingStaff t);
	public void deleteNonTeachingStaff(NonTeachingStaff n);
	
	public void getBook(Integer id);
	public void getAuthor(Integer id); 
	public void getTransaction1(Integer id) ;
	public void getFine(Integer id);
	public void getMember(Integer id);
	public void getStudent(Integer id);
	public void getTeachingStaff(Integer id);
	public void getNonTeachingStaff(Integer id);
	
	public void displayBook(Integer id);
	public void displayAuthor(Integer id); 
	public void displayTransaction1(Integer id) ;
	public void displayFine(Integer id);
	public void displayMember(Integer id);
	public void displayStudent(Integer id);
	public void displayTeachingStaff(Integer id);
	public void displayNonTeachingStaff(Integer id);
	
	
	
	

}
package com.library.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.Fine;
import com.library.entity.Member;
import com.library.entity.NonTeachingStaff;
import com.library.entity.Student;
import com.library.entity.TeachingStaff;
import com.library.entity.Transaction1;
import com.library.util.UtilityConfig;


	public class ServiceImpl implements Service
	{
		 SessionFactory sfactory=UtilityConfig.getSession();
		Session session;
		//creating object of transaction to start the transaction process
		Transaction transaction;
		@Override
		public void insertBook(Book b) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(b);
				transaction.commit();
				System.out.println("inserted book");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void insertBookHasAuthor(Book b) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(b);
				transaction.commit();
				System.out.println("inserted bookhasauthor");
				}
				finally {
				session.close();
				}	
		}
		@Override
		public void insertAuthor(Author a) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(a);
				transaction.commit();
				System.out.println("inserted author");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void insertTransaction1(Transaction1 t)
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(t);
				transaction.commit();
				System.out.println("inserted transaction");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void insertFine(Fine f) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(f);
				transaction.commit();
				System.out.println("inserted fine");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void insertMember(Member m) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(m);
				transaction.commit();
				System.out.println("inserted member");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void insertStudent(Student s) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(s);
				transaction.commit();
				System.out.println("inserted student");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void insertTeachingStaff(TeachingStaff t) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(t);
				transaction.commit();
				System.out.println("inserted teachingstaff");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void insertNonTeachingStaff(NonTeachingStaff n) 
		{
			try {
				session=sfactory.openSession();
			    transaction=session.beginTransaction();
				session.save(n);
				transaction.commit();
				System.out.println("inserted nonteachingstaff");
				}
				finally {
				session.close();
				
				}
			
		}
		@Override
		public void updateBook(Book b)
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(b);
				transaction.commit();
				System.out.println("updated book");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateBookHasAuthor(Book b) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(b);
				transaction.commit();
				System.out.println("updated bookhasauthor details");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateAuthor(Author a)
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(a);
				transaction.commit();
				System.out.println("updated author");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateTransaction1(Transaction1 t)
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(t);
				transaction.commit();
				System.out.println("updated transaction");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateFine(Fine f) 
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(f);
				transaction.commit();
				System.out.println("updated fine");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateMember(Member m) 
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(m);
				transaction.commit();
				System.out.println("updated member");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateStudent(Student s) 
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(s);
				transaction.commit();
				System.out.println("updated student");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateTeachingStaff(TeachingStaff t) 
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(t);
				transaction.commit();
				System.out.println("updated specializatons");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void updateNonTeachingStaff(NonTeachingStaff n) 
		{
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.saveOrUpdate(n);
				transaction.commit();
				System.out.println("updated nonteachingstaff");
				}
				finally {
					session.close();
					
				}
			
		}
		@Override
		public void deleteBook(Book b)
		{
			try {
				session=sfactory.openSession();
			transaction=session.beginTransaction();
			session.delete(b);
			transaction.commit();
			System.out.println("deleted book details");
			}
			finally {
			session.close();
			
			}
		}
	
		public void deleteBookHasAuthor(Book b) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(b);
				transaction.commit();
				System.out.println("deleted bookhasauthor details");
				}
				finally {
				session.close();
				
				}
		}
		@Override
		public void deleteAuthor(Author a) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(a);
				transaction.commit();
				System.out.println("deleted author details");
				}
				finally {
				session.close();
				
				}
		}
		
		public void deleteTransaction1(Transaction1 t) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(t);
				transaction.commit();
				System.out.println("deleted transaction details");
				}
				finally {
				session.close();
				
				}
		}
		@Override
		public void deleteFine(Fine f) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(f);
				transaction.commit();
				System.out.println("deleted fine details");
				}
				finally {
				session.close();
				
				}
		}
		@Override
		public void deleteMember(Member m) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(m);
				transaction.commit();
				System.out.println("deleted member details");
				}
				finally {
				session.close();
				
				}
		}
		@Override
		public void deleteStudent(Student s) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(s);
				transaction.commit();
				System.out.println("deleted student details");
				}
				finally {
				session.close();
				
				}
		}
		@Override
		public void deleteTeachingStaff(TeachingStaff t) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(t);
				transaction.commit();
				System.out.println("deleted teachingstaff details");
				}
				finally {
				session.close();
				
				}
		}
		@Override
		public void deleteNonTeachingStaff(NonTeachingStaff n) {
			try {
				session=sfactory.openSession();
				transaction=session.beginTransaction();
				session.delete(n);
				transaction.commit();
				System.out.println("deleted nonteachingstaff details");
				}
				finally {
				session.close();
				
				}
		}
		@Override
		public void getBook(Integer id) 
		{
			try {
				session=sfactory.openSession();
				Book b=session.get(Book.class, id);
				System.out.println(b);
			}
			finally {
				session.close();
			}	
		
			
		}
		@Override
		public void getAuthor(Integer id) 
		{
			try {
				session=sfactory.openSession();
				Author a=session.get(Author.class, id);
				System.out.println(a);
			}
			finally {
				session.close();
			}	
			
		}
		@Override
		public void getTransaction1(Integer id) 
		{
			try {
				session=sfactory.openSession();
				Transaction t=session.get(Transaction.class, id);
				System.out.println(t);
			}
			finally {
				session.close();
			}	
			
		}
		@Override
		public void getMember(Integer id) 
		{
			try {
				session=sfactory.openSession();
				Member m=session.get(Member.class, id);
				System.out.println(m);
			}
			finally {
				session.close();
			}	
			
		}
		@Override
		public void getFine(Integer id) 
		{
			try {
				session=sfactory.openSession();
				Fine f=session.get(Fine.class, id);
				System.out.println(f);
			}
			finally {
				session.close();
			}	
			
		}
		@Override
		public void getStudent(Integer id) 
		{
			try {
				session=sfactory.openSession();
				Student s=session.get(Student.class, id);
				System.out.println(s);
			}
			finally {
				session.close();
			}	
			
		}
		@Override
		public void getTeachingStaff(Integer id) 
		{
			try {
				session=sfactory.openSession();
				TeachingStaff t=session.get(TeachingStaff.class, id);
				System.out.println(t);
			}
			finally {
				session.close();
			}	
			
		}
		@Override
		public void getNonTeachingStaff(Integer id) 
		{
			try {
				session=sfactory.openSession();
				NonTeachingStaff n=session.get(NonTeachingStaff.class, id);
				System.out.println(n);
			}
			finally {
				session.close();
			}
			
			}
			
		
		@Override
		public void displayBook(Integer id) {
			
				TypedQuery tq=session.createQuery("from Patient");
				List<Book> list=tq.getResultList();
				Iterator<Book> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				
				}
		}
		@Override
		public void displayAuthor(Integer id) {
			
				TypedQuery tq=session.createQuery("from Author");
				List<Author> list=tq.getResultList();
				Iterator<Author> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
		}
		@Override
		public void displayTransaction1(Integer id) {
			
				TypedQuery tq=session.createQuery("from Transaction1");
				List<Transaction> list=tq.getResultList();
				Iterator<Transaction> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				
				}
			}
		@Override
		public void displayFine(Integer id) {
			
				TypedQuery tq=session.createQuery("from Fine");
				List<Fine> list=tq.getResultList();
				Iterator<Fine> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				
				}
		}
		@Override
		public void displayMember(Integer id) {
			
				TypedQuery tq=session.createQuery("from Member");
				List<Member> list=tq.getResultList();
				Iterator<Member> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				
				}
		}
		@Override
		public void displayStudent(Integer id) {
			
				TypedQuery tq=session.createQuery("from Student");
				List<Student> list=tq.getResultList();
				Iterator<Student> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				
				}
		}
		@Override
		public void displayTeachingStaff(Integer id) {
			
				TypedQuery tq=session.createQuery("from TeachingStaf");
				List<TeachingStaff> list=tq.getResultList();
				Iterator<TeachingStaff> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				
				}
		}
		@Override
		public void displayNonTeachingStaff(Integer id) {
			
				TypedQuery tq=session.createQuery("from NonTeachingStaff");
				List<NonTeachingStaff> list=tq.getResultList();
				Iterator<NonTeachingStaff> itr=list.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
			
		}
	
	
		
		}
package com.library.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class UtilityConfig {

		public static SessionFactory getSession() {
			
			StandardServiceRegistry ssregistry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			
			Metadata metadata=new MetadataSources(ssregistry).getMetadataBuilder().build();
			
			
			SessionFactory sfactory=metadata.buildSessionFactory();
		
		return sfactory;
	}

}

	<?xml version="1.0" encoding="UTF-8"?>

<hibernate-configuration>
	<session-factory>
      <!-- Database connection settings -->
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/librarymangementsystem</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">Hasyapeddi433</property>
    <property name="hibernate.current_session_context_class">thread</property>

    <!-- JDBC connection pool settings -->
    <property name="hibernate.c3p0.min_size">5</property>
    <property name="hibernate.c3p0.max_size">20</property>
    <!-- Other Hibernate properties -->
    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.hbm2ddl.auto">update</property>
    <mapping class="com.library.entity.Book"/>
    <mapping class="com.library.entity.BookHasAuthor"/>
    <mapping class="com.library.entity.Author"/>
    <mapping class="com.library.entity.Transaction1"/>
    <mapping class="com.library.entity.Fine"/>
    <mapping class="com.library.entity.Member"/>
    <mapping class="com.library.entity.Student"/>
    <mapping class="com.library.entity.TeachingStaff"/>
    <mapping class="com.library.entity.NonTeachingStaff"/>

    


	</session-factory>
</hibernate-configuration>

package com.libraryman;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.BookHasAuthor;
import com.library.entity.Fine;
import com.library.entity.Member;
import com.library.entity.NonTeachingStaff;
import com.library.entity.Student;
import com.library.entity.TeachingStaff;
import com.library.entity.Transaction1;
import com.library.service.ServiceImpl;
import com.library.util.UtilityConfig;

public class Implementation 
{
	public static void main(String args[]) throws Exception
	{
	System.out.println("Welcome to the library management system");
	Scanner sc=new Scanner(System.in);
	System.out.println("You are 1.User 2.Admin \nEnter Choice");
	int user = sc.nextInt();
	
    ServiceImpl service = new ServiceImpl();
   
    if(user==1)
    {
    	System.out.println("1.get book details");
    	System.out.println("2.get author details");
    	System.out.println("3.get transaction1 details");
    	System.out.println("4.get fine details");    	
    	System.out.println("5.get member details");
    	System.out.println("6.get student details");
    	System.out.println("7.get teachingstaff details");
    	System.out.println("8.get nonteaching staff details \n enter choice");
    	int a = sc.nextInt();
    	while (a > 0) 
        {
   		switch (a) 
   			
        {
   		case 1:
   			System.out.println("enter book id");
   			Integer bid=sc.nextInt();
   			service.getBook(bid);
   		      break;
   		case 2:
   			System.out.println("enter author id");
   			Integer aid=sc.nextInt();
   			service.getAuthor(aid);
   			break;
   		
   		case 3:
   			System.out.println("enter transaction id");
   			Integer tid=sc.nextInt();
   			service.getTransaction1(tid);
   			break;
   		case 4:
   			System.out.println("enter fine id");
   			Integer fid=sc.nextInt();
   			service.getFine(fid);
   			break;
   		case 5:
   			System.out.println("enter member id");
   			Integer mid=sc.nextInt();
   			service.getMember(mid);
   			break;
   		case 6:
   			System.out.println("enter student id");
   			Integer sid=sc.nextInt();
   			service.getStudent(sid);
   			break;
   		case 7:
   			System.out.println("enter teachingstaff id");
   			Integer tsid=sc.nextInt();
   			service.getTeachingStaff(tsid);
   			break;
   		case 8:
   			System.out.println("enter nonteachingstaff id");
   			Integer nid=sc.nextInt();
   			service.getNonTeachingStaff(nid);
   			break;
   		
   		default:System.out.println("invalid choice");
   				break;
        }
   		System.out.println("1.get book details");
    	System.out.println("2.get author details");
    	System.out.println("3.get transaction1 details");
    	System.out.println("4.get fine details");    	
    	System.out.println("5.get member details");
    	System.out.println("6.get student detail");
    	System.out.println("7.get teachingstaff details");
    	System.out.println("8.get nonteaching staff details \n enter choice \n press 0 to exit");
        a = sc.nextInt();
    } 
	}
    else if(user==2) {
    	System.out.println("1.get book details");
    	System.out.println("2.get author details");
    	System.out.println("3.get transaction1 details");
    	System.out.println("4.get fine details");    	
    	System.out.println("5.get member details");
    	System.out.println("6.get student detail");
    	System.out.println("7.get teachingstaff details");
    	System.out.println("8.get nonteaching staff details ");
    	System.out.println("9.get bookhasauthor details");
    	System.out.println("10.insert book details");
    	System.out.println("11.insert bookhasauthor details");
    	System.out.println("12.insert author details");
    	System.out.println("13.insert transaction1 details");
    	System.out.println("14.insert fine details");
    	System.out.println("15.insert member details");
    	System.out.println("16.insert student details");
    	System.out.println("17.insert teachingstaff details");
    	System.out.println("18.insert nonteachingstaff details");
    	System.out.println("19.update book details");
    	System.out.println("20.update bookhasauthor details");
    	System.out.println("21.update author details");
    	System.out.println("22.update transaction1 details");
    	System.out.println("23.update fine details");
    	System.out.println("24.update member details");
    	System.out.println("25.update student details");
    	System.out.println("26.update teachingstaff details");
    	System.out.println("27update nonteachingstaff details.");
    	System.out.println("28.delete book details");
    	System.out.println("29.delete bookhasauthor details");
    	System.out.println("30.delete author details");
    	System.out.println("31.delete transaction1 details");
    	System.out.println("32.delete fine details");
    	System.out.println("33.delete member details");
    	System.out.println("34.delete student details");
    	System.out.println("35.delete teachingstaff details");
    	System.out.println("36.delete nonteaching details");
    	System.out.println("37.display book");
    	int a = sc.nextInt();
		while (a > 0) 
		{
			switch (a) 
			{
			case 1:
	   			System.out.println("enter book id");
	   			Integer bid=sc.nextInt();
	   			service.getBook(bid);
	   		      break;
	   		case 2:
	   			System.out.println("enter author id");
	   			Integer aid=sc.nextInt();
	   			service.getAuthor(aid);
	   			break;
	   		
	   		case 3:
	   			System.out.println("enter transaction id");
	   			Integer tid=sc.nextInt();
	   			service.getTransaction1(tid);
	   			break;
	   		case 4:
	   			System.out.println("enter fine id");
	   			Integer fid=sc.nextInt();
	   			service.getFine(fid);
	   			break;
	   		case 5:
	   			System.out.println("enter member id");
	   			Integer mid=sc.nextInt();
	   			service.getMember(mid);
	   			break;
	   		case 6:
	   			System.out.println("enter student id");
	   			Integer sid=sc.nextInt();
	   			service.getStudent(sid);
	   			break;
	   		case 7:
	   			System.out.println("enter teachingstaff id");
	   			Integer tsid=sc.nextInt();
	   			service.getTeachingStaff(tsid);
	   			break;
	   		case 8:
	   			System.out.println("enter nonteachingstaff id");
	   			Integer nid=sc.nextInt();
	   			service.getNonTeachingStaff(nid);
	   			break;
	   		case 9:
	   			System.out.println("enter book has author details");
	   	        break;
	   		
	   		case 10:
	   			Book b=new Book();   			
	   			System.out.println("enter book id");
	   			b.setBook_id(sc.nextInt());
	   			System.out.println("enter book title ");
	   			b.setTitle(sc.next());
	   			System.out.println("enter publication year");
	   			b.setPublicationYear(sc.nextInt());
	   			System.out.println("enter category");
	   			b.setCategory(sc.next());
	   			System.out.println("enter copies");
	   			b.setCopies(sc.nextInt());
	   			System.out.println( "enter ISBN");
	   			b.setiSBN(sc.nextInt());
	   		    service.insertBook(b);
	   		    break;
	   		case 11:
	   			Author au=new Author();   			
	   			System.out.println("enter author id");
	   			au.setAuthor_id(sc.nextInt());
	   			System.out.println("enter author_fname ");
	   			au.setAuthor_fname(sc.next());
	   			System.out.println("enter author_lname");
	   			au.setAuthor_lname(sc.next());
	   			System.out.println("enter Nationality ");
	   			au.setNationality(sc.next());
	   			System.out.println("enter dateOfBirth");
	   			au.setDateOfBirth(sc.next());
	   			System.out.println( "enter authorcol");
	   			au.setAuthorcol(sc.nextInt());
	   		    service.insertAuthor(au);
	   		    break;
	   		case 12:
	   			Transaction1 t=new Transaction1();   			
	   			System.out.println("enter transaction_id");
	   			t.setTransaction_id(sc.nextInt());
	   			System.out.println("enter duedate ");
	   			t.setDueDate(sc.next());
	   			System.out.println("enter issuedate");
	   			t.setIssueDate(sc.next());
	   			System.out.println("enter returndate ");
	   			t.setReturnDate(sc.next());
	   		    service.insertTransaction1(t);
	   		    break;
	   	   case 13:
	   		    BookHasAuthor ba=new BookHasAuthor(); 
	   		    System.out.println("enter ba id");
   			    ba.setBaid(sc.nextInt());
   		       service.insertBookHasAuthor(ba);
		        break;
	   		case 14:
	   			Fine f=new Fine();   			
	   			System.out.println("enter fine id");
	   			f.setFine_id(sc.nextInt());
	   			System.out.println("enter finedate ");
	   			f.setFineDate(sc.next());
	   			System.out.println("enter fineamount");
	   			f.setFineAmount(sc.nextDouble());
	   			System.out.println("enter paymentdate ");
	   			f.setPaymentDate(sc.next());
	   			System.out.println("enter paymentamount");
	   			f.setPaymentAmount(sc.nextDouble());
	   		    service.insertFine(f);
	   		    break;
	   		case 15:
	   			Member m=new Member();   			
	   			System.out.println("enter member id");
	   			m.setMember_id(sc.nextInt());
	   			System.out.println("enter name ");
	   			m.setName(sc.next());
	   			System.out.println("enter joineddate");
	   			m.setJoinDate(sc.next());
	   			System.out.println("enter status ");
	   			m.setStatus(sc.next());
	   		    service.insertMember(m);
	   		    break;
	   		case 16:
	   			Student s=new Student();   			
	   			System.out.println("enter student id");
	   			s.setStudent_id(sc.nextInt());
	   			System.out.println("enter student year ");
	   			s.setStudent_year(sc.nextInt());
	   			System.out.println("enter student rollno");
	   			s.setStudent_rollno(sc.nextInt());
	   		    service.insertStudent(s);
	   		    break;
	   		case 17:
	   			TeachingStaff ts=new TeachingStaff();   			
	   			System.out.println("enter teachingstaff id");
	   			ts.setTeachingStaff_id(sc.nextInt());
	   			System.out.println("enter designation ");
	   			ts.setDesignation(sc.next());
	   		    service.insertTeachingStaff(ts);
	   		    break;
	   		case 18:
	   			NonTeachingStaff n=new NonTeachingStaff();   			
	   			System.out.println("enter nonteachingstaff id");
	   			n.setNonteaching_id(sc.nextInt());
	   			System.out.println("enter designation ");
	   			n.setDesignation(sc.next());
	   		    service.insertNonTeachingStaff(n);
	   		    break;
	   		case 19:
	   			Book b1=new Book();   			
	   			System.out.println("enter book id");
	   			b1.setBook_id(sc.nextInt());
	   			System.out.println("enter book title ");
	   			b1.setTitle(sc.next());
	   			System.out.println("enter publication year");
	   			b1.setPublicationYear(sc.nextInt());
	   			System.out.println("enter category");
	   			b1.setCategory(sc.next());
	   			System.out.println("enter copies");
	   			b1.setCopies(sc.nextInt());
	   			System.out.println( "enter ISBN");
	   			b1.setiSBN(sc.nextInt());
	   			service.updateBook(b1);
	   			break;
	   		case 20:
	   			Author a1=new Author();   			
	   			System.out.println("enter author id");
	   			a1.setAuthor_id(sc.nextInt());
	   			System.out.println("enter author_fname ");
	   			a1.setAuthor_fname(sc.next());
	   			System.out.println("enter author_lname");
	   			a1.setAuthor_lname(sc.next());
	   			System.out.println("enter Nationality ");
	   			a1.setNationality(sc.next());
	   			System.out.println("enter dateOfBirth");
	   			a1.setDateOfBirth(sc.next());
	   			System.out.println( "enter authorcol");
	   			a1.setAuthorcol(sc.nextInt());
	   		    service.updateAuthor(a1);
	   		    break;
	   		case 21:
	   			Transaction1 t1=new Transaction1();   			
	   			System.out.println("enter transaction id");
	   			t1.setTransaction_id(sc.nextInt());
	   			System.out.println("enter duedate ");
	   			t1.setDueDate(sc.next());
	   			System.out.println("enter issuedate");
	   			t1.setIssueDate(sc.next());
	   			System.out.println("enter returndate ");
	   			t1.setReturnDate(sc.next());
	   		    service.updateTransaction1(t1);
	   		    break;   
	   		case 22:
	   		    BookHasAuthor ba1=new BookHasAuthor();   			
   			    System.out.println("enter ba id");
   			    ba1.setBaid(sc.nextInt());
   		        service.updateBookHasAuthor(ba1);
	   		case 23:
	   			Fine f1=new Fine();   			
	   			System.out.println("enter fine id");
	   			f1.setFine_id(sc.nextInt());
	   			System.out.println("enter finedate ");
	   			f1.setFineDate(sc.next());
	   			System.out.println("enter fineamount");
	   			f1.setFineAmount(sc.nextDouble());
	   			System.out.println("enter paymentdate ");
	   			f1.setPaymentDate(sc.next());
	   			System.out.println("enter paymentamount");
	   			f1.setPaymentAmount(sc.nextDouble());
	   		    service.updateFine(f1);
	   		    break;
	   		case 24:
	   			Member m1=new Member();   			
	   			System.out.println("enter member id");
	   			m1.setMember_id(sc.nextInt());
	   			System.out.println("enter name ");
	   			m1.setName(sc.next());
	   			System.out.println("enter joineddate");
	   			m1.setJoinDate(sc.next());
	   			System.out.println("enter status ");
	   			m1.setStatus(sc.next());
	   		    service.updateMember(m1);
	   		    break;
	   		case 25:
	   			Student s1=new Student();   			
	   			System.out.println("enter student id");
	   			s1.setStudent_id(sc.nextInt());
	   			System.out.println("enter student year ");
	   			s1.setStudent_id(sc.nextInt());
	   			System.out.println("enter student rollno");
	   			s1.setStudent_rollno(sc.nextInt());
	   		    service.updateStudent(s1);
	   		    break;
	   		case 26:
	   			TeachingStaff ts1=new TeachingStaff();   			
	   			System.out.println("enter teachingstaff id");
	   			ts1.setTeachingStaff_id(sc.nextInt());
	   			System.out.println("enter designation ");
	   			ts1.setDesignation(sc.next());
	   		    service.updateTeachingStaff(ts1);
	   		    break;
	   		case 27:
	   			NonTeachingStaff n1=new NonTeachingStaff();   			
	   			System.out.println("enter nonteachingstaff id");
	   			n1.setNonteaching_id(sc.nextInt());
	   			System.out.println("enter designation ");
	   			n1.setDesignation(sc.next());
	   		    service.updateNonTeachingStaff(n1);
	   		    break;	
	   		case 28:
	   			Book b2=new Book();
	   			b2.setBook_id(sc.nextInt());
	   			service.deleteBook(b2);
	   			break;	
	   		case 29:
	   			BookHasAuthor ba2=new BookHasAuthor();
	   			ba2.setBaid(sc.nextInt());
	   			service.deleteBookHasAuthor(ba2);
	   			break;	
	   		case 30:
	   			Author a2=new Author();
	   			a2.setAuthor_id(sc.nextInt());
	   			service.deleteAuthor(a2);
	   			break;	
	   		case 31:
	   			Transaction1 t2=new Transaction1();
	   			t2.setTransaction_id(sc.nextInt());
	   			service.deleteTransaction1(t2);
	   			break;
	   		case 32:
	   			Fine f2=new Fine();
	   			f2.setFine_id(sc.nextInt());
	   			service.deleteFine(f2);
	   			break;	
	   		case 33:
	   			Member m2=new Member();
	   			m2.setMember_id(sc.nextInt());
	   			service.deleteMember(m2);
	   			break;
	   		case 34:
	   			Student s2=new Student();
	   			s2.setStudent_id(sc.nextInt());
	   			service.deleteStudent(s2);
	   			break;
	   		case 35:
	   			TeachingStaff ts2=new TeachingStaff();
	   			ts2.setTeachingStaff_id(sc.nextInt());
	   			service.deleteTeachingStaff(ts2);
	   			break;
	   		case 36:
	   			NonTeachingStaff n2=new NonTeachingStaff();
	   			n2.setNonteaching_id(sc.nextInt());
	   			service.deleteNonTeachingStaff(n2);
	   			break;	
	   		case 37:
//	   			service.displayBook();
	   			break;
	   	    default:System.out.println("invalid option");
	   	    break;
			}
			
	   	    System.out.println("1.get book details");
	    	System.out.println("2.get author details");
	    	System.out.println("3.get transaction details");
	    	System.out.println("4.get fine details");    	
	    	System.out.println("5.get member details");
	    	System.out.println("6.get student detail");
	    	System.out.println("7.get teachingstaff details");
	    	System.out.println("8.get nonteaching staff details ");
	    	System.out.println("9.get bookhasauthor details");
	    	System.out.println("10.insert book details");
	    	System.out.println("11.insert bookhasauthor details");
	    	System.out.println("12.insert author details");
	    	System.out.println("13.insert transaction details");
	    	System.out.println("14.insert fine details");
	    	System.out.println("15.insert member details");
	    	System.out.println("16.insert student details");
	    	System.out.println("17.insert teachingstaff details");
	    	System.out.println("18.insert nonteachingstaff details");
	    	System.out.println("19.update book details");
	    	System.out.println("20.update bookhasauthor details");
	    	System.out.println("21.update author details");
	    	System.out.println("22.update transaction details");
	    	System.out.println("23.update fine details");
	    	System.out.println("24.update member details");
	    	System.out.println("25.update student details");
	    	System.out.println("26.update teachingstaff details");
	    	System.out.println("27update nonteachingstaff details.");
	    	System.out.println("28.delete book details");
	    	System.out.println("29.delete bookhasauthor details");
	    	System.out.println("30.delete author details");
	    	System.out.println("31.delete transaction details");
	    	System.out.println("32.delete fine details");
	    	System.out.println("33.delete member details");
	    	System.out.println("34.delete student details");
	    	System.out.println("35.delete teachingstaff details");
	    	System.out.println("36.delete nonteaching details");
	    	System.out.println("37.display book");
	   				
	    	a=sc.nextInt();
			
		}
    }
    sc.close();
    
	} 

}
package com.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class ServiceImplTest 
{
	ServiceImpl ssimp=new ServiceImpl();
	
	@Test
	public void displayBook()
	{
		int i=ssimp.displayBook();
		assertEquals(1,i);
		
		
	}
	@Test
	public void displayAuthor()
	{
		int i=ssimp.displayAuthor();
		assertEquals(1,i);
		
		
	}
	@Test
	public void displayTransaction1()
	{
		int i=ssimp.displayTransaction1();
		assertEquals(1,i);
		
		
	}
	@Test
	public void displayFine()
	{
		int i=ssimp.displayFine();
		assertEquals(1,i);
		
		
	}
	@Test
	public void displayMember()
	{
		int i=ssimp.displayMember();
		assertEquals(1,i);
		
		
	}@Test
	public void displayStudent()
	{
		int i=ssimp.displayStudent();
		assertEquals(1,i);
		
		
	}
	@Test
	public void displayTeachingStaff()
	{
		int i=ssimp.displayTeachingStaff();
		assertEquals(1,i);
		
		
	}
	@Test
	public void displayNonTeachingStaff()
	{
		int i=ssimp.displayNonTeachingStaff();
		assertEquals(1,i);
		
		
	}
	
	

}


