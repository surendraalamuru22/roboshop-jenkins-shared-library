def call() {
    env.APPTYPE = "nodejs"
    node {
        agent {
            node { label 'workstation2'}
        }

//            sh 'env'
            common.codeCheckout()
            common.codeQuality()
            common.codechecks()
            common.artifacts()


    }
}