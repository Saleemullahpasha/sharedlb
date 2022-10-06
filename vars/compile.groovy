def call() {

  node {
    
    stage ('Compile') {
      bat "mvn clean"
      bat "mvn install"
      bat "mvn package -DskipTests"
        }

    }
  }
