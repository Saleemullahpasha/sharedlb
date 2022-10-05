#QdnqnLib.groovy
package qdnqn
class QdnqnLib implements Serializable {
  def ctx
  QdnqnLib(def ctx){
    this.ctx = ctx
    this.files = ctx.sh("ls")
  }
  def RenameFile(def file, def newName){
    this.ctx.sh "mv ${file} ${newName}"
  }
  def WhoAmI(def pipeline){
    this.ctx.println("I am pipeline: ${service}")
  }
  @NonCPS
  def LsFiles(def dir){
    this.ctx.sh("ls ${dir}")
  }
}
