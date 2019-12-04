# Docker File 基本命令

---

## 什么是dockerfile

    镜像模板的描述文件
    Dockerfile 是构建docker image的文件，是由一系列命令和参数构成的脚本
    
构建三步骤

* 1.书写Dockerfile 必须符合书写规范
* 2.有了Dockerfile后，直接执行docker build命令执行，获得一个自定义的image
* 3.使用docker run 创建容器 

## 基础知识

* 1.每条保留指令都必须为大写字母后面要跟至少一个参数
* 2.指令按照从上到下，顺序执行
* 3.#表示注释
* 4.每条指令都会创建一个新的镜像层，并对镜像进行提交 

从应用软件的角度上看，Dockerfile、Docker镜像与Docker容器分别代表容器的三个不同阶段

* Dockerfile是软件的原材料
* Docker image是软件的交付品
* Docker容器是认为是软件的运行态

Dockrfile面向开发，Docker image 成为交付标准，Docker container涉及部署和运维，三者缺一不可，合力充当DOcker体系的基石。


* 1 Dockerfile,需要定义一个Dockerfile，Dockerfile 定义了进程需要的一切东西。Dockerfile涉及的内容包括执行代码或者是文件、华景变量、依赖包、运行时环境、动态链接库、操作系统的发行版本、服务进程和内核进程（当应用进程需要和系统服务和内核进程打交道，这时需要考虑如何设置namespace的权限控制）等等

* 2 Docker image，在用 Dockerfile定义一个文件后，docker build 时会产生一个镜像，当运行docker image时会真正的提供一个服务即产生一个docker 容器。

* 3 Docker 容器，容器是直接提供服务的。

## scratch

    源镜像：所有镜像的父亲 OBJECT


## Dockerfile 常用保留字

    FROM [imagename]
    构建镜像的基础镜像

    MAINTAINER [info]
    作者信息

    ADD 
    将宿主机目录下的文件拷贝进镜像且ADD命令会自动处理URL和解压tar压缩包

    COPY
    类似ADD,拷贝文件和目录到镜像中。将从构建上下文目录中<源路径>的文件/目录复制到新的一层镜像内的<目标路径>位置

    VOLUME 
    容器数据卷，用于数据保存和持久化工作

    LABEL [label] 
    标签 说明

    CMD [command]
    容器完成后，启动时执行的命令,dockerfile中只有最后一个CMD命令有效，CMD会被docker run之后的参数替换

    ENTRYPOINT
    制定一个容器启动时要运行的命令。ENTRYPOINT的目的和CMD一样，都是制定容器启动程序及参数。

    ONBUILD
    当构建一个被继承的Dockerfile时运行命令，父镜像在被子集成后父镜像的ONBUILD被处罚

    WORKDIR [workpath]
    设置工作命令

    ENV [var] [value] 
    设置环境变量

    RUN [command]
    容器构建时执行的命令

    EXPOSE [port] 
    暴露端口


## Dockerfile 解析过程


