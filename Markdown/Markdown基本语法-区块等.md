# **Markdown 区块**

Markdown 区块使用的是在段落开头使用 > 符号，然后后面紧跟空格符号：

> \> 区块引用
> \> 区块教程
> \> 学于菜鸟

显示效果如下：

> 区块引用
> 区块教程
> 学于菜鸟


# **Markdown 代码**

使用 ``` 包裹一段代码，并制定一种语言：
\`\`\`java
System.out.println("aaaa")
\`\`\`

显示效果如下：
```java
    System.out.println("aaaa")
```

## **Markdown 链接**

语法：
>    \[链接名字](https://www.baidu.com)
>     or
>   \<https://www.baidu.com>

效果如下：

>    [链接名字](https://www.baidu.com)
>     or
>   <https://www.baidu.com>

### **高级链接地址**
语法：
> 链接地址使用变量来待敌，文档末尾附带变量地址：
> 这个链接用 1 作为网址变量 [google][1]
> 这个使用 baidu 作为网址变量 [百度][baidu]
> 在文档的结尾为变量赋值 (url)


[1]: http://www.google.com/
[baidu]: https://www.baidu.com

