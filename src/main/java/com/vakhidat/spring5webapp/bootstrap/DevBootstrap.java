package com.vakhidat.spring5webapp.bootstrap;

import com.vakhidat.spring5webapp.model.Author;
import com.vakhidat.spring5webapp.model.Book;
import com.vakhidat.spring5webapp.model.Publisher;
import com.vakhidat.spring5webapp.repository.AuthorRepository;
import com.vakhidat.spring5webapp.repository.BookRepository;
import com.vakhidat.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher manningPublisher = new Publisher("Manning Publications",
                "Shelter Island, New York", "1-203-626-1510", "support@manning.com ");
        publisherRepository.save(manningPublisher);

        Author craigWallsAuthor = new Author("Craig", "Walls");
        Book springBook = new Book("Spring in Action, Fifth Edition", "1234", manningPublisher);
        craigWallsAuthor.addBook(springBook);
        authorRepository.save(craigWallsAuthor);

        springBook.addAuthor(craigWallsAuthor);
        bookRepository.save(springBook);

        Publisher oreillyPublisher = new Publisher("O'Reilly Media",
                "Sebastopol, California", "(707) 827-7000", " information@oreilly.co.uk");
        publisherRepository.save(oreillyPublisher);

        Author allenDowneyAuthor = new Author("Allen", "Downey");
        Author chrisMayfieldAuthor = new Author("Chris", "Mayfield");
        Book thinkJavaBook = new Book("Think Java, 2nd Edition", "23444", oreillyPublisher);
        allenDowneyAuthor.addBook(thinkJavaBook);
        chrisMayfieldAuthor.addBook(thinkJavaBook);

        authorRepository.save(allenDowneyAuthor);
        authorRepository.save(chrisMayfieldAuthor);

        thinkJavaBook.addAuthor(allenDowneyAuthor);
        thinkJavaBook.addAuthor(chrisMayfieldAuthor);
        bookRepository.save(thinkJavaBook);
    }
}
