package org.example.Controller;

import org.bson.Document;

import java.util.List;

public interface MongoDBOperations {

    void insertDocument(Document document);
    void updateDocument(Document filter, Document update);
    void replaceDocument(Document filter, Document replacement);
    void deleteDocument(Document filter);
    void showAllDocuments();
    Document findDocument(Document filter);
    void deleteAllDocuments();

    List<Document> findDocuments(Document filter);
}
