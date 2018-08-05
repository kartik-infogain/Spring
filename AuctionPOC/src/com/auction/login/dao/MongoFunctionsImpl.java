package com.auction.login.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class MongoFunctionsImpl implements MongoFunctions {
	private MongoClient mongo;

	@Override
	public boolean validateUser(String username, String password) {
		MongoCollection<Document> collection = getCollection();

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

	@Override
	public boolean changePassword(String _id, String password) {
		MongoCollection<Document> collection = getCollection();

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
		MongoCollection<Document> collection = getCollection();

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
		MongoCollection<Document> collection = getCollection();

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

		MongoCollection<Document> collection = getCollection();

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

	protected MongoCollection<Document> getCollection() {
		Properties properties = new Properties();
		try {
			System.out.println("Hello" + Paths.get("").toAbsolutePath().toString());
			properties.load(
					new FileReader(new File(/*Paths.get("").toAbsolutePath().toString() + "\\AuctionPOC\\conf\\*/"C:\\Users\\Kartik\\Desktop\\login.properties")));
			int portName = Integer.parseInt(properties.getProperty("mongoDBPortName"));
			String hostName = properties.getProperty("mongoDBHostName");
			String dbName = properties.getProperty("dbName");
			String loginCollectionName = properties.getProperty("loginCollectionName");
			System.out.println(portName);
			// Connection Client in Mongo DB
			mongo = new MongoClient(hostName, portName);

			// Accessing the Database
			MongoDatabase database = mongo.getDatabase(dbName);

			// Retrieving a collection
			MongoCollection<Document> collection = database.getCollection(loginCollectionName);
			return collection;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
