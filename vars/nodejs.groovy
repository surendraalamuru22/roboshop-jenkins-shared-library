def call() {
    node {
        agent {
            node { label 'workstation'}
        }

            if (! env.TAG_NAME) {
                env.TAG_NAME = ""
            }
//            sh 'env'
            common.codeQuality()
            common.codechecks()
            common.artifacts()


    }
}