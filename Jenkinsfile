pipeline  {
     agent any 
     
     
     stages{
         stage('Testing maven'){
             steps{
                 sh  """mvn -version"""
             }
         }
        
         stage('Hello'){
             steps{
                 echo 'Hello World'
                 
             }
         }
         
          stage('Chekout GIT'){
             steps{
                 echo 'Pulling...';
                 git branch: 'master' ,
                 url : 'https://github.com/Auckfmine/Project-Management-System.git'
             }
         }
     }
     
 }
