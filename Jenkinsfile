#!/usr/bin/env groovy

properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '3', artifactNumToKeepStr: '8', daysToKeepStr: '3', numToKeepStr: '8')), disableConcurrentBuilds() ])

node('linux') {
  try{

      def branch = env.BRANCH_NAME
      env.JAVA_HOME = "${tool 'jdk8'}"
      env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"

      checkoutStage('git@github.com:says33/micronaut-teapots.git', branch)
      buildArtifact()
      unitTest()

  } catch(caughtError) {
      throw caughtError
  } finally {
      cleanWs()
  }
}


def checkoutStage(repo, branch) {
    stage('Checkout'){
        checkout([
            $class: 'GitSCM',
            branches:scm.branches,
            doGenerateSubmoduleConfigurations: false,
            extensions:  scm.extensions + [
                [$class: 'CloneOption', noTags: false, reference: '', shallow: true, timeout: 120]
            ],
            submoduleCfg: [],
            userRemoteConfigs: [[
                credentialsId: 'github',
                url: repo
            ]]
        ])
    }
}

def buildArtifact() {
  stage('Build') {
    sh '''./gradlew compileJava'''
  }
}

def unitTest() {
  stage('Unit Test') {
    sh '''./gradlew check'''
  }
}
