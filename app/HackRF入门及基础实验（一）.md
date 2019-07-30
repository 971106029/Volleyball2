# HackRF One 环境搭建和基础工程“Helloword”
环境搭建遇坑总结
HackRF One 最兼容的系统应该是Ubuntu系统，版本号为：14.04.6
网上可能说虚拟机可能驱动不了HackRF One   但是经过实践发现HackRF One是可以在虚拟机上驱动的。




## **搭建环境**
###**第一步** 
下载分区助手，准备为Ubuntu虚拟机单独创建一个小的分区。（跟着网上的教程来的，我其实觉得跳过这一步应该也可行，但是没有实际的尝试）

我的百度网盘资源下载地址：https://pan.baidu.com/s/1oSaUizVRJOiDBNG5Xcc8BQ  
提取码：15me

下载后打开解压文件夹。选择目标磁盘，右击选择切割分区。以切割出适当分区大小。

![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%871.png?raw=true)


![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%872.png?raw=true)

###**第二步** 
下载VMware Workstation Pro 14 版本。并且下载Ubuntu14.04.6版本镜像。


Ubuntu14.04.6版本镜像
下载地址：https://pan.baidu.com/s/1mehclVCNzblI4J-aybN_aQ 提取码：vhv4


VMware Workstation Pro 14 版本
下载地址：https://pan.baidu.com/s/147OSn5eMASL1f5g-jurE-A 提取码：mh71 （此版本下载后需要破解，破解教程链接：https://blog.csdn.net/sinat_34104446/article/details/82718153）

破解需要注册码文件，注册码如下：


###**第三步** 
打开VM软件创建新的虚拟机。（为防止踩坑，最好使用管理员模式打开VM）
第四步：Ubuntu虚拟机网络环境配置。是个大坑。
配置详细教程链接：https://blog.csdn.net/tiramisu_L/article/details/80557772

大致过程是先配置静态的IP地址和默认网关。然后配置DNS解析。

我遇到的坑是每此重启之后。都需要重新配置一次DNS 。否则就会出现不能上网的情况。不过百度后发现有方法可以固话DNS配置。（未尝试，请自行百度）


###**第四步** 
HackRF One 环境搭建：
打开终端，依次执行以下内容：
####一、添加源：
```
        sudo add-apt-repository -y ppa:bladerf/bladerf
        sudo add-apt-repository -y ppa:myriadrf/drivers
        sudo add-apt-repository -y ppa:myriadrf/gnuradio
        sudo add-apt-repository -y ppa:gqrx/gqrx-sdr
```
####二、更新系统：
```
        sudo apt-get update
        sudo apt-get upgrade
```

####三、安装所需的软件包
```
        sudo apt-get install gnuradio
        sudo apt-get install gr-osmosdr
        sudo apt-get install hackrf
        sudo apt-get install gqrx-sdr
        sudo apt-get install libhackrf-dev
```


----

 **刚开始疑惑为什么HackRF One 的五个指示灯有的时候亮只亮三个，有的时候亮四个。后来发现指示灯亮四个的时候要么HackRF One 处于发送状态，要么HackRF One处于接收状态。**


----





所以指示灯的最后两个灯（RX和TX指示灯）要么全不亮，（此时HackRF 处于初始化完成准备工作阶段）。要亮也只能亮其中一个，（要么处于发射信号，要么是信号接收状态）。不可能两个信号灯同时亮，（当然这是指使用的是出厂的时候的固件，而不是自己重新刷写固件）。因为HackRF One 是半双工工作。（一个时间段内只能接收或者发送，而不能同时进行）



##如何测试HackRF One环境是否已搭建好？
终端下输入Gqrx，打开Gqrx，会弹软件使用配置界面，然后查看使用的硬件是否已经便车给HackRF One 。
然后打开软件后调整到国内的FM 107 广播下，看是否能收听到广播。
如果能看到看到频谱图上有明显抖动反应，但是听不到声音的话，可以首先将虚拟机内的音量调高。如果此时还听不到声音，估计是虚拟机没有和主机共享声卡，这时可以到百度上查询如何配置。


![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE3.png?raw=true)


****


##Gnuradio初体验遇坑？
###遇坑一：
搭建好最初的程序流程图的时候发现WX GUI FFT Sink 报红。


![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%873.png?raw=true)


#####错误原因：
流程图中的Options选项卡中Generate Option选项默认选择的构建GUI程序的架构是QT GUI(如果想要使用QT架构的流程图，必须现在虚拟机上装QT，我没有进行尝试进行，可自行百度)，但是流程图搭建过程中使用到的程序框图选择的搭建的基础架构是WX GUI

#####解决方式：
双击图中Options 配置Generate Options 为对应与报红行的 WXGUI 

![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%874.png?raw=true)

![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%875.png?raw=true)



###遇坑二：
创建入门级流图想要观察频谱变化图的时候。无法显示频谱变化图（只藏在左上角，无法显示）


![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%876.png?raw=true)


#####解决方式：
双击打开osmocom Source 配置 在Device Arguments中输入小写的 hackrf 


![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%877.png?raw=true)

![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%878.png?raw=true)


-----

如果还没有解决，原因可能是HackRF One USB接口松了  检查HackRF One 连线问题。
遇坑三：第一次跑出频谱图之后，再次运行的时候，发现频谱图框架还在，但是接收不到任何波形。
#####解决方式：将HackRF One USB口重新插拔。


出现此问题的原因是在第一次运行成功过之后  直接了频谱图界面的关闭按钮关闭，而没有使用Gnuradio软件中的退出运行按键关闭，而导致HackRF One 没有正常的回到初始化准备工作状态，所以需要使用Gnuradio 软件上的推出运行按钮正常停止运行程序。

![image](https://github.com/971106029/volleyball2/blob/master/app/src/main/res/drawable/%E5%9B%BE%E7%89%879.png?raw=true)


------