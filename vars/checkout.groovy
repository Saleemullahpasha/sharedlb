def call(String GITURL) {

  node {
    stage ('Code Checkout') {
      cleanWs()
      git branch: 'main', url: "$GITURL"
    }
    stage ('Compile') {
      bat  "mvn --version"
      bat "mvn clean install -DskipTests"
      
    }
  }
}
