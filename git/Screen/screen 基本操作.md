# Screen 基本操作

---
1 Debian 安装screen

    sudo apt install screen

2 新建一个窗口会话

    screen -S

3.挂起挡墙窗口

    ctrl + A + D

4.查询当前会话记录（所有挂起窗口）

    screen -ls

5.退出当前会话

    ctrl + a && ctrl + d

6.重新连接某个会话 id

    screen -r id 4.可以查看会话id

7.停止某个会话 id

    screen -X -S quit