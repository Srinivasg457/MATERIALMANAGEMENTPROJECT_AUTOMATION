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

            // Get test results if available
            def testResult = currentBuild.rawBuild?.getAction(hudson.tasks.junit.TestResultAction.class)
            def totalTests = testResult?.totalCount ?: 'N/A'
            def passedTests = testResult?.passCount ?: 'N/A'
            def failedTests = testResult?.failCount ?: 0
            def passRate = totalTests != 'N/A' && totalTests > 0 ?
                           (passedTests.toFloat() / totalTests * 100).round(2) : 100

            // ✅ EMAIL WITH COLORS & DETAILS
            mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io',
                 subject: "✅ SUCCESS: Test Automation Completed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 mimeType: 'text/html',
                 body: """
                 <!DOCTYPE html>
                 <html>
                 <head>
                     <meta charset="UTF-8">
                     <style>
                         body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; line-height: 1.6; color: #333; }
                         .container { max-width: 700px; margin: 0 auto; padding: 20px; background: #f9f9f9; }
                         .header { background: linear-gradient(135deg, #28a745, #20c997); color: white; padding: 25px; text-align: center; border-radius: 8px 8px 0 0; }
                         .content { background: white; padding: 25px; border-radius: 0 0 8px 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
                         .success-badge { background: #28a745; color: white; padding: 5px 15px; border-radius: 20px; font-weight: bold; display: inline-block; }
                         .section { margin: 25px 0; padding-bottom: 20px; border-bottom: 1px solid #eee; }
                         .section-title { color: #2c3e50; font-size: 18px; margin-bottom: 15px; font-weight: bold; }
                         .stats-grid { display: grid; grid-template-columns: repeat(2, 1fr); gap: 15px; margin-top: 10px; }
                         .stat-card { background: #f8f9fa; padding: 15px; border-radius: 6px; border-left: 4px solid #28a745; }
                         .stat-value { font-size: 24px; font-weight: bold; color: #28a745; }
                         .stat-label { color: #6c757d; font-size: 14px; }
                         .link-box { background: #e9f7ef; padding: 15px; border-radius: 6px; margin: 15px 0; }
                         .link { color: #007bff; text-decoration: none; }
                         .link:hover { text-decoration: underline; }
                         .footer { margin-top: 30px; padding-top: 20px; border-top: 1px solid #ddd; color: #6c757d; font-size: 12px; text-align: center; }
                         .emoji { font-size: 20px; }
                         .highlight { background: #fff3cd; padding: 2px 5px; border-radius: 3px; }
                     </style>
                 </head>
                 <body>
                     <div class="container">
                         <div class="header">
                             <h1 style="margin: 0;">🎉 TEST AUTOMATION SUCCESS</h1>
                             <p style="margin: 10px 0 0 0; opacity: 0.9;">All tests passed successfully!</p>
                         </div>

                         <div class="content">
                             <div style="text-align: center; margin-bottom: 20px;">
                                 <span class="success-badge">✅ SUCCESS</span>
                             </div>

                             <!-- BUILD INFORMATION SECTION -->
                             <div class="section">
                                 <div class="section-title">📋 BUILD INFORMATION</div>
                                 <div class="stats-grid">
                                     <div class="stat-card">
                                         <div class="stat-value">${env.JOB_NAME}</div>
                                         <div class="stat-label">Job Name</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value">#${env.BUILD_NUMBER}</div>
                                         <div class="stat-label">Build Number</div>
                                     </div>
                                 </div>
                                 <p><strong>📅 Build Duration:</strong> ${currentBuild.durationString ?: 'N/A'}</p>
                                 <p><strong>👤 Triggered By:</strong> ${currentBuild.getBuildCauses()[0]?.shortDescription ?: 'Manual Trigger'}</p>
                             </div>

                             <!-- TEST RESULTS SECTION -->
                             <div class="section">
                                 <div class="section-title">📊 TEST RESULTS</div>
                                 <div class="stats-grid">
                                     <div class="stat-card">
                                         <div class="stat-value">${totalTests}</div>
                                         <div class="stat-label">Total Tests</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value" style="color: #28a745;">${passedTests}</div>
                                         <div class="stat-label">Passed Tests</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value" style="color: #dc3545;">${failedTests}</div>
                                         <div class="stat-label">Failed Tests</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value" style="color: #17a2b8;">${passRate}%</div>
                                         <div class="stat-label">Pass Rate</div>
                                     </div>
                                 </div>
                             </div>

                             <!-- QUICK LINKS SECTION -->
                             <div class="section">
                                 <div class="section-title">🔗 QUICK LINKS</div>
                                 <div class="link-box">
                                     <p><strong>🌐 Build Dashboard:</strong> <a class="link" href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                                     <p><strong>📈 Test Reports:</strong> <a class="link" href="${env.BUILD_URL}testReport/">View Detailed Test Reports</a></p>
                                     <p><strong>📦 Artifacts:</strong> <a class="link" href="${env.BUILD_URL}artifact/">Download Build Artifacts</a></p>
                                     <p><strong>📝 Console Output:</strong> <a class="link" href="${env.BUILD_URL}console">View Full Console Log</a></p>
                                 </div>
                             </div>

                             <!-- ENVIRONMENT DETAILS -->
                             <div class="section">
                                 <div class="section-title">⚙️ ENVIRONMENT DETAILS</div>
                                 <p><strong>🌍 Application:</strong> <span class="highlight">SharePoint Material Management</span></p>
                                 <p><strong>🖥️ Browser:</strong> Chrome</p>
                                 <p><strong>🏷️ Test Tags:</strong> @smoke, @regression</p>
                                 <p><strong>⏱️ Execution Time:</strong> ${new Date()}</p>
                             </div>

                             <!-- NEXT STEPS -->
                             <div class="section" style="border-bottom: none;">
                                 <div class="section-title">🎯 NEXT STEPS</div>
                                 <p style="color: #28a745;">✅ <strong>Ready for deployment review</strong></p>
                                 <p style="color: #28a745;">✅ <strong>All critical tests passed</strong></p>
                                 <p style="color: #28a745;">✅ <strong>No blocking issues found</strong></p>
                             </div>

                             <div class="footer">
                                 <p>🤖 This is an automated notification from Jenkins CI/CD Pipeline</p>
                                 <p>📧 Please do not reply to this email</p>
                                 <p>🕐 Generated at: ${new Date()}</p>
                             </div>
                         </div>
                     </div>
                 </body>
                 </html>
                 """
        }

        failure {
            echo "❌ Pipeline failed. Check server logs for details."
            echo "🔍 Debug URL: ${env.BUILD_URL}"

            // Get test results if available
            def testResult = currentBuild.rawBuild?.getAction(hudson.tasks.junit.TestResultAction.class)
            def totalTests = testResult?.totalCount ?: 'N/A'
            def passedTests = testResult?.passCount ?: 'N/A'
            def failedTests = testResult?.failCount ?: 'N/A'

            // ❌ FAILURE EMAIL WITH COLORS & DETAILS
            mail to: 'srinivas.g@limitscale.io,srinivasg457@gmail.com,jeyasimhan@limitscale.io',
                 subject: "❌ FAILURE: Test Automation Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 mimeType: 'text/html',
                 body: """
                 <!DOCTYPE html>
                 <html>
                 <head>
                     <meta charset="UTF-8">
                     <style>
                         body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; line-height: 1.6; color: #333; }
                         .container { max-width: 700px; margin: 0 auto; padding: 20px; background: #f9f9f9; }
                         .header { background: linear-gradient(135deg, #dc3545, #e35d6a); color: white; padding: 25px; text-align: center; border-radius: 8px 8px 0 0; }
                         .content { background: white; padding: 25px; border-radius: 0 0 8px 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
                         .failure-badge { background: #dc3545; color: white; padding: 5px 15px; border-radius: 20px; font-weight: bold; display: inline-block; }
                         .section { margin: 25px 0; padding-bottom: 20px; border-bottom: 1px solid #eee; }
                         .section-title { color: #2c3e50; font-size: 18px; margin-bottom: 15px; font-weight: bold; }
                         .stats-grid { display: grid; grid-template-columns: repeat(2, 1fr); gap: 15px; margin-top: 10px; }
                         .stat-card { background: #f8f9fa; padding: 15px; border-radius: 6px; border-left: 4px solid #dc3545; }
                         .stat-value { font-size: 24px; font-weight: bold; color: #dc3545; }
                         .stat-label { color: #6c757d; font-size: 14px; }
                         .link-box { background: #fde8e8; padding: 15px; border-radius: 6px; margin: 15px 0; }
                         .link { color: #007bff; text-decoration: none; }
                         .link:hover { text-decoration: underline; }
                         .footer { margin-top: 30px; padding-top: 20px; border-top: 1px solid #ddd; color: #6c757d; font-size: 12px; text-align: center; }
                         .emoji { font-size: 20px; }
                         .alert { background: #fff3cd; border-left: 4px solid #ffc107; padding: 15px; margin: 15px 0; border-radius: 0 6px 6px 0; }
                         .highlight { background: #f8d7da; padding: 2px 5px; border-radius: 3px; color: #721c24; }
                         .urgent { color: #dc3545; font-weight: bold; }
                     </style>
                 </head>
                 <body>
                     <div class="container">
                         <div class="header">
                             <h1 style="margin: 0;">🚨 TEST AUTOMATION FAILURE</h1>
                             <p style="margin: 10px 0 0 0; opacity: 0.9;">Immediate attention required!</p>
                         </div>

                         <div class="content">
                             <div style="text-align: center; margin-bottom: 20px;">
                                 <span class="failure-badge">❌ FAILURE</span>
                             </div>

                             <!-- URGENT ALERT -->
                             <div class="alert">
                                 <strong>⚠️ URGENT:</strong> Test automation pipeline has failed. Immediate investigation required.
                             </div>

                             <!-- BUILD INFORMATION SECTION -->
                             <div class="section">
                                 <div class="section-title">📋 FAILED BUILD INFORMATION</div>
                                 <div class="stats-grid">
                                     <div class="stat-card">
                                         <div class="stat-value">${env.JOB_NAME}</div>
                                         <div class="stat-label">Job Name</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value">#${env.BUILD_NUMBER}</div>
                                         <div class="stat-label">Build Number</div>
                                     </div>
                                 </div>
                                 <p><strong>📅 Build Duration:</strong> ${currentBuild.durationString ?: 'N/A'}</p>
                                 <p><strong>👤 Triggered By:</strong> ${currentBuild.getBuildCauses()[0]?.shortDescription ?: 'Manual Trigger'}</p>
                                 <p><strong>⏰ Failed At:</strong> ${new Date()}</p>
                             </div>

                             <!-- FAILURE DETAILS SECTION -->
                             <div class="section">
                                 <div class="section-title">📊 FAILURE STATISTICS</div>
                                 <div class="stats-grid">
                                     <div class="stat-card">
                                         <div class="stat-value">${totalTests}</div>
                                         <div class="stat-label">Total Tests</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value" style="color: #28a745;">${passedTests}</div>
                                         <div class="stat-label">Passed Tests</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value" style="color: #dc3545;">${failedTests}</div>
                                         <div class="stat-label">Failed Tests</div>
                                     </div>
                                     <div class="stat-card">
                                         <div class="stat-value" style="color: #dc3545;">${totalTests != 'N/A' && totalTests > 0 ? (failedTests.toFloat()/totalTests*100).round(2) : 0}%</div>
                                         <div class="stat-label">Failure Rate</div>
                                     </div>
                                 </div>
                             </div>

                             <!-- INVESTIGATION LINKS -->
                             <div class="section">
                                 <div class="section-title">🔍 INVESTIGATION LINKS</div>
                                 <div class="link-box">
                                     <p class="urgent"><strong>🚨 Console Output:</strong> <a class="link" href="${env.BUILD_URL}console">View Error Logs (Most Important)</a></p>
                                     <p><strong>📈 Test Reports:</strong> <a class="link" href="${env.BUILD_URL}testReport/">View Failed Test Details</a></p>
                                     <p><strong>📦 Artifacts:</strong> <a class="link" href="${env.BUILD_URL}artifact/">Download Screenshots & Logs</a></p>
                                     <p><strong>🌐 Build Dashboard:</strong> <a class="link" href="${env.BUILD_URL}">Go to Build Dashboard</a></p>
                                 </div>
                             </div>

                             <!-- TROUBLESHOOTING STEPS -->
                             <div class="section">
                                 <div class="section-title">🔧 TROUBLESHOOTING STEPS</div>
                                 <ol style="color: #dc3545;">
                                     <li><strong>Check console logs</strong> for stack traces and error messages</li>
                                     <li><strong>Review failed test cases</strong> in the test report</li>
                                     <li><strong>Check application status</strong> - Is the SharePoint application accessible?</li>
                                     <li><strong>Verify test data</strong> - Has test data changed or expired?</li>
                                     <li><strong>Check dependencies</strong> - Are all required services running?</li>
                                 </ol>
                             </div>

                             <!-- POSSIBLE CAUSES -->
                             <div class="section" style="border-bottom: none;">
                                 <div class="section-title">🎯 POSSIBLE FAILURE CAUSES</div>
                                 <p><span class="highlight">🔴 Application Issues:</span> SharePoint downtime, authentication problems</p>
                                 <p><span class="highlight">🔴 Test Script Issues:</span> Element not found, timing issues, stale elements</p>
                                 <p><span class="highlight">🔴 Environment Issues:</span> Network problems, browser version mismatch</p>
                                 <p><span class="highlight">🔴 Data Issues:</span> Invalid test data, expired credentials</p>
                             </div>

                             <div class="footer">
                                 <p>🚨 <strong>URGENT:</strong> This failure requires immediate attention</p>
                                 <p>🤖 Automated failure notification from Jenkins CI/CD Pipeline</p>
                                 <p>📧 Please investigate and fix the issue promptly</p>
                                 <p>🕐 Failure detected at: ${new Date()}</p>
                             </div>
                         </div>
                     </div>
                 </body>
                 </html>
                 """
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