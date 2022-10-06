def call(String GITURL) {

  node {
    stage ('Code Checkout') {
      cleanWs()
      git branch: 'main', url: "$GITURL"
    }
    stage ('Compile') {
        
      bat "mvn clean"
      bat "mvn install"
      bat "mvn package -DskipTests"
      
        }
    }
  }
