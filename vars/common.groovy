def codeCheckout() {
    stage('Code Checkout') {
        sh 'find . | sed 1d | xargs rm -rf'
        git branch: 'main', url: "https://github.com/surendraalamuru22/${COMPONENT}.git"
    }
}


def codeQuality() {
    stage('code Quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
            sh '''
               #sudo sonar-scanner -Dsonar.host.url=http://172.31.14.212:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT}  -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
               echo ok
            '''
        }
    }
}

def codechecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*" ) {

        stage('lint checks') {
            echo 'lint checks'
        }

        stage('unit tests') {
            echo 'unit tests'
        }

    }
}

def artifacts() {
    if ( env.TAG_NAME ==~ ".*" ) {

        stage('Prepare Artifacts') {
            if (env.APPTYPE == "nodejs") {
                sh '''
                     npm install 
                     zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js 
                '''
            }
            if (env.APPTYPE == "java") {
                sh '''
                     mvn clean package 
                     mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar 
                     zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}.jar
                '''
            }
            if (env.APPTYPE == "python") {
                sh '''
                      zip -r ${COMPONENT}-${TAG_NAME}.zip *.py ${COMPONENT}.ini requirements.txt
                '''
            }
            if (env.APPTYPE == "nginx") {
                sh '''
                     cd static
                     zip -r ../${COMPONENT}-${TAG_NAME}.zip *
                '''
            }
        }
        stage('Publish Artifacts') {
             withCredentials([usernamePassword(credentialsId: 'NEXUS', passwordVariable: 'nexusPass', usernameVariable: 'nexusUser')]) {
               sh '''
                  curl -v -u ${nexusUser}:${nexusPass} --upload-file ${COMPONENT}-${TAG_NAME}.zip http://nexus.roboshop.internal:8081/repository/${COMPONENT}/${COMPONENT}-${TAG_NAME}.zip
               '''
             }
        }
    }
}