## Setup

### Using Dev Containers

We recommend running this tutorial inside a Dev Container in VSCode. This ensures a consistent development environment without requiring manual setup.

To get started, make sure you have the following installed:
- Docker
- [Dev Containers extension for VSCode](https://code.visualstudio.com/docs/devcontainers/containers)

### Build the Docker Image
Once Docker is installed, build the development image:
```
cd .devcontainer
docker build -t spinalhdl-basic .
```

### Open the Project in a Dev Container
After the Dev Containers extension is installed, open the project in a container:
1. In VSCode, press F1.
2. Run the following command:
```
Dev Containers: Rebuild and Reopen in Container
```

### Import the Project
Inside the Dev Container, import the build for Scala/Metals:
1. Press F1 in VSCode.
2. Run:
```
Metals: Import build
```