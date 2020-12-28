/** ********* PROJECT INFO *****************/
scalaVersion := "2.12.4"

name := "MarsRover"
organization := "es.juanc.katas.fizzbuzz"
version := "0.0.1"

/** ********* DEPENDENCIES *****************/
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest"                   % "3.0.1" % Test,
  "org.scalamock" %% "scalamock-scalatest-support" % "3.4.2" % Test
)

/** ********* COMMANDS ALIASES ******************/
addCommandAlias("t", "test")
addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")
