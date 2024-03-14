def call() {
    node {
        agent {
            node { label 'workstation'}
        }

//            sh 'env'
            common.codeQuality()
            common.codechecks()
            common.artifacts()


    }
}