pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        sh './gradlew clean test'
      }
    }

    stage('Build Fat Jar') {
      steps {
        sh './gradlew shadowJar -x test'
      }
    }

    stage('Build Docker Image') {
      steps {
        sh 'docker build -t car-rental:ci .'
      }
    }
  }
}
