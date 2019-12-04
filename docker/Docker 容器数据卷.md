# Docker 容器数据卷

---

## 数据卷是什么

    数据卷就是用来持久化使用的，拷贝资料的活动硬盘
    类似redis 的 RDB 与 AOF

## 数据卷的特点

    1.数据卷可以在容器之间共享或重用数据
    2.卷中的更改可以直接生效
    3.数据卷中的更改不会包含在镜像的更新中
    4.数据卷的生命周期一直维持到没有容器使用它为止
    5.主机修改后数据同步

## 数据卷的添加

添加数据卷

    doccker run -it -v [/hostPath]:[/containPath] [imagename]

    eg:
    有读写权限的数据卷
    docker run -it -v /myDataVolume:/dataVolumeContainer [imagename]
    只读权限的数据卷
    docker run -it -v /myDataVolume:/dataVolumeContainer:ro [imagename]
    加了只读以后只允许主机单向的写操作

    如果遇到加载数据卷权限问题 append --privileged=true
    docker run -it -v /myDataVolume:/dataVolumeContainer --privileged=true [imagename]


## Dockerfile 添加数据卷


例子：
```shell
touch dockerfile
```

```dockerfile
# volume test
From centos
Volume ["dataVolumeContainer1","/dataVolumeContainer2"]
CMD echo "finished,-----------success"
CMD /bin/bash
```

build dockerfile

    docker build -f [path] -t [namespace]/[imagename] [new imagepath]

查看docker 数据卷内部详情

    docker inspect 此命令可查看挂在情况


## 数据卷容器

什么是数据卷容器

    命名的容器挂载数据卷，其它容器荣国挂载这个（父容器）实现数据共享，挂载数据卷的容器，称之为数据卷容器。

容器间数据共享

列子

    docker run -it --name dc01 zhouchong/centos (父容器)

    docker run -it --name dc02 --volumes-from dc01 zhouchong/centos (子容器)

    docker run -it --name dc03 --volumes-from dc01 zhouchong/centos (子容器)


