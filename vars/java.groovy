def call() {
    env.SONAR_EXTRA_OPTS = "-Dsonar.java.binaries=./target"
    node {
        agent {
            node { label 'workstation2'}
        }

//            sh 'env'
        stage('compile code') {
            sh 'mvn compile'
        }
        common.codeCheckout()
        common.codeQuality()
        common.codechecks()
        common.artifacts()


    }
}