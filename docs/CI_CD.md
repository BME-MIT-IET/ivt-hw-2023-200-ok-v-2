For the purposes of build automation of the Java application, we used Maven. First, we created a pom.xml file which contains configuration information such as dependencies that need to be imported,build settings or plugins. The dependencies section of the file lists the project’s dependencies and their scope, and the build section defines the build configuration of the project, configuring plugins such as Maven Compiler Plugin and Maven Surefire Plugin.  


Using Github Actions, we defined a workflow - set of actions that need to be executed in response to events, such as a push or pull request. A .yml file was created in the workflows directory. This file describes what sequence of actions is executed in response to a push or pull event on the main branch. The job of this workflow is ‘build’, including steps:

Checkout - This action checked out the repository code, ensuring that the latest version of the code was available for the subsequent build process.
Set up - We configured the workflow to set up the Java Development Kit (JDK) with the specified version. This ensured that the correct JDK was available for the build process.
Build with Maven -This step executed the Maven build process using the specified pom.xml file. It compiled the code, resolved dependencies, and executed any defined tests. The pom.xml file's location was provided to ensure the build process used the correct configuration.
Build and push - We incorporated the creation of a Docker image into our workflow. Docker provides a platform for packaging applications into portable images. We built a Docker image of our application, which contained all the necessary dependencies and configurations to run the Java application in any environment. By pushing the Docker image, we made it accessible for deployment to various platforms.

By doing this, we were able to automate the build process of the project, manage dependencies, automatically run tests on the code. We also created a docker image of the project, packaging the application into a portable image. We learnt the importance of standardizing the build process which is crucial for a team project. We familiarized ourselves with the CI/CD pipeline and its benefits.




Sonar Cloud was used to analyze the quality of the code.
The results are as follows: 

Reliability rating C, 2 bugs. The reliability rating indicates the code's reliability and stability. A rating of C suggests there might be room for improvement in terms of reliability. 

Maintainability Rating A, 242 Code Smells. The maintainability rating reflects the code's ease of maintenance and understandability. An A rating indicates that the code is well-structured and readable. However, the presence of 242 code smells indicates that there is room for improvement. 

Security Rating A, 0 Vulnerabilities. The security rating represents the code's security strength. An A rating indicates that the code has good security practices in place.

0.0 Duplications: Duplications refer to code segments that have been duplicated across the codebase. A value of 0.0 indicates that there are no instances of code duplication.

16 Security Hotspots found, that require manual assessment. 

