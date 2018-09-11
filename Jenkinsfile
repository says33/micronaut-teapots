@Library('groovy-blocks@sandbox/demo')
import io.rcl.labs.jenkins.libraries.GradlePipeline
import resources.email.html.*

node('linux') {

  env.JAVA_HOME = "${tool 'jdk8'}"
  env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"

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
