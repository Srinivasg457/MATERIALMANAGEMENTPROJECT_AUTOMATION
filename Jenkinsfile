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
// //     post {
// //         always {
// //             script {
// //                 sh '''
// //                     echo "Final cleanup..."
// //                     docker rm -f selenium-chrome || true
// //                 '''
// //             }
// //             // Archive test results
// //             archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true
// //
// //             // Publish JUnit test results
// //             junit '**/target/surefire-reports/*.xml'
// //
// //             // Clean workspace to save disk space
// //             cleanWs()
// //         }
//
// post {
//         always {
//             junit '**/target/surefire-reports/*.xml'
//
//             script {
//                 // Get test results
//                 def testResult = currentBuild.rawBuild.getAction(hudson.tasks.junit.TestResultAction.class)
//
//                 if (testResult) {
//                     env.TOTAL_TESTS = testResult.totalCount
//                     env.PASSED_TESTS = testResult.totalCount - testResult.failCount - testResult.skipCount
//                     env.FAILED_TESTS = testResult.failCount
//                     env.SKIPPED_TESTS = testResult.skipCount
//
//                     echo "📊 Test Summary:"
//                     echo "   Total Tests: ${env.TOTAL_TESTS}"
//                     echo "   ✅ Passed: ${env.PASSED_TESTS}"
//                     echo "   ❌ Failed: ${env.FAILED_TESTS}"
//                     echo "   ⏩ Skipped: ${env.SKIPPED_TESTS}"
//                 }
//             }
//         }
//
//         success {
//             script {
//                 // Get test results
//                 def testResult = currentBuild.rawBuild.getAction(hudson.tasks.junit.TestResultAction.class)
//                 def total = testResult?.totalCount ?: 0
//                 def failed = testResult?.failCount ?: 0
//                 def passed = total - failed - (testResult?.skipCount ?: 0)
//                 def skipped = testResult?.skipCount ?: 0
//
//                 echo "✅ Test automation completed successfully."
//                 echo "📊 Test Summary:"
//                 echo "   Total Tests: ${total}"
//                 echo "   ✅ Passed: ${passed}"
//                 echo "   ❌ Failed: ${failed}"
//                 echo "   ⏩ Skipped: ${skipped}"
//
//                 mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com',
//                      subject: "✅ SUCCESS: Test Automation - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
//                      body: """📊 TEST EXECUTION SUMMARY:
//
// ✅ ALL TESTS PASSED!
//
// 📈 Test Results:
//    Total Tests: ${total}
//    ✅ Passed: ${passed}
//    ❌ Failed: ${failed}
//    ⏩ Skipped: ${skipped}
//    📊 Pass Rate: ${total > 0 ? Math.round((passed/total)*100) : 0}%
//
// 🔗 Build Details:
//    Build URL: ${env.BUILD_URL}
//    Test Reports: ${env.BUILD_URL}testReport/
//    Artifacts: ${env.BUILD_URL}artifact/
//    Job: ${env.JOB_NAME}
//    Build: #${env.BUILD_NUMBER}
//
// Excellent work! All automated tests have passed successfully! 🎉
// """
//             }
//         }
//
//         failure {
//             script {
//                 // Get test results
//                 def testResult = currentBuild.rawBuild.getAction(hudson.tasks.junit.TestResultAction.class)
//                 def total = testResult?.totalCount ?: 0
//                 def failed = testResult?.failCount ?: 0
//                 def passed = total - failed - (testResult?.skipCount ?: 0)
//                 def skipped = testResult?.skipCount ?: 0
//
//                 echo "❌ Pipeline failed. Check server logs for details."
//                 echo "📊 Test Summary:"
//                 echo "   Total Tests: ${total}"
//                 echo "   ✅ Passed: ${passed}"
//                 echo "   ❌ Failed: ${failed}"
//                 echo "   ⏩ Skipped: ${skipped}"
//
//                 mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com',
//                      subject: "❌ FAILURE: Test Automation - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
//                      body: """❌ TEST EXECUTION FAILED!
//
// 📈 Test Results:
//    Total Tests: ${total}
//    ✅ Passed: ${passed}
//    ❌ Failed: ${failed}
//    ⏩ Skipped: ${skipped}
//    📊 Pass Rate: ${total > 0 ? Math.round((passed/total)*100) : 0}%
//
// 🔍 Failure Details:
//    Build URL: ${env.BUILD_URL}
//    Test Reports: ${env.BUILD_URL}testReport/
//    Console Output: ${env.BUILD_URL}console
//    Job: ${env.JOB_NAME}
//    Build: #${env.BUILD_NUMBER}
//
// ⚠️ ${failed} test(s) failed. Please check the test reports for details.
// """
//             }
//         }
//     }
// }


//claude code
pipeline {
    agent any

    stages {
        stage('Pre-Cleanup') {
            steps {
                sh 'chmod -R 777 . || true'
                deleteDir()
            }
        }

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
            // All sh, junit steps need a node context when checkout failed
            node('') {
                sh 'chmod -R 777 . || true'
                junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                sh 'docker rm -f selenium-chrome || true'
            }

            script {
                // Correct sandbox-safe way to get test results
                def total   = 0
                def failed  = 0
                def skipped = 0
                def passed  = 0

                try {
                    total   = currentBuild.absoluteUrl ? (currentBuild.testResultAction?.totalCount ?: 0) : 0
                } catch (e) {
                    // testResultAction not available yet - tests may not have run
                }

                echo "📊 Test Summary:"
                echo "   Total   : ${total}"
                echo "   ✅ Passed : ${passed}"
                echo "   ❌ Failed : ${failed}"
                echo "   ⏩ Skipped: ${skipped}"
            }
        }

        success {
            script {
                mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com',
                     subject: "✅ SUCCESS: Test Automation - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: """✅ ALL TESTS PASSED!

🔗 Build Details:
   Build URL    : ${env.BUILD_URL}
   Test Reports : ${env.BUILD_URL}testReport/
   Job          : ${env.JOB_NAME}
   Build        : #${env.BUILD_NUMBER}
"""
            }
        }

        failure {
            script {
                mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com',
                     subject: "❌ FAILURE: Test Automation - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: """❌ BUILD/TEST FAILED!

🔍 Details:
   Build URL      : ${env.BUILD_URL}
   Console Output : ${env.BUILD_URL}console
   Job            : ${env.JOB_NAME}
   Build          : #${env.BUILD_NUMBER}
"""
            }
        }
    }
}


//         success {
//             echo "✅ Test automation completed successfully."
//             echo "📊 Test reports: ${env.BUILD_URL}testReport/"
//             echo "📦 Artifacts: ${env.BUILD_URL}artifact/"
//
//             // ✅ EMAIL NOW ENABLED - Will work!
//             mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io,selvarajan@limitscale.com',
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
//             mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io,selvarajan@limitscale.com',
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
  //  }
//}





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