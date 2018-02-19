## Start/Stop MiniKube cluster
```
brew update && brew install kubectl && brew cask install minikube virtualbox
minikube start
kubectl get nodes
minikube stop
```

## Local docker registry
```
docker run -d -p 5000:5000 --restart=always --name registry registry:2
cd api ; docker build -t libraryproducer . ; docker tag libraryproducer libraryproducer ; cd ..
docker tag libraryproducer localhost:5000/libraryproducer:0.1.0
```

## Create K8S pod
```
kubectl create -f kubernetes/api_deployment.yaml
kubectl describe pod libraryproducer
kubectl delete pod libraryproducer
```

## Create K8S Service
```
kubectl create -f kubernetes/api_service.yaml
kubectl describe svc libraryproducer
kubectl delete svc libraryproducer
```

Get URL to access API
```
minikube service libraryproducer --url
```
