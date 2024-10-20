package es.upm.grise.profundizacion.control_1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import es.upm.grise.profundizacion.control_1.Library;
import es.upm.grise.profundizacion.control_1.DuplicatedBookException;
import es.upm.grise.profundizacion.control_1.EmptyLibraryException;
import es.upm.grise.profundizacion.control_1.NonExistingBookException;


import java.lang.IndexOutOfBoundsException;

// Author: Alejandro Carrasco Aragon

public class LibraryTest {

	@Test
	public void addBook() {
		try {
			Book b1 = new Book("First book");
			Library lib = new Library();
			lib.addBook(b1);
			assertTrue(true);
		}
		catch (DuplicatedBookException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void addBookDuplicated() {
		try {
			Book b1 = new Book("First book");
			Library lib = new Library();
			lib.addBook(b1);
			assertThrows(DuplicatedBookException.class, () -> {lib.addBook(b1);});
		}
		catch (DuplicatedBookException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void removeBook() {
		try {
			Book b1 = new Book("First book");
			Library lib = new Library();
			lib.addBook(b1);
			lib.removeBook(b1);
			assertTrue(true);
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void removeBookEmpty() {
		try {
			Book b1 = new Book("First book");
			Library lib = new Library();
			assertThrows(IndexOutOfBoundsException.class, () -> {lib.removeBook(b1);});
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void removeBookNotExisting() {
		try {
			Book b1 = new Book("First book");
			Book b2 = new Book("Second book");
			Library lib = new Library();
			lib.addBook(b1);
			assertThrows(IndexOutOfBoundsException.class, () -> {lib.removeBook(b2);});
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getBook() {
		try {
			Book b1 = new Book("First book");
			Library lib = new Library();
			lib.addBook(b1);
			lib.getBook(b1.getTitle());
			assertTrue(true);
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getBookEmpty() {
		try {
			Book b1 = new Book("First book");
			Library lib = new Library();
			assertThrows(EmptyLibraryException.class, () -> {lib.getBook(b1.getTitle());});
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void getBookNotExisting() {
		try {
			Book b1 = new Book("First book");
			Book b2 = new Book("Second book");
			Library lib = new Library();
			lib.addBook(b1);
			assertThrows(NonExistingBookException.class, () -> {lib.getBook(b2.getTitle());});
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}


}
