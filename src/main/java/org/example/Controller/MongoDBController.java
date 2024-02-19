package org.example.Controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

public class MongoDBController implements MongoDBOperations{
    private final MongoCollection<Document> collection;

    public MongoDBController(MongoDatabase database, String collectionName) {
        this.collection = database.getCollection(collectionName);
    }

    @Override
    public void insertDocument(Document document) {
        collection.insertOne(document);
    }

    @Override
    public void updateDocument(Document filter, Document update) {
        collection.updateOne(filter, update);
    }

    @Override
    public void replaceDocument(Document filter, Document replacement) {
        collection.replaceOne(filter, replacement);
    }

    @Override
    public void deleteDocument(Document filter) {
        collection.deleteOne(filter);
    }

    @Override
    public void showAllDocuments() {
        for (Document document : collection.find()) {
            System.out.println(document.toJson());
        }
    }

    @Override
    public Document findDocument(Document filter) {
        for (Document document : collection.find(filter)) {
            System.out.println(document.toJson());
        }
        return filter;
    }

    @Override
    public void deleteAllDocuments() {
        collection.deleteMany(new Document());
    }

    @Override
    public List<Document> findDocuments(Document filter) {
        return collection.find(filter).into(List.of());
    }
}
