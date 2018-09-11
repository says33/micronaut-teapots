@Library('groovy-blocks@sandbox/demo')
import io.rcl.labs.jenkins.libraries.GradlePipeline
import resources.email.html.*

node('linux') {

  env.MAVEN_HOME = "${tool 'Maven 3.3.9'}"
  env.PATH = "${env.MAVEN_HOME}/bin:${env.PATH}"

  properties([
  buildDiscarder(
      logRotator(
          artifactDaysToKeepStr: '3',
          artifactNumToKeepStr: '8',
          daysToKeepStr: '3',
          numToKeepStr: '8'
      )
  ),
  disableConcurrentBuilds()
  ])

  def buildAnd = GradlePipeline.Builder(this)
    .context('.')
    .gradleBuild('compileJava')
    .gradleTests('check')
    .build()

  buildAnd.execute()

}
