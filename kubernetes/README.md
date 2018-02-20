## Start/Stop MiniKube cluster
```
brew update && brew install kubectl && brew cask install minikube virtualbox
minikube start
kubectl get nodes
minikube stop
```

## Create Local docker registry
```
cd kubernetes
eval $(minikube docker-env)
docker run -d -p 5000:5000 --restart=always --name registry registry:2
cd ../api ; docker build . --tag libraryproducer ; cd -
docker tag libraryproducer localhost:5000/libraryproducer:0.1.1
```

## Create K8S pod
```
cd kubernetes
kubectl create -f api_deployment.yaml
kubectl describe deployment library-api-deployment
kubectl describe pods
kubectl delete deployment library-api-deployment
```

## Create K8S Service
```
cd kubernetes
kubectl create -f api_service.yaml
kubectl describe service library-api-service
kubectl delete service library-api-service
```

Get URL to access API
```
minikube service libraryproducer --url
```

Get endpoints (currently its none)
```
kubectl get endpoints library-api-service -n kube-system -o yaml
```
