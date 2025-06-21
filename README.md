# Docker Commands Cheat Sheet 🐳

This document contains commonly used Docker commands for managing images, containers, networks, volumes, and Docker Compose. Useful for quick reference during development and deployment.

---

## 📦 Image Management

- `docker pull [image]`  
  Download an image from Docker Hub if not available locally.

- `docker build -t [image_name:tag] .`  
  Build an image from a Dockerfile in the current directory.

- `docker images`  
  List all locally stored images.

- `docker rmi [image_id/name]`  
  Remove an image by its ID or name.

- `docker push [image_name]`  
  Push an image to Docker Hub.

- `docker login`  
  Log in to Docker Hub from CLI.

---

## 🐳 Container Lifecycle

- `docker run [options] [image]`  
  Create and start a container from an image.

- `docker ps`  
  List only running containers.

- `docker ps -a`  
  List all containers (running and stopped).

- `docker start [container_id/name]`  
  Start an existing stopped container.

- `docker stop [container_id/name]`  
  Stop a running container.

- `docker rm [container_id/name]`  
  Remove a stopped container.

- `docker logs [container_id/name]`  
  View logs of a container.

- `docker exec -it [container_id/name] bash`  
  Access the shell of a running container interactively.

---

## 🌐 Networking

- `docker network ls`  
  List all Docker networks.

- `docker network create [network_name]`  
  Create a custom Docker network.

- `docker network rm [network_name]`  
  Remove a Docker network.

---

## 💾 Volumes

- `docker volume ls`  
  List all Docker volumes.

- `docker volume create [volume_name]`  
  Create a named volume.

- `docker volume rm [volume_name]`  
  Remove a volume.

- `docker volume prune`  
  Remove all unused volumes.

---

## ⚙️ Docker Compose

- `docker compose -f [file] up -d`  
  Start all containers defined in a `docker-compose.yml` file in detached mode.

- `docker compose -f [file] down`  
  Stop and remove all containers and resources created by the compose file.

---

## 🧩 Common Flags & Options

- `-it`  
  Run container in interactive terminal mode.

- `-d`  
  Detached mode (run container in the background).

- `-p [host_port]:[container_port]`  
  Map host port to container port.

- `--name [container_name]`  
  Assign a custom name to a container.

- `-e [ENV_VAR=value]`  
  Set environment variables inside the container.

- `-v [host_path]:[container_path]`  
  Mount a volume (bind host path to container path).

---

## 🧩 To Print Containers Env variables

- `docker exec <container_name_or_id> printenv` 

   To print the environment variables of a running container


- `docker inspect <container_name_or_id>`

  To Reconstruct the docker run command of a running container - Basic reconstruction:


- `docker inspect --format='docker run -d {{range .Config.Env}}-e {{.}} {{end}}--name {{.Name}} {{.Config.Image}} {{range .Config.Cmd}}{{.}} {{end}}' <container_name>`

  To Reconstruct the docker run command of a running container - extract ENV, name, and image


- `docker inspect --format '{{range $k,$v := .NetworkSettings.Networks}}{{$k}}{{end}}' <container_name>`

  To get network name of a running container

---

## ✅ Example: Running a PostgreSQL Container

```bash
docker run -d \
  --name pg \
  -e POSTGRES_PASSWORD=root \
  -v /your/local/data:/var/lib/postgresql/data \
  -p 5432:5432 \
  --network your-network-name \
  postgres
