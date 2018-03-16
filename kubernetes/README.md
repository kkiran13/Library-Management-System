# Kubernetes deployment

## Installation on MacOSX
```
brew update && brew install kubectl && brew cask install minikube virtualbox
```

## Commands to spin up library API using K8S
Start minikube cluster
```
minikube start OR minikube start --memory=4096
```

Set docker environment variables in virtualized kube environemtn
```
cd LibraryManager/kubernetes
eval $(minikube docker-env)
docker run -d -p 5000:5000 --restart=always --name registry registry:2
cd ../api ; docker build . --tag libraryproducer ; cd -
docker tag libraryproducer localhost:5000/libraryproducer:0.1.2
```

Create service and deployment for API
```
kubectl create -f api_service.yaml
kubectl create -f api_deployment.yaml
```

Describe service and deployment created
```
kubectl describe service libraryproducer
kubectl describe deployment libraryproducer
```

Get URL and access health endpoint of API (Should return `Library API is healthy!!`)
```
minikube service libraryproducer --url
curl $(minikube service libraryproducer --url)/library/health ; echo
```

Clean up cluster by deleting deployment and service created
```
kubectl delete service,deployment libraryproducer
```

Stop minikube cluster
```
minikube stop
```
