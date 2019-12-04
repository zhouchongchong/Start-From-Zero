# Docker 基础知识
---
## 前提知识
  1.1 基本的linux 知识
  1.2 Git 的使用

  尚硅谷视频

  2019年11月19日 20:59:49

  ## Docker是什么
  <br>
  为了什么？

    1.为了解决代码运行环境与配置的一致性，构造程序的运行环境。软件与环境的打包。
    2.集群环境的快速部署。自动化部署。
    3.跨平台间的无缝接轨运行
    4.软件工作的所需库资源和配置

 <br>
docker 理念

    一次封装，到处运行

    * 将用的与云新的环境打包形成容器运行，运行可以伴随着容器，但是我们对数据的要求希望是持久化得

    * 容器之间希望有可能共享数据

    Docker容器阐述的数据，如果不通过docker commit生成新的镜像使得数据作为镜像的一部分保存下来，那么当容器删除后，数据自然消失

    为了保存容器运行中的数据我们使用数据卷

docker 是什么

    解决了运行环境和配置问题的软件容器，整体发布的容器虚拟化技术。

docker 能干什么


虚拟机的缺点：

    1.步骤多，启动慢 笨重
    2.完整的操作系统

docker 的优势
    
    直接运行在宿主的内核 缩小版 精细 小型的 linux
    具有更少的抽象层
    减少硬件虚拟化
    

docker 架构

    1.Client
    2.docker host :
    3.registry 

DevOps 自己开发 自己运维

Docker 三要素
* 镜像 镜像是分层的
* 容器 容器是用镜像创建的运行实例
* 仓库 集中存放镜像的地方 （公开库）（私有库）阿里云 网易云

仓库注册服务器包括多个仓库

镜像加速配置
### 阿里云镜像加速

    1.打开阿里云镜像加速地址
    https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors
    2.执行以下命令


```Bash
    sudo mkdir -p /etc/docker
    sudo tee /etc/docker/daemon.json <<-'EOF'
    {
      "registry-mirrors": ["https://xtbprdld.mirror.aliyuncs.com"]
    }
    EOF
    sudo systemctl daemon-reload
    sudo systemctl restart docker
```
    3.使用命令查看配置是否生效
    
    sudo docker info
    .
    .
    . 
    Registry Mirrors:
    https://xtbprdld.mirror.aliyuncs.com/
    Live Restore Enabled: false


## Docker 运行机制

CS 结构 client - server
