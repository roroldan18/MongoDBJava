package org.example.Controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Entity.Artista;
import org.example.Entity.Genero;

import java.util.List;

public class ArtistaController {
    private final MongoDBOperations mongoDBOperations;

    private final MongoDBConnection connection = MongoDBConnectionManager.getConnection();

    public ArtistaController() {
        this.mongoDBOperations = new MongoDBController(connection.getDatabase(), "artistas");
    }

    public void insertArtista(Artista artista) {
        Document document = new Document("nombre", artista.getNombre())
                .append("genero", artista.getGenero().getNombre());
        mongoDBOperations.insertDocument(document);
    }

    public void showAllArtistas() {
        mongoDBOperations.showAllDocuments();
    }

    public void findArtista(Document filter) {
        mongoDBOperations.findDocument(filter);
    }

    public Artista findArtista(String nombre) {
        Document filter = new Document("nombre", nombre);
        Document result = mongoDBOperations.findDocument(filter);
        Genero genero = new Genero(result.getString("genero"));

        if (result != null) {
            return new Artista(result.getString("nombre"), genero);
        }
        return null;
    }


    public List<Artista> findArtistasByGenero(String genero) {
        Document filter = new Document("genero", genero);
        List<Document> results = mongoDBOperations.findDocuments(filter);

        return results.stream().map(document -> {
            Genero generoArtista = new Genero(document.getString("genero"));
            return new Artista(document.getString("nombre"), generoArtista);
        }).toList();
    }

    public void deleteArtista(Artista artista) {
        Document filter = new Document("nombre", artista.getNombre());
        mongoDBOperations.deleteDocument(filter);
    }

    public void deleteAllArtistas() {
        mongoDBOperations.deleteAllDocuments();
    }

    public void updateArtista(Document filter, Document update) {
        mongoDBOperations.updateDocument(filter, update);
    }

}
