pipeline  {
     agent any
      tools{
          maven 'M2_HOME'
          jdk 'JAVA_HOME'
     }
     environment {
             SONAR_TOKEN = credentials('sonar-token')
             registry = "auckfmine/devops" 
             registryCredential = 'dockerhub_id' 
             dockerImage = ''
         }
     stages{
         
         stage('print sonar token'){
             steps{
                 echo '$SONAR_TOKEN';
             }
             
         }
         
          stage('Chekout GIT'){
            steps{
                 echo 'Pulling...';
                 git branch: 'master' ,
                 url : 'https://github.com/Auckfmine/Project-Management-System.git'
             }
         }
          stage('cleaning java Project'){
             steps{
                 sh 'mvn clean'

             }
         }
         stage('compiling  java Project'){
             steps{
                 sh 'mvn compile'

             }
         }
          stage("build & SonarQube analysis") {
            steps {
                sh 'mvn sonar:sonar -Dsonar.host.url=http://172.10.0.140:9000 -Dsonar.login=$SONAR_TOKEN'
            }
          }
          stage('build artifact'){
              steps{
                  sh 'mvn package'
              }
          }
          
          stage('deploy jar to nexus'){
              steps{
                  sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen \
                        -DartifactId=tpAchatProject \
                        -Dversion=1.0 \
                        -Dpackaging=jar \
                        -Dfile=./target/tpAchatProject-1.0.jar \
                        -DrepositoryId=esprit-devops \
                        -Durl=http://172.10.0.140:8081/repository/esprit-devops/'
              }
          }
          
          stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }

        stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                   }
                } 
            }
        }

        stage('Cleaning up') { 
            steps { 
               sh "docker rmi $registry:$BUILD_NUMBER" 
            }
        } 
     }
 }
