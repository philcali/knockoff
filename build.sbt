name := "knockoff"

organization := "com.tristanhunt"

version := "0.8.2"

scalaVersion := "2.11.0"

scalacOptions <++= scalaVersion map {
  case sv if sv startsWith "2.1" => Seq("-language:implicitConversions")
  case _ => Nil
}

crossScalaVersions := Seq(
  "2.11.0", "2.10.3", "2.10.2", "2.10.1", "2.10.0"
)

libraryDependencies <++= scalaVersion {
  case sv if sv startsWith "2.11" => Seq(
  "org.scalatest" %% "scalatest" % "2.1.3" % "test",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.1")
  case sv if sv startsWith "2.10" => Seq("org.scalatest" %% "scalatest" % "1.9" % "test")
  case _ => Seq("org.scalatest" %% "scalatest" % "1.8" % "test")
}

// Publishing setup to Sonatype's OSS hosting.
//
// We generally do not publish anything but releases for this project.

publishMavenStyle := true

// Do not publish test artifacts
publishArtifact in Test := false

pomExtra := (
  <url>http://tristanjuricek.com/knockoff</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>https://github.com/tristanjuricek/knockoff/blob/master/license.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git://github.com/tristanjuricek/knockoff.git</url>
    <connection>scm:git:git@github.com:tristanjuricek/knockoff.git</connection>
  </scm>
  <developers>
    <developer>
      <id>tristanjuricek</id>
      <name>Tristan Juricek</name>
      <url>http://tristanjuricek.com</url>
    </developer>
  </developers>)

publishTo := Some("knockoff Sonatype releases" at
                  "https://oss.sonatype.org/service/local/staging/deploy/maven2")

credentials += Credentials(Path.userHome / ".sbt" / "sonatype.sbt")
