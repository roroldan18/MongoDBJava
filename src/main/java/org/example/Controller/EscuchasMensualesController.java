package org.example.Controller;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Entity.EscuchasMensuales;

public class EscuchasMensualesController {
    private final MongoDBOperations mongoDBOperations;
    private final MongoDBConnection connection = MongoDBConnectionManager.getConnection();

    public EscuchasMensualesController() {
        this.mongoDBOperations = new MongoDBController(connection.getDatabase(), "escuchasMensuales");
    }


    public void insertEscuchasMensuales(EscuchasMensuales escuchasMensuales) {
        // Crear un documento para insertar con la estructura deseada
        Document document = new Document("artista", new Document("nombre", escuchasMensuales.getArtista().getNombre()))
                .append("mes", getMesAsString(escuchasMensuales.getMes())) // Convertir el mes a cadena
                .append("escuchas", escuchasMensuales.getEscuchas());

        // Insertar el documento en la base de datos
        mongoDBOperations.insertDocument(document);
    }

    public void showAllEscuchasMensuales() {
        mongoDBOperations.showAllDocuments();
    }

    // Método para obtener el nombre del mes como cadena
    private String getMesAsString(int mes) {
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        if (mes >= 1 && mes <= 12) {
            return meses[mes - 1]; // Restar 1 para ajustar el índice del arreglo
        } else {
            throw new IllegalArgumentException("Mes inválido: " + mes);
        }
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
