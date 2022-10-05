def call(String GITURL) {

  node {
    stage ('Code Checkout') {
      cleanWs()
      git branch: 'main', url: "$GITURL"
      sh "git rev-parse --short HEAD > .git/commit-id"
    }
  }
}
