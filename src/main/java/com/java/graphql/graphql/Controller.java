package com.java.graphql.graphql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

public class Controller {

    //Declares how to fetch a object under schema type query.
    @QueryMapping
    public Book bookById(String id){
        return  Book.getId(id);
    }


    // Annotation maps a handler method to a field in the GraphQL schema.
    @SchemaMapping
    public Author getById(Book book){
      return  Author.getById(book.authorId());

    }  
    
}
