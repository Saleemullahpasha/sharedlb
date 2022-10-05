def call(String GITURL) {

  node {
    stage ('Code Checkout') {
      cleanWs()
      git branch: 'main', url: "$GITURL"
    }
    stage ('Compile') {
      def javatool = tool name: 'java-11', type: 'jdk'
       withEnv( ["PATH+JAVATOOL=${javatool}/bin"] ) {
        def maventool = tool name: 'maven', type: 'maven'
        withEnv( ["PATH+MAVENTOOL=${maventool}/bin"] ) {
        bat 'mvn clean install -DskipTests'
        }
    }
  }
}
