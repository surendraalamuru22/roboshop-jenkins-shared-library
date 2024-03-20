def call() {
    env.SONAR_EXTRA_OPTS = "-Dsonar.java.binaries=./target"
    env.APPTYPE = "java"
    node {
        agent {
            node { label 'workstation2'}
        }

//            sh 'env'
        common.codeCheckout()
        stage('compile code') {
            sh 'mvn compile'
        }
        common.codeQuality()
        common.codechecks()
        common.artifacts()


    }
}