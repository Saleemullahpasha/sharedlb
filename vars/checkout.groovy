def call() {

  cleanWs()
  git branch: '${GIT_BRANCH}', credentialsId: 'gitrepo', url: "$GITURL"

  sh "git rev-parse --short HEAD > .git/commit-id"
  //IMAGETAG= readFile('.git/commit-id').trim()
  sh 'echo $IMAGETAG'
  echo IMAGETAG
}
