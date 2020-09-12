package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootStrapData(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Publisher publisher = new Publisher("Springer Verlag", "Heidelberg, Deutschland");
    publisherRepository.save(publisher);

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "2432342");
    eric.setBook(ddd);
    ddd.setAuthor(eric);
    ddd.setPublisher(publisher);
    authorRepository.save(eric);
    bookRepository.save(ddd);
    publisher.setbook(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "48029820");
    rod.setBook(noEJB);
    noEJB.setAuthor(rod);
    noEJB.setPublisher(publisher);
    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publisher.setbook(noEJB);

    System.out.println("Started Bootstrap");
    System.out.println("Number of books: " + bookRepository.count());
    System.out.println("Number of publisher: " + publisherRepository.count());
    System.out.println("Publishers info: " + publisher.toString());
  }
}
