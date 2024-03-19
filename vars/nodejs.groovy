def call() {
    node {
        agent {
            node { label 'workstation-pipeline'}
        }

//            sh 'env'
            common.codeCheckout()
            common.codeQuality()
            common.codechecks()
            common.artifacts()


    }
}