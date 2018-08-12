<<<<<<< HEAD
package com.auction.common.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.auction.common.model.ImagesPathAndName;
import com.auction.common.model.Item;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CommonDatabaseFunctionsMongoImpl implements CommonDatabaseFunctions {

	private MongoClient mongo;

	@Autowired
	Properties commonProperties;

	@Override
	public boolean insertItem(Item item) {
		try {
			MongoCollection<Document> collection = getCollection();

			// Creating query to insert the item in itemDetails
			Document query = new Document();
			Document queryImage = new Document();
			query.put("username", item.getUsername());
			query.append("productName", item.getProductName());
			query.append("productDescription", item.getProductDescription());
			query.append("price", item.getPrice());
			query.append("dateAdded", item.getDateAdded());
			// Creating query for images
			for (ImagesPathAndName image : item.getImages()) {
				queryImage.put("filename", image.getFilename());
				queryImage.append("filepath", image.getFilepath());
			}
			query.append("images", queryImage);
			query.append("tags", item.getTags());
			query.append("viewCount", item.getViewCount());

			// Inserting in itemDetails
			collection.insertOne(query);
			mongo.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	protected MongoCollection<Document> getCollection() {
		try {
			int portName = Integer.parseInt(commonProperties.getProperty("mongoDBPortName"));
			String hostName = commonProperties.getProperty("mongoDBHostName");
			String dbName = commonProperties.getProperty("dbName");
			String itemCollectionName = commonProperties.getProperty("itemCollectionName");
			System.out.println(itemCollectionName);

			// Connection Client in Mongo DB
			mongo = new MongoClient(hostName, portName);

			// Accessing the Database
			MongoDatabase database = mongo.getDatabase(dbName);

			// Retrieving a collection
			MongoCollection<Document> collection = database.getCollection(itemCollectionName);
			return collection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Item> getItemsByUsername(String username) {
		try {
			MongoCollection<Document> collection = getCollection();
			ArrayList<Item> items = new ArrayList<>();
			BasicDBObject query = new BasicDBObject();
			query.put("username", username);
			try {
				FindIterable<Document> iterDoc = collection.find(query);
				Iterator<Document> itr = iterDoc.iterator();
				while (itr.hasNext()) {
					Document doc = itr.next();
					// System.out.println(doc);
					@SuppressWarnings("unchecked")
					ArrayList<String> tags = (ArrayList<String>) doc.get("tags");
					Document docImages = (Document) doc.get("images");
					ArrayList<ImagesPathAndName> images = new ArrayList<>();

					images.add(new ImagesPathAndName((String) docImages.get("filename"),
							(String) docImages.get("filepath")));

					items.add(new Item(doc.getObjectId("_id").toString(), doc.getString("productName"),
							doc.getString("productDescription"), images, tags, doc.getString("dateAdded"),
							doc.getDouble("price"), doc.getInteger("viewCount")));
				}
				return items;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
=======
package com.auction.common.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.auction.common.model.ImagesPathAndName;
import com.auction.common.model.Item;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CommonDatabaseFunctionsMongoImpl implements CommonDatabaseFunctions {

	private MongoClient mongo;

	@Autowired
	Properties commonProperties;

	@Override
	public boolean insertItem(Item item) {
		try {
			MongoCollection<Document> collection = getCollection();

			// Creating query to insert the item in itemDetails
			Document query = new Document();
			Document queryImage = new Document();
			query.put("username", item.getUsername());
			query.append("productName", item.getProductName());
			query.append("productDescription", item.getProductDescription());
			query.append("price", item.getPrice());
			query.append("dateAdded", item.getDateAdded());
			// Creating query for images
			for (ImagesPathAndName image : item.getImages()) {
				queryImage.put("filename", image.getFilename());
				queryImage.append("filepath", image.getFilepath());
			}
			query.append("images", queryImage);
			query.append("tags", item.getTags());
			query.append("viewCount", item.getViewCount());

			// Inserting in itemDetails
			collection.insertOne(query);
			mongo.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	protected MongoCollection<Document> getCollection() {
		try {
			int portName = Integer.parseInt(commonProperties.getProperty("mongoDBPortName"));
			String hostName = commonProperties.getProperty("mongoDBHostName");
			String dbName = commonProperties.getProperty("dbName");
			String itemCollectionName = commonProperties.getProperty("itemCollectionName");
			System.out.println(itemCollectionName);

			// Connection Client in Mongo DB
			mongo = new MongoClient(hostName, portName);

			// Accessing the Database
			MongoDatabase database = mongo.getDatabase(dbName);

			// Retrieving a collection
			MongoCollection<Document> collection = database.getCollection(itemCollectionName);
			return collection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Item> getItemsByUsername(String username) {
		try {
			MongoCollection<Document> collection = getCollection();
			ArrayList<Item> items = new ArrayList<>();
			BasicDBObject query = new BasicDBObject();
			query.put("username", username);
			try {
				FindIterable<Document> iterDoc = collection.find(query);
				Iterator<Document> itr = iterDoc.iterator();
				while (itr.hasNext()) {
					Document doc = itr.next();
					// System.out.println(doc);
					@SuppressWarnings("unchecked")
					ArrayList<String> tags = (ArrayList<String>) doc.get("tags");
					Document docImages = (Document) doc.get("images");
					ArrayList<ImagesPathAndName> images = new ArrayList<>();

					images.add(new ImagesPathAndName((String) docImages.get("filename"),
							(String) docImages.get("filepath")));

					items.add(new Item(doc.getObjectId("_id").toString(), doc.getString("productName"),
							doc.getString("productDescription"), images, tags, doc.getString("dateAdded"),
							doc.getDouble("price"), doc.getInteger("viewCount")));
				}
				return items;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
>>>>>>> ee61d503e6b3e08da756937c30fc01d282638335
