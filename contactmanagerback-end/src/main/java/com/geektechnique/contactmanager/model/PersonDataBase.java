package com.geektechnique.contactmanager.model;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.BasicDBObject;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lte;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.lt;

import org.json.JSONObject;

import org.bson.Document;
import org.bson.conversions.Bson;

public class PersonDataBase {
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;

	public PersonDataBase() {
		super();

		this.mongoClient = MongoClients.create("mongodb://127.0.0.1:27017/");
		this.database = mongoClient.getDatabase("DB01");
		this.collection = database.getCollection("person");
	}

	public void createPersonDocument(UUID id, String personName) {

		if (this.getPersonDocumentByName(personName) == null) {

			Document createdDoc = new Document("id", id.toString()).append("name", personName);

			collection.insertOne(createdDoc);

			MongoCursor<Document> cursor = collection.find().iterator();
			try {
				while (cursor.hasNext()) {
					String documentString = cursor.next().toJson();

					System.out.println(documentString);

					// JSON Parse Example

					JSONObject obj = new JSONObject(documentString);
					String userID = obj.getString("id");
					String name = obj.getString("name");
					// String mongoID = obj.getJSONObject("_id").getString("$oid");

					System.out.println("the user ID is " + userID);
					System.out.println("the user Name is " + name);

				}
			}

			finally {
				cursor.close();
			}
		} else {
			System.out.println("A person with this name already exists!");
		}

	}

	public Optional<Person> getPersonDocumentByName(String Name) {

		// display all document where id
		System.out.println("display all document where status is idString: ");
		Bson bsonFilter0 = Filters.eq("name", Name);
		FindIterable<Document> findIt = collection.find(bsonFilter0);

		for (Document doc : findIt) {

			String documentString = doc.toJson();
			System.out.println(doc.toJson());

			JSONObject obj = new JSONObject(documentString);

			// System.out.println("the obj is: " + obj);
			String userID = obj.getString("id");
			String name = obj.getString("name");
			// String mongoID = obj.getJSONObject("_id").getString("$oid");

			System.out.println("the user ID is " + userID);
			System.out.println("the user Name is " + name);

			UUID userUUID = UUID.fromString(userID);

			Optional<Person> personOpt = Optional.of(new Person(userUUID, name));

			return personOpt;
		}

		Optional<Person> personOpt = null;

		return personOpt;

	}

	public Optional<Person> getPersonDocumentById(UUID id) {

		String idString = id.toString();

		// display all document where id
		System.out.println("display all document where status is idString: ");
		Bson bsonFilter0 = Filters.eq("id", idString);
		FindIterable<Document> findIt = collection.find(bsonFilter0);

		for (Document doc : findIt) {

			String documentString = doc.toJson();
			System.out.println(doc.toJson());

			JSONObject obj = new JSONObject(documentString);

			String userID = obj.getString("id");
			String name = obj.getString("name");
//				String mongoID = obj.getJSONObject("_id").getString("$oid");

			System.out.println("the user ID is " + userID);
			System.out.println("the user Name is " + name);

			UUID userUUID = UUID.fromString(userID);

			Optional<Person> personOpt = Optional.of(new Person(userUUID, name));

			return personOpt;
		}

		Optional<Person> personOpt = null;

		return personOpt;

	}

	public void deleteDocumentByID(UUID id) {

		String stringID = id.toString();

		collection.deleteOne(eq("id", stringID));

		MongoCursor<Document> cursor3 = collection.find().iterator();
		try {
			while (cursor3.hasNext()) {
				System.out.println(cursor3.next().toJson());
			}
		}

		finally {
			cursor3.close();
		}
	}

	public void updateDocumentByID(UUID id, Person updatedPerson) {

		BasicDBObject set = new BasicDBObject("$set", new BasicDBObject("name", updatedPerson.getName()));

		collection.updateOne(eq("id", id.toString()), set);

	}

	public List<Person> getAllPersonDocuments() {

		List<Person> personList = new ArrayList<>();

		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				String documentString = cursor.next().toJson();

				System.out.println(documentString);

				// JSON Parse Example

				JSONObject obj = new JSONObject(documentString);

				System.out.println("the obj is: " + obj);
				String userID = obj.getString("id");
				String name = obj.getString("name");
				// String mongoID = obj.getJSONObject("_id").getString("$oid");

				System.out.println("the user ID is " + userID);
				System.out.println("the user Name is " + name);

				UUID userUUID = UUID.fromString(userID);

				personList.add(new Person(userUUID, name));

			}
		}

		finally {
			cursor.close();
		}

		return personList;
	}

}
