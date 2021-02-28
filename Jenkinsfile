node {
    def mvnHome

    stage('Preparation') { // for display purposes
        mvnHome = tool 'M3'
    }


     stage ('Checkout') {

                    checkout([$class: 'GitSCM',
                             branches: [[name: '*/master']],
                             doGenerateSubmoduleConfigurations: false,
                             extensions: [[$class: 'CleanCheckout']],
                             submoduleCfg: [],
                             userRemoteConfigs: [[credentialsId: 'fac54609-7ecd-43bc-8b16-134cdbcb0f7f', url: 'https://github.com/axocayev/jenkins-demo.git']]])


            }
    stage('Clean and Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.skip=true  clean package install'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
    }

       stage('Deploy and run') {
            // Run the maven build
            withEnv(["MVN_HOME=$mvnHome"]) {

                if (isUnix()) {
                   sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar   target/*.jar >> server-process-prod.log 2>&1 &'

                } else {
                   // bat(/"%MVN_HOME%\bin\mvn"  exec:java/)
                   bat('start cmd.exe @cmd /k java -jar target/*.jar &')
                }
            }
        }

}
