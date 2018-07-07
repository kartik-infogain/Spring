package com.auction.login.dao;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class MongoFunctionsImpl implements MongoFunctions {

	@Override
	public boolean validateUser(String username, String password) {
		// Connection Client in Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Accessing the Database
		MongoDatabase database = mongo.getDatabase("auctionDB");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("loginDetails");

		BasicDBObject query = new BasicDBObject();
		query.put("username", username);

		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find(query);

		Iterator<Document> itr = iterDoc.iterator();
		while (itr.hasNext()) {
			Document doc = itr.next();
			System.out.println(doc.get("password"));
			if (doc.get("password").equals(password)) {
				// System.out.println("Welcome : " + username);
				return true;
			}
		}
		mongo.close();
		return false;
	}

	// dn.loginDetails.update({"name":"Kartik Nigam"},
	// {$set:{"phonenumber":"9911909855", "emailID":"nigamkartik962@gmail.com"}},
	// {upsert: true});

	@Override
	public boolean changePassword(String _id, String password) {
		// Connection Client in Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Accessing the Database
		MongoDatabase database = mongo.getDatabase("auctionDB");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("loginDetails");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("password", password));
		try {
			BasicDBObject searchQuery = new BasicDBObject().append("_id", new ObjectId(_id));

			UpdateResult updateResult = collection.updateOne(searchQuery, newDocument);
			mongo.close();
			if (updateResult.wasAcknowledged()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}

	@Override
	public String getObjectID(String username, String emailAddress) {
		// Connection Client in Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Accessing the Database
		MongoDatabase database = mongo.getDatabase("auctionDB");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("loginDetails");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("username", username);
		searchQuery.append("emailID", emailAddress);
		try {
			// Getting the iterable object
			FindIterable<Document> iterDoc = collection.find(searchQuery);

			Iterator<Document> itr = iterDoc.iterator();
			Document doc = itr.next();
			ObjectId _id = doc.getObjectId("_id");
			if (_id != null) {
				System.out.println(_id.toString());
				mongo.close();
				return _id.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			mongo.close();
			return null;
		}
		mongo.close();
		return null;
	}

	@Override
	public boolean doUserExists(String username) {
		// Connection Client in Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Accessing the Database
		MongoDatabase database = mongo.getDatabase("auctionDB");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("loginDetails");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("username", username);
		try {
			FindIterable<Document> iterDoc = collection.find(searchQuery);

			Iterator<Document> itr = iterDoc.iterator();
			Document doc = itr.next();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public boolean addUser(String name, String username, String emailAddress, long phonenumber, String password) {
		// Connection Client in Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Accessing the Database
		MongoDatabase database = mongo.getDatabase("auctionDB");

		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("loginDetails");

		try {
			Document insertQuery = new Document();
			insertQuery.put("name", name);
			insertQuery.append("username", username);
			insertQuery.append("emailID", emailAddress);
			insertQuery.append("phonenumber", phonenumber);
			insertQuery.append("password", password);

			collection.insertOne(insertQuery);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
