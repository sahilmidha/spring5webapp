package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String address;

  @OneToMany private Set<Book> books = new HashSet<>();

  public Publisher(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public Publisher() {}

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setbook(Book book) {
    this.books.add(book);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Publisher publisher = (Publisher) o;

    return id == publisher.id;
  }

  @Override
  public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }

  @Override
  public String toString() {
    return "Publisher{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", address='"
        + address
        + '\''
        + '}';
  }
}
