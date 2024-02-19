package org.example.Controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Entity.Genero;

public class GeneroController  {
    private final MongoDBOperations mongoDBOperations;
    private final MongoDBConnection connection = MongoDBConnectionManager.getConnection();

    public GeneroController() {
        this.mongoDBOperations = new MongoDBController(connection.getDatabase(), "generos");
    }

    public void insertGenero(Genero genero) {
        Document document = new Document("nombre", genero.getNombre());
        mongoDBOperations.insertDocument(document);
    }

    public void showAllGeneros() {
        mongoDBOperations.showAllDocuments();
    }

    public void findGenero(Document filter) {
        mongoDBOperations.findDocument(filter);
    }

    public void deleteGenero(Document filter) {
        mongoDBOperations.deleteDocument(filter);
    }

    public void deleteAllGeneros() {
        mongoDBOperations.deleteAllDocuments();
    }

    public void updateGenero(Document filter, Document update) {
        mongoDBOperations.updateDocument(filter, update);
    }

    public void replaceGenero(Document filter, Document replacement) {
        mongoDBOperations.replaceDocument(filter, replacement);
    }

    public void showGenero(Document filter) {
        mongoDBOperations.findDocument(filter);
    }



}
