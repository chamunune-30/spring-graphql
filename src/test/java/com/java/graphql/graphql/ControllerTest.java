package com.java.graphql.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;

import org.springframework.graphql.test.tester.GraphQlTester;

import com.java.graphql.graphql.Controller;

@GraphQlTest(Controller.class)
public class ControllerTest {


    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstBook(){
        this.graphQlTester.document(bookDetails)
        .variable("id", "book-1")
        .execute()
        .bookById()
        .matchesJson("""
                    {
                        "id": "book-1",
                        "name": "Effective Java",
                        "pageCount": 416,
                        "author": {
                          "firstName": "Joshua",
                          "lastName": "Bloch"
                        }
                    }
                """);

    }
    
}
