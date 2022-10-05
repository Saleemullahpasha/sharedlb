def call(String GITURL) {

  node {
    stage {
  cleanWs()
  git branch: 'main', credentialsId: 'gitrepo', url: "$GITURL"
  sh "git rev-parse --short HEAD > .git/commit-id"
    }
  }
}
