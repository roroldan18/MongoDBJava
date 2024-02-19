package org.example.Controller;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Entity.EscuchasMensuales;

public class EscuchasMensualesController {
    private final MongoDBOperations mongoDBOperations;
    private final MongoDBConnection connection = MongoDBConnectionManager.getConnection();

    public EscuchasMensualesController() {
        this.mongoDBOperations = new MongoDBController(connection.getDatabase(), "escuchas_mensuales");
    }

    public void insertEscuchasMensuales(EscuchasMensuales escuchasMensuales) {
        Document document = new Document("artista", new Document("nombre", escuchasMensuales.getArtista().getNombre()))
                .append("mes", escuchasMensuales.getMes())
                .append("escuchas", escuchasMensuales.getEscuchas());
        mongoDBOperations.insertDocument(document);
    }

    public void showAllEscuchasMensuales() {
        mongoDBOperations.showAllDocuments();
    }

    public void findEscuchasMensuales(Document filter) {
        mongoDBOperations.findDocument(filter);
    }

    public void deleteEscuchasMensuales(Document filter) {
        mongoDBOperations.deleteDocument(filter);
    }

    public void deleteAllEscuchasMensuales() {
        mongoDBOperations.deleteAllDocuments();
    }

    public void updateEscuchasMensuales(Document filter, Document update) {
        mongoDBOperations.updateDocument(filter, update);
    }

    public void replaceEscuchasMensuales(Document filter, Document replacement) {
        mongoDBOperations.replaceDocument(filter, replacement);
    }

    public void showEscuchasMensuales(Document filter) {
        mongoDBOperations.findDocument(filter);
    }
}
