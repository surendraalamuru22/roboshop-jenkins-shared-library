def call() {
    node {
        agent {
            node { label 'workstation'}
        }

//            sh 'env'
            common.codeCheckout()
            common.codeQuality()
            common.codechecks()
            common.artifacts()


    }
}