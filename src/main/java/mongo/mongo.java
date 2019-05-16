package mongo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import static com.mongodb.client.model.Projections.excludeId;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;

/**
 *
 * @author white
 */
public class mongo {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public Boolean getAuthentication(String user, String pass) {
        System.out.println("USUARIO "+user);
        System.out.println("PASS "+pass);
        MongoClient mongoClient = new MongoClient(HOST, PORT);

        DB db = mongoClient.getDB("autenticacion");

        DBCollection coll = db.getCollection("users");

        System.out.println("llegue");
        DBObject query = new BasicDBObject("usuario", new BasicDBObject("$eq",
                user));//.append("password", new BasicDBObject("$eq", pass));
          System.out.println(query);
        DBCursor cursor = coll.find(query);
        System.out.println(cursor);
        try {
            if (cursor.hasNext()) {
                return true;
            } else {
                return false;
            }
        } finally {
            cursor.close();

        }

    }

}
