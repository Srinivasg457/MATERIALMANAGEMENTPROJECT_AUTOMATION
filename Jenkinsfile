// pipeline {
//     agent any
//
//     stages {
//         stage('Clone Repo') {
//             steps {
//                 git branch: 'main', url: 'https://github.com/Srinivasg457/WORK-ROOM_LIVE_WEB_AUTOMATION.git'
//             }
//         }
//
//         stage('Run in Docker') {
//             steps {
//                 script {
//                     // Pull latest image
//                     sh 'docker pull selenium/standalone-chrome:latest'
//
//                     // Check if port 4444 is used
//                     sh '''
//                         echo "Checking for existing container using port 4444..."
//                         PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
//                         if [ ! -z "$PORT_IN_USE" ]; then
//                             echo "Stopping and removing container $PORT_IN_USE using port 4444..."
//                             docker stop $PORT_IN_USE || true
//                             docker rm $PORT_IN_USE || true
//                             sleep 2
//                         fi
//                     '''
//
//                     // Clean up old selenium-chrome container if any
//                     sh '''
//                         if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
//                             echo "Cleaning up old selenium-chrome container..."
//                             docker stop selenium-chrome || true
//                             docker rm selenium-chrome || true
//                         fi
//                     '''
//
//                     // Start Selenium
//                     sh '''
//                         echo "Starting selenium-chrome container..."
//                         docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
//                     '''
//
//                     // Wait for Selenium
//                     sh '''
//                         echo "Waiting for Selenium to become ready..."
//                         for i in {1..10}; do
//                             if curl -s http://localhost:4444/status | grep -q "ready"; then
//                                 echo "Selenium is ready."
//                                 break
//                             else
//                                 echo "Waiting..."
//                                 sleep 5
//                             fi
//                         done
//                     '''
//
//                     // Run Maven test
//                     sh '''
//                         echo "Running tests inside Maven container..."
//                         docker run --rm \
//                             -v $PWD:/tests \
//                             -w /tests \
//                             --network=host \
//                             maven:3.9.6-eclipse-temurin-17 mvn clean test
//                     '''
//
//                     // Stop Selenium container
//                     sh 'docker stop selenium-chrome || true'
//                 }
//             }
//         }
//     }
//
//     post {
//         always {
//             script {
//                 sh '''
//                     echo "Final cleanup..."
//                     docker rm -f selenium-chrome || true
//                 '''
//             }
//             archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//         }
//     }
// }






/////   here we are going to send email
// this is the correct script in the docker
//Original pipeline script use this only
// pipeline {
//     agent any
//
//     stages {
//         stage('Clone Repo') {
//             steps {
//                 git branch: 'srinivas', url: 'https://github.com/Srinivasg457/MATERIALMANAGEMENTPROJECT_AUTOMATION.git'
//             }
//         }
//
//         stage('Run in Docker') {
//             steps {
//                 script {
//                     sh 'docker pull selenium/standalone-chrome:latest'
//
//                     sh '''
//                         echo "Checking for existing container using port 4444..."
//                         PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
//                         if [ ! -z "$PORT_IN_USE" ]; then
//                             echo "Stopping and removing container $PORT_IN_USE..."
//                             docker stop $PORT_IN_USE || true
//                             docker rm $PORT_IN_USE || true
//                             sleep 2
//                         fi
//                     '''
//
//                     sh '''
//                         if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
//                             echo "Cleaning up old selenium-chrome container..."
//                             docker stop selenium-chrome || true
//                             docker rm selenium-chrome || true
//                         fi
//                     '''
//
//                     sh '''
//                         echo "Starting selenium-chrome container..."
//                         docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
//                     '''
//
//                     sh '''
//                         echo "Waiting for Selenium to become ready..."
//                         for i in {1..10}; do
//                             if curl -s http://localhost:4444/status | grep -q "ready"; then
//                                 echo "Selenium is ready."
//                                 break
//                             else
//                                 echo "Waiting..."
//                                 sleep 10
//                             fi
//                         done
//                     '''
//
//                     sh '''
//                         echo "Running tests inside Maven container..."
//                         docker run --rm \
//                             -v $PWD:/tests \
//                             -w /tests \
//                             --network=host \
//                             maven:3.9.6-eclipse-temurin-17 mvn clean test
//                     '''
//
//                     sh 'docker stop selenium-chrome || true'
//                 }
//             }
//         }
//     }
// post {
//             always {
//                 script {
//                     sh '''
//                         echo "Final cleanup..."
//                         docker rm -f selenium-chrome || true
//                     '''
//                 }
//                 archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//             }
//
//             success {
//                 echo "✅ Test automation completed successfully."
//
//                 // Send email
//                 mail to: 'srinivas.g@limitscale.io',
//                      subject: "✅ Test automation completed successfully",
//                      body: "Test automation completed successfully in Jenkins."
//
//             }
//
//             failure {
//                 echo "❌ Pipeline failed. Check server logs for details."
//
//                 // Send email
//                 mail to: 'srinivas.g@limitscale.io',
//                      subject: "❌ Test automation Failed",
//                      body: "Test automation Failed in Jenkins."
//             }
//         }
//}
//**************************** Try 2  working 100 percent *************************
// pipeline {
//     agent any
//
//     stages {
//         stage('Clone Repo') {
//             steps {
//                 git branch: 'srinivas', url: 'https://github.com/Srinivasg457/MATERIALMANAGEMENTPROJECT_AUTOMATION.git'
//             }
//         }
//
//         stage('Run in Docker') {
//             steps {
//                 script {
//                     sh 'docker pull selenium/standalone-chrome:latest'
//
//                     sh '''
//                         echo "Checking for existing container using port 4444..."
//                         PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
//                         if [ ! -z "$PORT_IN_USE" ]; then
//                             echo "Stopping and removing container $PORT_IN_USE..."
//                             docker stop $PORT_IN_USE || true
//                             docker rm $PORT_IN_USE || true
//                             sleep 2
//                         fi
//                     '''
//
//                     sh '''
//                         if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
//                             echo "Cleaning up old selenium-chrome container..."
//                             docker stop selenium-chrome || true
//                             docker rm selenium-chrome || true
//                         fi
//                     '''
//
//                     // FIXED: Added volume mount for test files
//                     sh '''
//                         echo "Starting selenium-chrome container with volume mount..."
//                         docker run -d \
//                             -p 4444:4444 \
//                             --shm-size="2g" \
//                             --name selenium-chrome \
//                             -v ${WORKSPACE}:/home/seluser/automation \
//                             selenium/standalone-chrome:latest
//                     '''
//
//                     sh '''
//                         echo "Waiting for Selenium to become ready..."
//                         for i in {1..10}; do
//                             if curl -s http://localhost:4444/status | grep -q "ready"; then
//                                 echo "Selenium is ready."
//                                 break
//                             else
//                                 echo "Waiting..."
//                                 sleep 10
//                             fi
//                         done
//                     '''
//
//                     sh '''
//                         echo "Running tests inside Maven container..."
//                         docker run --rm \
//                             -v ${WORKSPACE}:/tests \
//                             -w /tests \
//                             --network=host \
//                             -e "TEST_FILE_BASE_PATH=/home/seluser/automation" \
//                             maven:3.9.6-eclipse-temurin-17 mvn clean test
//                     '''
//
//                     sh 'docker stop selenium-chrome || true'
//                 }
//             }
//         }
//     }
//
// post {
//             always {
//                 script {
//                     sh '''
//                         echo "Final cleanup..."
//                         docker rm -f selenium-chrome || true
//                     '''
//                 }
//                 archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//             }
//
//             success {
//                 echo "✅ Test automation completed successfully."
//
//                 // Send email
//                 mail to: 'srinivas.g@limitscale.io',
//                      subject: "✅ Test automation completed successfully",
//                      body: "Test automation completed successfully in Jenkins."
//
//             }
//
//             failure {
//                 echo "❌ Pipeline failed. Check server logs for details."
//
//                 // Send email
//                 mail to: 'srinivas.g@limitscale.io',
//                      subject: "❌ Test automation Failed",
//                      body: "Test automation Failed in Jenkins."
//             }
//         }
// }


// ***** Try 3 Testing Mode ******************
// pipeline {
//     agent any
//
//     stages {
//         stage('Clone Repo') {
//             steps {
//                 git branch: 'srinivas', url: 'https://github.com/Srinivasg457/MATERIALMANAGEMENTPROJECT_AUTOMATION.git'
//             }
//         }
//
//         stage('Run in Docker') {
//             steps {
//                 script {
//                     sh 'docker pull selenium/standalone-chrome:latest'
//
//                     sh '''
//                         echo "Checking for existing container using port 4444..."
//                         PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
//                         if [ ! -z "$PORT_IN_USE" ]; then
//                             echo "Stopping and removing container $PORT_IN_USE..."
//                             docker stop $PORT_IN_USE || true
//                             docker rm $PORT_IN_USE || true
//                             sleep 2
//                         fi
//                     '''
//
//                     sh '''
//                         if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
//                             echo "Cleaning up old selenium-chrome container..."
//                             docker stop selenium-chrome || true
//                             docker rm selenium-chrome || true
//                         fi
//                     '''
//
//                     // FIXED: Added volume mount for test files
//                     sh '''
//                         echo "Starting selenium-chrome container with volume mount..."
//                         docker run -d \
//                             -p 4444:4444 \
//                             --shm-size="2g" \
//                             --name selenium-chrome \
//                             -v ${WORKSPACE}:/home/seluser/automation \
//                             selenium/standalone-chrome:latest
//                     '''
//
//                     sh '''
//                         echo "Waiting for Selenium to become ready..."
//                         for i in {1..10}; do
//                             if curl -s http://localhost:4444/status | grep -q "ready"; then
//                                 echo "Selenium is ready."
//                                 break
//                             else
//                                 echo "Waiting..."
//                                 sleep 10
//                             fi
//                         done
//                     '''
//
//                     sh '''
//                         echo "Running tests inside Maven container..."
//                         docker run --rm \
//                             -v ${WORKSPACE}:/tests \
//                             -w /tests \
//                             --network=host \
//                             -e "TEST_FILE_BASE_PATH=/home/seluser/automation" \
//                             maven:3.9.6-eclipse-temurin-17 mvn clean test
//                     '''
//
//                     sh 'docker stop selenium-chrome || true'
//                 }
//             }
//         }
//     }
//
//     post {
//         always {
//             script {
//                 sh '''
//                     echo "Final cleanup..."
//                     docker rm -f selenium-chrome || true
//                 '''
//             }
//             archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//             junit '**/target/surefire-reports/*.xml'
//         }
//
//         success {
//             echo "✅ Test automation completed successfully."
//
//             // Try to send email with error handling
//             script {
//                 try {
//                     mail to: 'srinivas.g@limitscale.io',
//                          subject: "✅ Test automation completed successfully",
//                          body: "Test automation completed successfully in Jenkins.\n\nBuild URL: ${env.BUILD_URL}"
//                     echo "📧 Success email sent"
//                 } catch (Exception e) {
//                     echo "⚠️ Could not send success email: ${e.message}"
//                     echo "✅ Tests passed! Email notification skipped due to configuration issue."
//                 }
//             }
//         }
//
//         failure {
//             echo "❌ Pipeline failed. Check server logs for details."
//
//             // Try to send email with error handling
//             script {
//                 try {
//                     mail to: 'srinivas.g@limitscale.io',
//                          subject: "❌ Test automation Failed",
//                          body: "Test automation Failed in Jenkins.\n\nCheck: ${env.BUILD_URL}"
//                     echo "📧 Failure email sent"
//                 } catch (Exception e) {
//                     echo "⚠️ Could not send failure email: ${e.message}"
//                     echo "🔍 Check build logs at: ${env.BUILD_URL}"
//                 }
//             }
//         }
//     }
// }


//**** Try 3 Updated version ******************
pipeline {
    agent any

    stages {
        stage('Clone Repo') {
            steps {
                git branch: 'srinivas', url: 'https://github.com/Srinivasg457/MATERIALMANAGEMENTPROJECT_AUTOMATION.git'
            }
        }

        stage('Run in Docker') {
            steps {
                script {
                    sh 'docker pull selenium/standalone-chrome:latest'

                    sh '''
                        echo "Checking for existing container using port 4444..."
                        PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
                        if [ ! -z "$PORT_IN_USE" ]; then
                            echo "Stopping and removing container $PORT_IN_USE..."
                            docker stop $PORT_IN_USE || true
                            docker rm $PORT_IN_USE || true
                            sleep 2
                        fi
                    '''

                    sh '''
                        if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
                            echo "Cleaning up old selenium-chrome container..."
                            docker stop selenium-chrome || true
                            docker rm selenium-chrome || true
                        fi
                    '''

                    // FIXED: Added volume mount for test files
                    sh '''
                        echo "Starting selenium-chrome container with volume mount..."
                        docker run -d \
                            -p 4444:4444 \
                            --shm-size="2g" \
                            --name selenium-chrome \
                            -v ${WORKSPACE}:/home/seluser/automation \
                            selenium/standalone-chrome:latest
                    '''

                    sh '''
                        echo "Waiting for Selenium to become ready..."
                        for i in {1..10}; do
                            if curl -s http://localhost:4444/status | grep -q "ready"; then
                                echo "Selenium is ready."
                                break
                            else
                                echo "Waiting..."
                                sleep 10
                            fi
                        done
                    '''

                    sh '''
                        echo "Running tests inside Maven container..."
                        docker run --rm \
                            -v ${WORKSPACE}:/tests \
                            -w /tests \
                            --network=host \
                            -e "TEST_FILE_BASE_PATH=/home/seluser/automation" \
                            maven:3.9.6-eclipse-temurin-17 mvn clean test
                    '''

                    sh 'docker stop selenium-chrome || true'
                }
            }
        }
    }

    post {
        always {
            script {
                sh '''
                    echo "Final cleanup..."
                    docker rm -f selenium-chrome || true
                '''
            }
            // Archive test results
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true

            // Publish JUnit test results
            junit '**/target/surefire-reports/*.xml'

            // Clean workspace to save disk space
            cleanWs()
        }

success {
    echo "✅ Test automation completed successfully."
    echo "📊 Test reports: ${env.BUILD_URL}testReport/"
    echo "📦 Artifacts: ${env.BUILD_URL}artifact/"

    script {
        // Try to get test results from JUnit reports
        def testResult = null
        try {
            testResult = currentBuild.rawBuild?.getAction(hudson.tasks.junit.TestResultAction.class)
        } catch (Exception e) {
            echo "⚠️ Could not retrieve test results: ${e.message}"
        }

        def totalCount = testResult?.totalCount ?: "N/A"
        def passCount = testResult?.passCount ?: "N/A"
        def failCount = testResult?.failCount ?: 0
        def skipCount = testResult?.skipCount ?: 0

        // Calculate pass percentage
        def passPercentage = "N/A"
        if (totalCount != "N/A" && totalCount > 0) {
            passPercentage = String.format("%.1f", (passCount.toFloat() / totalCount * 100)) + "%"
        }

        // ✅ EMAIL WITH TEST COUNTS
        mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io',
             subject: "✅ SUCCESS: Test Automation Completed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             body: """Test automation completed successfully in Jenkins.

                  🔗 Build URL: ${env.BUILD_URL}
                  📊 Test Reports: ${env.BUILD_URL}testReport/
                  📦 Artifacts: ${env.BUILD_URL}artifact/

                  📋 BUILD INFORMATION:
                  --------------------------
                  Job: ${env.JOB_NAME}
                  Build: #${env.BUILD_NUMBER}
                  Status: ✅ SUCCESS
                  Duration: ${currentBuild.durationString ?: 'N/A'}

                  📈 TEST RESULTS SUMMARY:
                  --------------------------
                  ✅ Total Tests Run: ${totalCount}
                  ✅ Tests Passed: ${passCount}
                  ❌ Tests Failed: ${failCount}
                  ⏭️ Tests Skipped: ${skipCount}
                  📊 Pass Rate: ${passPercentage}

                  🎯 All tests passed successfully! 🎉
                  """
    }
}

failure {
    echo "❌ Pipeline failed. Check server logs for details."
    echo "🔍 Debug URL: ${env.BUILD_URL}"

    script {
        // Try to get test results from JUnit reports
        def testResult = null
        try {
            testResult = currentBuild.rawBuild?.getAction(hudson.tasks.junit.TestResultAction.class)
        } catch (Exception e) {
            echo "⚠️ Could not retrieve test results: ${e.message}"
        }

        def totalCount = testResult?.totalCount ?: "N/A"
        def passCount = testResult?.passCount ?: "N/A"
        def failCount = testResult?.failCount ?: "N/A"
        def skipCount = testResult?.skipCount ?: 0

        // Calculate failure percentage
        def failPercentage = "N/A"
        if (totalCount != "N/A" && totalCount > 0 && failCount != "N/A") {
            failPercentage = String.format("%.1f", (failCount.toFloat() / totalCount * 100)) + "%"
        }

        // ❌ FAILURE EMAIL WITH TEST COUNTS
        mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io',
             subject: "❌ FAILURE: Test Automation Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             body: """Test automation failed in Jenkins.

                  🔗 Build URL: ${env.BUILD_URL}
                  📊 Test Reports: ${env.BUILD_URL}testReport/
                  🔍 Console Output: ${env.BUILD_URL}console

                  📋 BUILD INFORMATION:
                  --------------------------
                  Job: ${env.JOB_NAME}
                  Build: #${env.BUILD_NUMBER}
                  Status: ❌ FAILURE
                  Duration: ${currentBuild.durationString ?: 'N/A'}

                  📉 TEST RESULTS SUMMARY:
                  --------------------------
                  📊 Total Tests Run: ${totalCount}
                  ✅ Tests Passed: ${passCount}
                  ❌ Tests Failed: ${failCount}
                  ⏭️ Tests Skipped: ${skipCount}
                  📉 Failure Rate: ${failPercentage}

                  ⚠️ Please check the build logs and test reports for details.
                  """
    }
}
//         success {
//             echo "✅ Test automation completed successfully."
//             echo "📊 Test reports: ${env.BUILD_URL}testReport/"
//             echo "📦 Artifacts: ${env.BUILD_URL}artifact/"
//
//             // ✅ EMAIL NOW ENABLED - Will work!
//             mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io',
//                  subject: "✅ SUCCESS: Test Automation Completed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
//                  body: """Test automation completed successfully in Jenkins.
//
//                       🔗 Build URL: ${env.BUILD_URL}
//                       📊 Test Reports: ${env.BUILD_URL}testReport/
//                       📦 Artifacts: ${env.BUILD_URL}artifact/
//
//                       Job: ${env.JOB_NAME}
//                       Build: #${env.BUILD_NUMBER}
//                       Status: ✅ SUCCESS
//
//                       All tests passed successfully! 🎉
//                       """
//         }
//
//         failure {
//             echo "❌ Pipeline failed. Check server logs for details."
//             echo "🔍 Debug URL: ${env.BUILD_URL}"
//
//             // ✅ EMAIL NOW ENABLED - Will work!
//             mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io',
//                  subject: "❌ FAILURE: Test Automation Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
//                  body: """Test automation failed in Jenkins.
//
//                  🔗 Build URL: ${env.BUILD_URL}
//                 📊 Test Reports: ${env.BUILD_URL}testReport/
//                 🔍 Console Output: ${env.BUILD_URL}console
//
//                  Job: ${env.JOB_NAME}
//               Build: #${env.BUILD_NUMBER}
//              Status: ❌ FAILURE
//
//                Please check the build logs for details.
//                   """
//         }
    }
}





//     post {
//         always {
//             script {
//                 sh '''
//                     echo "Final cleanup..."
//                     docker rm -f selenium-chrome || true
//                 '''
//             }
//             archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//         }
//
//         success {
//             emailext(
//                 to: 'srinivasg457@gmail.com',
//                 subject: "✅ SUCCESS: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
//                 body: """<p>The Jenkins job has succeeded.</p>
//                          <p>Project: ${env.JOB_NAME}</p>
//                          <p>Build Number: ${env.BUILD_NUMBER}</p>
//                          <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
//                 mimeType: 'text/html'
//             )
//         }
//
//         failure {
//             emailext(
//                 to: 'shreelimitscale@gmail.com',
//                 subject: "❌ FAILURE: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
//                 body: """<p>The Jenkins job has failed.</p>
//                          <p>Project: ${env.JOB_NAME}</p>
//                          <p>Build Number: ${env.BUILD_NUMBER}</p>
//                          <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
//                 mimeType: 'text/html'
//             )
//         }
//     }
//}


//
// pipeline {
//     agent any
//
//     environment {
//         GMAIL_APP_PASSWORD = credentials('gmail-app-password')
//         SMTP_SERVER = 'smtp.gmail.com'
//         SMTP_PORT = '465'
//     }
//
//     stages {
//         stage('Clone Repo') {
//             steps {
//                 git branch: 'main',
//                 url: 'https://github.com/Srinivasg457/WORK-ROOM_LIVE_WEB_AUTOMATION.git'
//             }
//         }
//
//         stage('Setup Selenium') {
//             steps {
//                 script {
//                     // Cleanup any existing containers
//                     sh '''
//                         docker rm -f selenium-chrome || true
//                     '''
//
//                     // Start Selenium with host networking (simpler configuration)
//                     sh '''
//                         docker run -d \
//                           --name selenium-chrome \
//                           --network host \
//                           -p 4444:4444 \
//                           selenium/standalone-chrome:latest
//                     '''
//
//                     // Wait for Selenium to be ready
//                     sh '''
//                         for i in {1..10}; do
//                             if curl -s http://localhost:4444/status | grep -q "ready"; then
//                                 echo "Selenium is ready."
//                                 break
//                             else
//                                 echo "Waiting..."
//                                 sleep 5
//                             fi
//                         done
//                     '''
//                 }
//             }
//         }
//
//         stage('Run Tests') {
//             steps {
//                 script {
//                     // Run tests with host networking to match Selenium
//                     sh '''
//                         docker run --rm \
//                           -v $PWD:/tests \
//                           -w /tests \
//                           --network host \
//                           maven:3.9.6-eclipse-temurin-17 \
//                           mvn clean test
//                     '''
//                 }
//             }
//         }
//     }
//
//     post {
//         always {
//             script {
//                 sh '''
//                     echo "Final cleanup..."
//                     docker rm -f selenium-chrome || true
//                 '''
//                 archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//                 junit '**/target/surefire-reports/*.xml'
//             }
//         }
//
//         success {
//             emailext(
//                 to: 'srinivasg457@gmail.com',
//                 subject: "✅ SUCCESS: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
//                 body: """<p>The Jenkins job has succeeded.</p>
//                          <p>Project: ${env.JOB_NAME}</p>
//                          <p>Build Number: ${env.BUILD_NUMBER}</p>
//                          <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
//                 mimeType: 'text/html',
//                 smtp: [
//                     host: env.SMTP_SERVER,
//                     port: env.SMTP_PORT,
//                     auth: true,
//                     user: 'your.email@gmail.com',
//                     password: env.GMAIL_APP_PASSWORD,
//                     ssl: true
//                 ]
//             )
//         }
//
//         failure {
//             emailext(
//                 to: 'shreelimitscale@gmail.com',
//                 subject: "❌ FAILURE: Job '${env.JOB_NAME} [#${env.BUILD_NUMBER}]'",
//                 body: """<p>The Jenkins job has failed.</p>
//                          <p>Project: ${env.JOB_NAME}</p>
//                          <p>Build Number: ${env.BUILD_NUMBER}</p>
//                          <p><a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
//                 mimeType: 'text/html',
//                 smtp: [
//                     host: env.SMTP_SERVER,
//                     port: env.SMTP_PORT,
//                     auth: true,
//                     user: 'your.email@gmail.com',
//                     password: env.GMAIL_APP_PASSWORD,
//                     ssl: true
//                 ]
//             )
//         }
//     }
// }



//trying to add the email
// pipeline {
//     agent any
//
//     stages {
//         stage('Clone Repo') {
//             steps {
//                 git branch: 'srinivas', url: 'https://github.com/Srinivasg457/MATERIALMANAGEMENTPROJECT_AUTOMATION.git'
//             }
//         }
//
//         stage('Run in Docker') {
//             steps {
//                 script {
//                     sh 'docker pull selenium/standalone-chrome:latest'
//
//                     sh '''
//                         echo "Checking for existing container using port 4444..."
//                         PORT_IN_USE=$(docker ps --filter "publish=4444" --format "{{.ID}}")
//                         if [ ! -z "$PORT_IN_USE" ]; then
//                             echo "Stopping and removing container $PORT_IN_USE..."
//                             docker stop $PORT_IN_USE || true
//                             docker rm $PORT_IN_USE || true
//                             sleep 2
//                         fi
//                     '''
//
//                     sh '''
//                         if docker ps -a --format '{{.Names}}' | grep -q '^selenium-chrome$'; then
//                             echo "Cleaning up old selenium-chrome container..."
//                             docker stop selenium-chrome || true
//                             docker rm selenium-chrome || true
//                         fi
//                     '''
//
//                     sh '''
//                         echo "Starting selenium-chrome container..."
//                         docker run -d -p 4444:4444 --name selenium-chrome selenium/standalone-chrome:latest
//                     '''
//
//                     sh '''
//                         echo "Waiting for Selenium to become ready..."
//                         for i in {1..10}; do
//                             if curl -s http://localhost:4444/status | grep -q "ready"; then
//                                 echo "Selenium is ready."
//                                 break
//                             else
//                                 echo "Waiting..."
//                                 sleep 5
//                             fi
//                         done
//                     '''
//
//                     sh '''
//                         echo "Running tests inside Maven container..."
//                         docker run --rm \
//                             -v $PWD:/tests \
//                             -w /tests \
//                             --network=host \
//                             maven:3.9.6-eclipse-temurin-17 mvn clean test
//                     '''
//
//                     sh 'docker stop selenium-chrome || true'
//                 }
//             }
//         }
//     }
//
//     post {
//             always {
//                 script {
//                     sh '''
//                         echo "Final cleanup..."
//                         docker rm -f selenium-chrome || true
//                     '''
//                 }
//                 archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
//             }
//
//             success {
//                 echo "✅ Test automation completed successfully."
//
//                 // Send email
//                 mail to: 'shreelimitscale@gmail.com',
//                      subject: "✅ Test automation completed successfully",
//                      body: "Test automation completed successfully in Jenkins."
//             }
//
//             failure {
//                 echo "❌ Pipeline failed. Check server logs for details."
//
//                 // Send email
//                 mail to: 'shreelimitscale@gmail.com',
//                      subject: "❌ Test automation Failed",
//                      body: "Test automation Failed in Jenkins."
//             }
//         }
// }