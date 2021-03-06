version := "0.0.1-SNAPSHOT"

organization := "LearnAtHome"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.4.3",
							 "org.apache.spark" %% "spark-sql" % "2.4.3",
							 "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % "test",
							 "org.scalacheck" %% "scalacheck" % "1.14.0" % "test")

scalacOptions := Seq(
    "-deprecation",
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions"
)

triggeredMessage := Watched.clearWhenTriggered