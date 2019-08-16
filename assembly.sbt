assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}

test in assembly := {}

assemblyJarName in assembly := "test-assembly.jar"