name := "Mongo"

version := "0.1"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.6.4",
  "org.mongodb.scala" %% "mongo-scala-driver" % "2.4.0",
  "com.typesafe.play" %% "play-json" % "2.6.0"
)
