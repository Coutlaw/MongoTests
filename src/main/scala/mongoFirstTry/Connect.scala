package mongoFirstTry

import scala.io.Source
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import mongoFirstTry.Helpers._

object Connect extends App {
  override def main(args: Array[String]): Unit = {
    // To directly connect to the default server localhost on port 27017
    val mongoClient: MongoClient = MongoClient()

    // Access the database
    val database: MongoDatabase = mongoClient.getDatabase("test")

    // Retrieve the collection
    val collection: MongoCollection[Document] = database.getCollection("testCollection")

    // Just to get the json file
    val source: String = Source.fromResource("testAdd.json").getLines.mkString
    //  val json: JsValue = Json.parse(source)

    // Take fill and transform to document
    val doc: Document = Document(source)

    // Post
    collection.insertOne(doc).printResults()

    // check
    collection.find(equal("firstName", "MongoDb")).printHeadResult()
  }
}
