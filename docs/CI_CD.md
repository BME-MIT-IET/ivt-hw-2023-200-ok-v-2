For the purposes of build automation of the Java application, we used Maven. First, we created a pom.xml file which contains configuration information such as dependencies that need to be imported,build settings or plugins. The dependencies section of the file lists the project’s dependencies and their scope, and the build section defines the build configuration of the project, configuring plugins such as Maven Compiler Plugin and Maven Surefire Plugin.  


Using Github Actions, we defined a workflow - set of actions that need to be executed in response to events, such as a push or pull request. A .yml file was created in the workflows directory. This file describes what sequence of actions is executed in response to a push or pull event on the main branch. The job of this workflow is ‘build’, including steps:

Checkout - Checking out the repository code.
Set up - Setting up JDK (with the specified version).
Build with Maven - Building the project. Importantly, it specifies the location of the pom.xml file. 
Build and push - Builds and pushes the Docker image of the file.


By doing this, we were able to automate the build process of the project, manage dependencies, automatically run tests on the code. We also created a docker image of the project, packaging the application into a portable image. We learnt the importance of standardizing the build process which is crucial for a team project. We familiarized ourselves with the CI/CD pipeline and its benefits.
