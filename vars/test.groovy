def call() {
   pipeline {
       agent any
       stages {
           stage('test stage') (
                   steps {
                       sh 'echo hello world'
                   }
           )
       }
   }
}