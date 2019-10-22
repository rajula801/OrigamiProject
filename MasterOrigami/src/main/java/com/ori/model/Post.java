package com.ori.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "posts")
public class Post extends AuditModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4594282058151663010L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String title;

    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Lob
    private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    // Getters and Setters (Omitted for brevity)
//	For reference only
//	@Entity
//	public class BookCategory {
//	    @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private int id;
//
//	    private String name;
//
//	    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
//	    private Set<Book> books;
//
//	    public BookCategory(String name, Book... books) {
//	        this.name = name;
//	        this.books = Stream.of(books).collect(Collectors.toSet());
//	        this.books.forEach(x -> x.setBookCategory(this));
//	    }
	
}