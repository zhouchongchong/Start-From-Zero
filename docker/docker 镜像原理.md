# Docker 镜像原理

---

## image 是什么

    轻量级、可执行的独立软件包
    UnionFS 联合文件系统 对文件系统的修改提交，一层层的叠加

    镜像加载原理
    bootfs bootloader kernel bootloader主要是引导加载kernel,linux刚启动时回家再bootfs文件系统，在Docker镜像最底层的是bootfs.这一层与我们的典型的linux/unix系统是一样，包含boot夹杂器和内核。当boot加载完成后整个内核都在内存中了，此时内存的使用权由bootfs转交给内核，此时系统也会卸载bootfs。

    rootfs(root file system),zai bootfs之上。包含的就是典型的Linux系统中的 /dev, /proc, /bin, /etc 等标准目录和文件。rootfs就是个钟不同的操作系统的发行版，比如Ubuntu,Centos 等

    为什么docker image 这么小
    docker image是一个精简的OS,rootfs可以很小，只包括基本的命令，工具和程序库，因为底层直接使用host的kernel,自己只需要提供rootfs。由此可见对于不同的linux发行版，bootfs基本是一直的，rootfs会有差别，因此不同的发行版可以共用bootfs.

    为什么要这么多层叠镜像
    共享资源

## Docker 镜像特点

    只读
    当容器启动时，一个新的可写层北极加载到镜像的顶部。这一层被称作“容器层”，容器层之下的叫“镜像层”

    

