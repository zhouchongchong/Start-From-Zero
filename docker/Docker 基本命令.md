# Docker 基础命令

---

## 帮助命令

    docker version

    docker info

    docker --help

命令格式

    docker [OPTIONS] COMMAND [args]

## 镜像命令

    列出本地主机上的镜像
    docker images
    docker images -a (含中间镜像层)
    docker images -qa (id)
    docker images --digests (显示摘要信息)
    docker images --digests --no-trunc (不要截取)

    寻找镜像
    docker search 去镜像仓库查找
    docker search -s number tomcat

    拉取镜像
    docker pull image
    docker pull image:version

    删除镜像
    docker rmi image:version
    docker rmi -f image:version
    删除多个
    docker rmi -f image:version image:version

    删除全部
    docker rmi -f $(docker images -qa )


## 容器命令

    新建并启动容器
    docker run [OPTIONS] IMAGE [COMMAND] [ARG...]
    docker run -it --name [name]

    守护方式启动容器
    docker run -d [image] 启动过就退出了 docker ps 无法查看



    --name="容器新名字"：为容器制定一个名字
    -d: 后台运行容器，并返回容器ID,也启动守护石容器
    
    -i: 为容器重新分配一个未输入终端，通常与-t同时使用
        i 交互 t 终端 terminal
    -P: 随机端口映射
        hostPort:containPort
    -p: 指定端口映射，有以下四种格式
        ip:hostPort:containerPort
        ip::containerPort
        hostPost:containerPort
        containerPort

    -a: 历史上运行过得容器

    查询容器
    docker ps 正在运行的容器
    docker ps -a 历史所有容器 运行与已经死亡的
    docker ps -l 最后一个运行的容器
    docker ps -n [number] 最近几个创建的容器
    docker ps -lq 显示id


    docker 日志查看
    docker logs -f -t --tail [c-id]
    -t time
    -f 不停的追加
    --tail 倒数的多少行

    docker run -d [image] /bin/sh -c "while true; do echo hello zcc; sleep 2; done "

    查看容器内进程
    docker top [c-id]

    查看容器内部细节 
    docker inspect [c-id]

    进入正在运行的容器并以命令行交互
    docker exec -t [c-id] [command] 执行拿出结果 不进入容器

    docker exec -it [c-id]          不进入容器执行交换命令
    docker exec -it [c-id] bash     进入容器
    docker attach [c-id]            进入容器

    从容器拷贝文件到主机
    docker cp [c-id]:[path] [hostPath]



    关闭并退出容器
    exit

    退出不关闭容器
    ctrl + P + Q

    重新打开容器
    docker start [c-id]

    重启容器
    docker restart [c-id]

    (内部可以缓存)停止容器 
    docker stop [c-id]

    强制关闭
    docker kill [c-id]

    删除已经停止的容器
    docker rm [c-id]

    docker rm -f ${docker ps -a -q}
    docker ps -a -q | xargs docker rm

    docker exec -it [c-name] bash


## 镜像命令

    提交命令
    docker commit 提交容器副本使之成为一个新的镜像
    docker commit -m "[message]" -a="[writer]" [c-id] zhouchong/tags:version






